package miniProject.service.posts;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.PostsDTO;
import miniProject.mapper.LikeMapper;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PostsMapper;

@Service
public class PostsDetailService {
	@Autowired
	PostsMapper postsMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	LikeMapper likeMapper;
	public void execute(String postsNum, Model model, HttpSession session) {
		PostsDTO dto = postsMapper.postsSelectOne(postsNum);
		model.addAttribute("postsCommand", dto);
		
		String allLikeCount = likeMapper.likeCountSelectAll(postsNum).toString();
		model.addAttribute("allLikeCount", allLikeCount);
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth != null) {
			MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
			Map<String, String> map = new HashMap<String, String>();
			map.put("postsNum", postsNum);
			try {
				map.put("memberNum", memDto.getMemberNum());
				int i = likeMapper.likeCountSelectOne(map);
				model.addAttribute("like", i);
				model.addAttribute("memberNum", memDto.getMemberNum());
			}catch(Exception e) {
				model.addAttribute("like", 0);
				model.addAttribute("memberNum", "900");
			}
		}
	}
}
