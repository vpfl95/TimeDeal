package com.dh.home.order;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	public Long checkOrder(OrderVO orderVO)throws Exception; 
	public int buyOrder(OrderVO orderVO)throws Exception;
}
