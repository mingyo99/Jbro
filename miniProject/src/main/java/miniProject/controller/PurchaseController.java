package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.command.PurchaseCommand;
import miniProject.service.purchase.PurchaseListService;
import miniProject.service.purchase.PurchaseWriteService;

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
	@Autowired
	PurchaseWriteService purchaseWriteService;
	@PostMapping("order")
	public String order(PurchaseCommand command,HttpSession session) {
		purchaseWriteService.execute(command, session);
		return "redirect:/wish/wishList";
	}
}
