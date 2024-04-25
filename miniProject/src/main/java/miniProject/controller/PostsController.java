package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import miniProject.command.PostsCommand;
import miniProject.service.posts.PostsAutoNumService;
import miniProject.service.posts.PostsDeleteService;
import miniProject.service.posts.PostsDetailService;
import miniProject.service.posts.PostsListService;
import miniProject.service.posts.PostsUpdateService;
import miniProject.service.posts.PostsWriteService;

@Controller
@RequestMapping("posts")
public class PostsController {
	@Autowired
	PostsListService postsListService;
	@Autowired
	PostsWriteService postsWriteService;
	@Autowired
	PostsDetailService postsDetailService;
	@Autowired
	PostsUpdateService postsUpdateService;
	@Autowired
	PostsDeleteService postsDeleteService;
	@Autowired
	PostsAutoNumService postsAutoNumService;
	@GetMapping("postsList")
	public String profile(String memberId, Model model) {
		postsListService.execute(memberId, model);
		return "thymeleaf/posts/postsList";
	}
	@GetMapping("postsWrite")
	public String profileWrite(PostsCommand postsCommand, Model model) {
		postsAutoNumService.execute(postsCommand, model);
		return "thymeleaf/posts/postsForm";
	}
	@PostMapping("postsRegist")
	public String postRegist(PostsCommand postsCommand, HttpSession session) {
		postsWriteService.execute(postsCommand, session);
		return "redirect:postsList";
	}
	@GetMapping("postsDetail")
	public String postsDetail(@RequestParam("postsNum") String postsNum, @RequestParam("memberNum") String memberNum, Model model, HttpSession session) {
		postsDetailService.execute(postsNum, memberNum, model, session);
		return "thymeleaf/posts/postsDetail";
	}
	@GetMapping("postsUpdate")
	public String postsUpdate(@RequestParam("postsNum") String postsNum, @RequestParam("memberNum") String memberNum, Model model, HttpSession session) {
		postsDetailService.execute(postsNum, memberNum, model, session);
		return "thymeleaf/posts/postsModify";
	}
	@PostMapping("postsUpdate")
	public String postsUpdate(PostsCommand postsCommand, HttpSession session) {
		postsUpdateService.execute(postsCommand, session);
		return "redirect:postsDetail?postsNum=" + postsCommand.getPostsNum();
	}
	@GetMapping("postsDelete")
	public String postsDelete(String postsNum) {
		postsDeleteService.execute(postsNum);
		return "redirect:postsList";
	}
}
