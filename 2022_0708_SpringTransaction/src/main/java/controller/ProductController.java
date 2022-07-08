package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ProductService;
import vo.ProductVo;

@Controller
@RequestMapping("/product/")
public class ProductController {

	ProductService product_service;

	public void setProduct_service(ProductService product_service) {
		this.product_service = product_service;
	}

	@RequestMapping("list.do")
	public String list(Model model) {
		Map map = product_service.selectList();
		model.addAttribute("map", map);
		return "product/product_list";
	}

	// product/insert_in.do?name=TV&cnt=100
	@RequestMapping("insert_in.do")
	public String insert_in(ProductVo vo, Model model) {

		try {
			int res = product_service.insert_in(vo);
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println(message);
			model.addAttribute("error",message);
		}

		return "redirect:/product/list.do";
	}

	// product/insert_in.do?name=TV&cnt=100
	@RequestMapping("insert_out.do")
	public String insert_out(ProductVo vo, Model model) {

		try {
			int res = product_service.insert_out(vo);
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println(message);
			model.addAttribute("error",message);
		}

		return "redirect:/product/list.do";
	}

}
