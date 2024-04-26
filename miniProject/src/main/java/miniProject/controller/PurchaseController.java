package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import miniProject.service.purchase.PurchaseListService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	@Autowired
	PurchaseListService purchaseListService;
	@GetMapping("purchase")
	public String purchaseList(String goodsNum, Model model) {
		purchaseListService.execute(goodsNum, model);
		return "thymeleaf/wish/purchaseList";
	}
}
