package com.dh.home.product;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dh.home.util.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.product}")
	private String path;
	
	
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
					log.info("productVO => {}",productVO);
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
		log.info(productVO.toString());
		int result =  productMapper.setProduct(productVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		
		for(MultipartFile f: productVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("productVO => {}",productVO);
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
