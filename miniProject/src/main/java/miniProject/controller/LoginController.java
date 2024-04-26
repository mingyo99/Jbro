package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.command.LoginCommand;
import miniProject.service.login.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@GetMapping("login")
	public String login(@Validated LoginCommand loginCommand, BindingResult result) {
		
		return "thymeleaf/login/login";
	}
	@PostMapping("loginOk")
	public String loginOk(@Validated LoginCommand loginCommand, BindingResult result, HttpSession session) {
		loginService.execute(loginCommand, result, session);
		if(result.hasErrors()) {
			return "thymeleaf/login/login";
		}
		return"redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
}
