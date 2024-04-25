package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.service.goods.GoodsDetailService;
import miniProject.service.goods.GoodsDetailViewService;
import miniProject.service.shoppingmall.ShoppingmallGoodsListService;

@Controller
@RequestMapping("shoppingmall")
public class ShoppingmallController {
	@Autowired
	ShoppingmallGoodsListService shoppingmallGoodsListService;
	@Autowired
	GoodsDetailViewService goodsDetailViewService;
	@GetMapping("shoppingmallMain")
	public String shoppingmall(Model model) {
		shoppingmallGoodsListService.execute(model);
		return "thymeleaf/shoppingmall/shoppingmall";
	}
	@Autowired
	GoodsDetailService goodsDetailService;
	@GetMapping("goodsSebu")
	public String goodsSebu(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/shoppingmall/goodsSebu";
	}
	@GetMapping("top")
	public String top() {
		return "thymeleaf/shoppingmall/top";
	}
	@GetMapping("outer")
	public String outer() {
		return "thymeleaf/shoppingmall/outer";
	}
	@GetMapping("jeans")
	public String jeans() {
		return "thymeleaf/shoppingmall/jeans";
	}
	@GetMapping("slacks")
	public String slacks() {
		return "thymeleaf/shoppingmall/slacks";
	}
	@GetMapping("shorts")
	public String shorts() {
		return "thymeleaf/shoppingmall/shorts";
	}
	@GetMapping("trainingPants")
	public String trainingPants() {
		return "thymeleaf/shoppingmall/trainingPants";
	}
	@GetMapping("shoes")
	public String shoes() {
		return "thymeleaf/shoppingmall/shoes";
	}
	@GetMapping("sports")
	public String sports() {
		return "thymeleaf/shoppingmall/sports";
	}
	@GetMapping("caps")
	public String caps() {
		return "thymeleaf/shoppingmall/caps";
	}
	@GetMapping("etc")
	public String etc() {
		return "thymeleaf/shoppingmall/etc";
	}
}
