package com.dh.home.product;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductImageVO {
	
	private Long fileNum;
	private String fileName;
	private String oriName;
	private Long itemNum;
}
