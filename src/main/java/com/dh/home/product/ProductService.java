package com.dh.home.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	public int setProduct(ProductVO productVO)throws Exception{
		return productMapper.setProduct(productVO);
	}
}
