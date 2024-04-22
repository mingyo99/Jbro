package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String login() {
		return "thymeleaf/login/login";
	}
	@PostMapping("loginOk")
	public String loginOk(LoginCommand loginCommand, HttpSession session) {
		loginService.execute(loginCommand, session);
		return"redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
}
