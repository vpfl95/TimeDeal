package com.dh.home;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dh.home.product.ProductMapper;
import com.dh.home.product.ProductService;
import com.dh.home.product.ProductVO;

@SpringBootTest
class TimeDealApplicationTests {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductMapper productMapper;
	
	
	@Test
	void threadTest()throws Exception {
		int threadCount = 11;
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		CountDownLatch latch = new CountDownLatch(threadCount);
		ProductVO productVO = new ProductVO();
		productVO.setItemNum(1L);
		
		for(int i=0; i<threadCount; i++) {
			executorService.submit(()->{
				try {		
					productService.buyPrd(productVO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					latch.countDown();
				}
			});
		}
		latch.await();
		
		Long ea = productMapper.buyCheckEA(10L);
		
		assertEquals(0L, ea);
	}

}
