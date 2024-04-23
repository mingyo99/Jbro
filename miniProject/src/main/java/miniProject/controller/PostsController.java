package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import miniProject.command.PostsCommand;
import miniProject.service.posts.PostsListService;
import miniProject.service.posts.PostsWriteService;

@Controller
@RequestMapping("posts")
public class PostsController {
	@Autowired
	PostsListService postsListService;
	@Autowired
	PostsWriteService postsWriteService;
	@GetMapping("postsList")
	public String profile(HttpSession session, Model model) {
		postsListService.execute(session, model);
		return "thymeleaf/profile/postsList";
	}
	@GetMapping("postsWrite")
	public String profileWrite() {
		return "thymeleaf/profile/postsForm";
	}
	@PostMapping("postsRegist")
	public String postRegist(PostsCommand postsCommand, HttpSession session) {
		postsWriteService.execute(postsCommand, session);
		return "redirect:postsList";
	}
}
