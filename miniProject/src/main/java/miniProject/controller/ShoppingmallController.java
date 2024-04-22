package miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shoppingmall")
public class ShoppingmallController {
	@GetMapping("shoppingmallMain")
	public String shoppingmall() {
		return "thymeleaf/shoppingmall/shoppingmall";
	}
	@GetMapping("goodsMain")
	public String goods() {
		return "thymeleaf/goods/goodsInfo";
	}
}
