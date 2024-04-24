package miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import miniProject.service.posts.PostsLikeService;

@RestController
@RequestMapping("item")
public class ItemRestController {
	@Autowired
	PostsLikeService postsLikeService;
	
	@PostMapping("postslikeAddDel")
	public String postslikeAddDel(String postsNum, HttpSession session) {
		return postsLikeService.execute(postsNum, session);
	}
}
