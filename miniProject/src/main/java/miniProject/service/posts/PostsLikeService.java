package miniProject.service.posts;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.LikeMapper;
import miniProject.mapper.MemberMapper;

@Service
public class PostsLikeService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	LikeMapper likeMapper;
	public Map<String, String> execute(String postsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO dto = memberMapper.memberSelectOne(auth.getUserId());
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		if(dto == null) {
			map.put("likeCount", "900");
		}else {
			likeMapper.likeAddDel(postsNum, dto.getMemberNum());
			
			map.put("postsNum", postsNum);
			map.put("memberNum", dto.getMemberNum());
			
			int likeCount = likeMapper.likeCountSelectOne(map);
			if(likeCount == 1) {
				map.put("likeCount", "1");
			}else {
				map.put("likeCount", "0");
			}
		}
		String allLikeCount = likeMapper.likeCountSelectAll(postsNum).toString();
		map.put("allLikeCount", allLikeCount);
		return map;
	}
}
