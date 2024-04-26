package miniProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.CategoryDTO;
import miniProject.domain.PostsDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PostsMapper;

@Service
public class AllPostsListService {
	@Autowired
	PostsMapper postsMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(String gender, String height, String weight, Model model) {
		//카테고리
		CategoryDTO dto = new CategoryDTO();
		dto.setGender(gender);
		dto.setHeight(height);
		dto.setWeight(weight);
		List<PostsDTO> list = postsMapper.postsAllSelectList(dto);
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("weight", weight);
		model.addAttribute("height", height);
		model.addAttribute("gender", gender);
	}
}
