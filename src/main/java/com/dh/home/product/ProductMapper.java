package com.dh.home.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public List<ProductVO> getProduct(String id)throws Exception;
	public int setFileAdd(ProductImageVO productImageVO)throws Exception;
	public int setProduct(ProductVO productVO)throws Exception;
}
