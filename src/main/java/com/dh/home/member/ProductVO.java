package com.dh.home.member;

import java.sql.Time;

import lombok.Data;

@Data
public class ProductVO {
	private int itemNum;
	private String itemName;
	private int ea;
	private Time startTime;
	private Time endTime;
	private String id;
}
