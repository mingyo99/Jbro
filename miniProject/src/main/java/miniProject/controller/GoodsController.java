package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import miniProject.command.GoodsCommand;
import miniProject.service.goods.GoodsAutoNumService;
import miniProject.service.goods.GoodsDeleteService;
import miniProject.service.goods.GoodsDetailService;
import miniProject.service.goods.GoodsListService;
import miniProject.service.goods.GoodsOderListService;
import miniProject.service.goods.GoodsUpdateService;
import miniProject.service.goods.GoodsWriteService;
import miniProject.service.goods.ProductsDeleteService;
@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsAutoNumService goodsAutoNumService;
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping(value="goodsList" , method=RequestMethod.GET)
	public String  goodsList(
			@RequestParam(value="searchWord" , required = false) String searchWord,
			@RequestParam(value = "page" , required = false , defaultValue = "1") int page,
			@RequestParam(value="item", required = false) String item, /// ipgo
			Model model) {
		model.addAttribute("item", item);
		goodsListService.execute(searchWord, model, page);
		return "thymeleaf/goods/goodsList";
	}
	@GetMapping("goodsForm")
	public String goodsForm() {
		return "thymeleaf/goods/goodsWrite";
	}
	@GetMapping("goodsWrite")
	public String goodsWrite(Model model) {
		goodsAutoNumService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	@Autowired
	GoodsWriteService goodsWriteService;
	@RequestMapping(value="goodsWrite" , method=RequestMethod.POST)
	public String goodsWrite(@Validated GoodsCommand goodsCommand,BindingResult result
			,HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		if(goodsCommand.getGoodsMainStore().getOriginalFilename().isEmpty()) {
			result.rejectValue("goodsMainStore", "goodsCommand.goodsMainStore"
					, "이미지를 선택해주세요.");
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand, session);
		
		//return "redirect:goodsList";
		//오류가 없는 경우 goodsForm.html을 넘겨주고 정상이면 goodsRedirect.html을 넘겨준다.
		return "thymeleaf/goods/goodsRedirect";
	}
	@Autowired
	ProductsDeleteService productsDeleteService;
	@PostMapping("productsDelete")
	public String productsDelete(//체크박스에 의해 전달 된 값을 배열로 받습니다.
			@RequestParam(value = "nums") String memDels[]) {
		productsDeleteService.execute(memDels);
		return "redirect:goodsList";
	}
	@Autowired
	GoodsDetailService goodsDetailService;
	@GetMapping("goodsDetail")
	public String goodsDetail(@RequestParam("goodsNum") String goodsNum
			,Model model,HttpSession session) {
		session.removeAttribute("fileList");
		goodsDetailService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsInfo";
	}
	@GetMapping("goodsUpdate")
	public String goodsUpdate(@RequestParam("goodsNum") String goodsNum, Model model
			, HttpSession session) {
		// 삭제할 파일을 선택한 후 다시 수정페이지로 오면 삭제할 파일정보를 가진 session이 존재하여 오류의 소지가 있다.
		// 그래서 수정 페이지에 오면 삭제할 파일정보를 가진 session을 제거 하는 것이 좋다. 
		session.removeAttribute("fileList"); // 삭제할 파일 정보를 가지고 있는 session삭제
		goodsDetailService.execute(goodsNum, model, session);//수정을 하려면 기본 정보를 가져와야 하므로 goodsDetailService를 사용
		return "thymeleaf/goods/goodsModify";
	}
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@PostMapping("goodsUpdate")
	public String goodsUpdate(@Validated GoodsCommand goodsCommand,BindingResult result,
			HttpSession session, Model model) {
		goodsUpdateService.execute(goodsCommand, session, result, model);
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsModify";
		}
		return "redirect:goodsDetail?goodsNum="+goodsCommand.getGoodsNum();
	}
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@RequestMapping("goodsDel/{goodsNum}")
	public String goodsDel(@PathVariable("goodsNum") String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:../goodsList"; //PathVariable인 경우에는 주소 앞에 .. 을 꼭해줘야 합니다.
	}
	@Autowired
	GoodsOderListService goodsOderListService;
	@GetMapping("goodsOderList")
	public String goodsOderList(Model model) {
		goodsOderListService.execute(model);
		return "thymeleaf/goods/goodsOderList";
	}
}
