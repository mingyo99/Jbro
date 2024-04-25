package miniProject.service.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.PostsDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PostsMapper;

@Service
public class PostsListService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PostsMapper postsMapper;
	public void execute(String memberId, Model model) {
		model.addAttribute("memberId", memberId);
		
		MemberDTO dto = memberMapper.memberSelectOne(memberId);
		List<PostsDTO> list = postsMapper.postsSelectList(dto.getMemberNum());
		model.addAttribute("list", list);
	}
}
