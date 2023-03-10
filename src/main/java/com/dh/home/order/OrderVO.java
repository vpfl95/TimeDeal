package com.dh.home.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderVO {
	private Long orderNum;
	private String id;
	private Long itemNum;
}
