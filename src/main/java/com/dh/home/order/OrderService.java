package com.dh.home.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	public Long checkOrder(OrderVO orderVO)throws Exception{
		return orderMapper.checkOrder(orderVO);
	}
	
	public int buyOrder(OrderVO orderVO)throws Exception{
		return orderMapper.buyOrder(orderVO);
	}
}
