package miniProject.service.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class PostsListService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO dto = memberMapper.memberSelectOne(auth.getUserId());
		model.addAttribute("dto", dto);
	}
}
