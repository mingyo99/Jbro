package miniProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import miniProject.command.CommentCommand;
import miniProject.domain.CommentDTO;
import miniProject.service.comment.CommentAddService;
import miniProject.service.posts.PostsLikeService;

@RestController
@RequestMapping("item")
public class ItemRestController {
	@Autowired
	PostsLikeService postsLikeService;
	@Autowired
	CommentAddService commentAddService;
	@PostMapping("postslikeAddDel")
	public Map<String, String> postslikeAddDel(String postsNum, HttpSession session) {
		Map<String, String> map = postsLikeService.execute(postsNum, session);
		System.out.println(map.get("likeCount"));
		System.out.println(map.get("allLikeCount"));
		return map;
	}
	@PostMapping("comment")
	public List<CommentDTO> comment( CommentCommand commentCommand, HttpSession session) {
		return commentAddService.execute(commentCommand, session);
	}
}
