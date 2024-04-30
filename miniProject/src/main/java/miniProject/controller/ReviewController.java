package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.service.review.ReviewSelectOneService;
import miniProject.service.review.ReviewWriteService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	ReviewSelectOneService reviewSelectOneService;
	@GetMapping("goodsReview")
	public String goodsReview(@ModelAttribute("goodsNum") String goodsNum, @ModelAttribute("purchaseNum") String purchaseNum, Model model) {
		reviewSelectOneService.execute(goodsNum, purchaseNum, model);
		return "thymeleaf/review/goodsReview";
	}
	@PostMapping("reviewWrite")
	public String reviewWrite(String goodsNum, String purchaseNum, String reviewContent, HttpSession session) {
		reviewWriteService.execute(goodsNum, purchaseNum, reviewContent, session);
		return "redirect:/shoppingmall/goodsSebu?goodsNum=" + goodsNum;
	}
}
