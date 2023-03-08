package com.dh.home.product;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	private int itemNum;
	private String itemName;
	private int ea;
	@DateTimeFormat(pattern = "HH:mm")
	private Date startTime;
	@DateTimeFormat(pattern = "HH:mm")
	private Date endTime;
	private String id;
	private MultipartFile[] files;
	private List<ProductImageVO> fileVOs;
}
