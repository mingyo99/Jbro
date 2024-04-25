package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.service.cart.CartListService;

@Controller
@RequestMapping("wish")
public class WishController {
	@Autowired
	CartListService cartListService;
	@GetMapping("wishList")
	public String wishList(String goodsNum, Model model, HttpSession session) {
		cartListService.execute(goodsNum, model, session);
		return "thymeleaf/cart/wishList";
	}
}
