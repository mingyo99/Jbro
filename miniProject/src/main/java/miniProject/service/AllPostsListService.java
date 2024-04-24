package miniProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.PostsDTO;
import miniProject.mapper.PostsMapper;

@Service
public class AllPostsListService {
	@Autowired
	PostsMapper postsMapper;
	public void execute(Model model) {
		List<PostsDTO> list = postsMapper.postsAllSelectList();
		model.addAttribute("list", list);
	}
}
