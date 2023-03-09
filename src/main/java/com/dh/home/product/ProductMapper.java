package com.dh.home.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public int setFileDelete(String fileNum)throws Exception;
	public int updateProduct(ProductVO productVO)throws Exception;
	public ProductVO findByItemNum(String itmeNum)throws Exception;
	public List<ProductVO> getAllProduct()throws Exception;
	public List<ProductVO> getProduct(String id)throws Exception;
	public int setFileAdd(ProductImageVO productImageVO)throws Exception;
	public int setProduct(ProductVO productVO)throws Exception;
}
