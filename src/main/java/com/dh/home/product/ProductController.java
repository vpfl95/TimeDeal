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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//상품 상세
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
