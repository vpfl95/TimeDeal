package com.dh.home.product;

import java.io.Console;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dh.home.member.MemberService;
import com.dh.home.order.OrderService;
import com.dh.home.order.OrderVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderService orderService;
	
	// 상품 구매
	@PostMapping("/buy")
	@ResponseBody
	public Boolean buyPrd(ProductVO productVO, @RequestParam("id") String id)throws Exception{
		log.info("===============상품 구매===============");
		OrderVO orderVO = OrderVO.builder()
				.id(id)
				.itemNum(productVO.getItemNum())
				.build();
		
		// 구매 여부 확인
		if(!orderService.checkOrder(orderVO)) {
			log.info("이미 구매 했음");
			return false;
		}
		
		// 상품 구매
		boolean result = productService.buyPrd(productVO);
		
		//주문서 기록
		if(result) {
			orderService.buyOrder(orderVO);
			log.info("주문 완료");
		}
		return result;
	}
	
	//상품 이미지 삭제
	@DeleteMapping("/{fileNum}")
	@ResponseBody
	public int deleteFile(@PathVariable("fileNum") String fileNum, ModelAndView mv)throws Exception {
		int result = productService.setFileDelete(fileNum);
		
		return result;
	} 	
	
	
	//상품 상세
	@GetMapping("/{itemNum}")
	public ModelAndView findByitemNum(@PathVariable("itemNum") String itemNum, ModelAndView mv)throws Exception {
		ProductVO productVO = productService.findByItemNum(itemNum);
		mv.addObject("productVO",productVO);
		mv.setViewName("/product/detail");
		return mv;
	} 	
	
	//상품 수정
	@GetMapping("add/{itemNum}")
	public ModelAndView updateProduct(@PathVariable("itemNum") String itemNum, ModelAndView mv)throws Exception{
		ProductVO productVO = productService.findByItemNum(itemNum);
		log.info("===========================");
		log.info("productVO {}=>",productVO);
		log.info("===========================");
		mv.addObject("productVO",productVO);
		mv.setViewName("/product/update");
		return mv;
	}
	@PutMapping("add/{itemNum}")
	public String updateProduct(@PathVariable("itemNum") String itemNum, ProductVO productVO, ModelAndView mv)throws Exception{
		int result = productService.updateProduct(productVO);
		
		return "redirect:/";
	}

	//상품 등록
	@GetMapping("add")
	public void setProduct()throws Exception{}
	@PostMapping("")
	public String setProduct(ProductVO productVO, HttpSession session)throws Exception{
		session.getAttribute("member");
		log.info("==============================");
		log.info("productVO=>{}",productVO);
		log.info("==============================");
		int result = productService.setProduct(productVO);
		return "redirect:/admin/product";
	}
}
