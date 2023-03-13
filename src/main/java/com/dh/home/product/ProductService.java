package com.dh.home.product;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dh.home.member.MemberMapper;
import com.dh.home.util.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private MemberMapper memberMapper;
	@Value("${app.product}")
	private String path;
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Boolean buyPrd(ProductVO productVO)throws Exception{
		//log.info("===============상품 구매 서비스===============");
		System.out.println(Thread.currentThread().getName()+ "===============상품 구매 서비스===============");
		
		Long EA = productMapper.buyCheckEA(productVO.getItemNum());
		//log.info("재고 확인=>{}",EA);
		System.out.println(Thread.currentThread().getName() + "재고확인" +EA);
		
		if(EA>0) {
			EA--;
			productVO.setEa(EA);
			int result = productMapper.buyPrd(productVO);
			//log.info("구매");
	
			
			if(result==1) {
				EA = productMapper.buyCheckEA(productVO.getItemNum());
				System.out.println(Thread.currentThread().getName() + "구매 성공"+ "=>"+ "남은재고" +EA);
				return true;				
			}
		}
		System.out.println(Thread.currentThread().getName() + "구매 실패 !!!!");
		
		return false;
	}
	
	
	public int setFileDelete(String fileNum)throws Exception{
		return productMapper.setFileDelete(fileNum);
	}
	
	
	public int updateProduct(ProductVO productVO)throws Exception{
		int result = productMapper.updateProduct(productVO);
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		if(productVO.getFiles()!=null) {
			for(MultipartFile f: productVO.getFiles()) {
				if(!f.isEmpty()) {

					String fileName = fileManager.saveFile(f, path);
					
					ProductImageVO productImageVO = new ProductImageVO();
					productImageVO.setItemNum(productVO.getItemNum());
					productImageVO.setFileName(fileName);
					productImageVO.setOriName(f.getOriginalFilename());
					
					productMapper.setFileAdd(productImageVO);
				}
			}
			
		}
		return result;
	}
	
	public ProductVO findByItemNum(String itmeNum)throws Exception{
		return productMapper.findByItemNum(itmeNum);
	}
	
	public List<ProductVO> getAllProduct()throws Exception{
		return productMapper.getAllProduct();
	}
	
	public List<ProductVO> getProduct(String id)throws Exception{
		return productMapper.getProduct(id);
	}
	
	public int setProduct(ProductVO productVO)throws Exception{
	
		int result =  productMapper.setProduct(productVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		
		for(MultipartFile f: productVO.getFiles()) {
			if(!f.isEmpty()) {
			
				String fileName = fileManager.saveFile(f, path);
				
//				ProductImageVO productImageVO = ProductImageVO.builder()
//												.itemNum(productVO.getItemNum())
//												.fileName(fileName)
//												.oriName(f.getOriginalFilename())
//												.build();
				ProductImageVO productImageVO = new ProductImageVO();
				productImageVO.setItemNum(productVO.getItemNum());
				productImageVO.setFileName(fileName);
				productImageVO.setOriName(f.getOriginalFilename());
				
				productMapper.setFileAdd(productImageVO);
			}
		}
		return result;
	}
}
