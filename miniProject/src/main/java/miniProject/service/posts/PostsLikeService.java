package miniProject.service.posts;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String execute(String postsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO dto = memberMapper.memberSelectOne(auth.getUserId());
		if(dto == null) {
			return "900";
		}else {
			likeMapper.likeAddDel(postsNum, dto.getMemberNum());
			Map<String, String> map = new HashMap<String, String>();
			map.put("postsNum", postsNum);
			map.put("memberNum", dto.getMemberNum());
			int likeCount = likeMapper.likeCountSelectOne(map);
			if(likeCount == 1) {
				return "1";
			}else {
				return "0";
			}
		}
	}
}
