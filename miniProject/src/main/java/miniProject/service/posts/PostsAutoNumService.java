package miniProject.service.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.command.PostsCommand;
import miniProject.mapper.AutoMapper;

@Service
public class PostsAutoNumService {
	@Autowired
	AutoMapper autoMapper;
	public void execute(PostsCommand postsCommand, Model model) {
		String postsNum = autoMapper.autoNumSelect("POSTS", "POSTS_NUM", "pos");
		postsCommand.setPostsNum(postsNum);
		model.addAttribute("postsCommand", postsCommand);
	}
}
