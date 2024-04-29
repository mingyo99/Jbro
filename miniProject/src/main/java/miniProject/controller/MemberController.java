package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.command.MemberCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.service.member.MemberAutoNumService;
import miniProject.service.member.MemberDeleteService;
import miniProject.service.member.MemberDetailService;
import miniProject.service.member.MemberListService;
import miniProject.service.member.MemberUpdateService;
import miniProject.service.member.MemberWriteService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberAutoNumService memberAutoNumService;
	@GetMapping("memberAgree")
	public String memberAgree() {
		return "thymeleaf/member/memberAgree";
	}
	@PostMapping("memberWrite")
	public String memberWrite(Model model) {
		memberAutoNumService.execute(model);
		return "thymeleaf/member/memberForm";
	}
	@PostMapping("memberRegist")
	public String memberRegist(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		if(!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호 확인이 일치하지 않습니다.");
			System.out.println("asd");
			return "thymeleaf/member/memberForm";
		}
		memberWriteService.execute(memberCommand);
		return "redirect:/";
	}
	@GetMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	@GetMapping("memberDetail")
	public String memberDetail(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberDetail";
	}
	@GetMapping("memberUpdate")
	public String memberUpdate(String memberNum, Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberModify";
	}
	@PostMapping("memberUpdate")
	public String memberUpdate(@Validated MemberCommand memberCommand, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberModify";
		}
		memberUpdateService.execute(memberCommand);
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth.getGrade().equals("emp")) {
			return "redirect:memberDetail?memberNum=" + memberCommand.getMemberNum();
		}else {
			return "redirect:/posts/postsList?memberId=" + auth.getUserId();
		}
		
	}
	@GetMapping("memberDelete")
	public String memberDelete(String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:memberList";
	}
}
