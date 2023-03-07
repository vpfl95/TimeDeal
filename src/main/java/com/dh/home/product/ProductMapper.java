package com.dh.home.product;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public int setProduct(ProductVO productVO)throws Exception;
}
