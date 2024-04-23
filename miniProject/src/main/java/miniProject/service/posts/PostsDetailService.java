package miniProject.service.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.PostsDTO;
import miniProject.mapper.PostsMapper;

@Service
public class PostsDetailService {
	@Autowired
	PostsMapper postsMapper;
	public void execute(String postsNum, Model model) {
		PostsDTO dto = postsMapper.postsSelectOne(postsNum);
		model.addAttribute("postsCommand", dto);
	}
}
