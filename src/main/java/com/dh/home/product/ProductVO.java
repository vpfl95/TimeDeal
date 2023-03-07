package com.dh.home.product;

import java.sql.Time;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
}
