package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.mapper.PurchaseMapper;
import miniProject.service.order.OrderListService;
@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	OrderListService orderListService;
	@Autowired
	PurchaseMapper purchaseMapper;
	@GetMapping("orderList")
	public String orderList(HttpSession session, Model model) {
		orderListService.execute(session, model);
		return "thymeleaf/wish/orderList";
	}
	@GetMapping("orderOk")
	public String orderOk(String purchaseNum) {
		purchaseMapper.purchaseStatusUpdate(purchaseNum, "배송완료");
		return "redirect:/goods/goodsOderList";
	}
	@GetMapping("purchaseOk")
	public String purchaseOk(String purchaseNum) {
		purchaseMapper.purchaseStatusUpdate(purchaseNum, "구매확정");
		return "redirect:/order/orderList";
	}
}
