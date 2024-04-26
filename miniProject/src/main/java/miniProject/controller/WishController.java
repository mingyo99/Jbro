package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import miniProject.service.wish.GoodsWishService;
import miniProject.service.wish.WishInsertService;
import miniProject.service.wish.WishListService;

@Controller
@RequestMapping("wish")
public class WishController {
	@Autowired
	WishListService wishListService;
	@GetMapping("wishList")
	public String wishList(String goodsNum, Model model, HttpSession session) {
		model.addAttribute("goodsNum", goodsNum);
		wishListService.execute(goodsNum, model, session);
		return "thymeleaf/wish/wishList";
	}
	@Autowired
	WishInsertService wishInsertService;
	@GetMapping("wishwrite")
	public String wishWrite(String goodsNum, HttpSession session) {
		wishInsertService.execute(goodsNum, session);
		return "thymeleaf/wish/wishList";
	}
	@Autowired
	GoodsWishService goodsWishService;
	@PostMapping("wishAdd")
	@ResponseBody
	public String wishAdd( String goodsNum,HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
}