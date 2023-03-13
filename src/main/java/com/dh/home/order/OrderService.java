package com.dh.home.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	public Boolean checkOrder(OrderVO orderVO)throws Exception{
		Long result = orderMapper.checkOrder(orderVO);
		if(result>0) {
			return false;
		}
		return true;
	}
	
	public int buyOrder(OrderVO orderVO)throws Exception{
		return orderMapper.buyOrder(orderVO);
	}
}
