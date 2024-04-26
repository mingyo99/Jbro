package miniProject.service.wish;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.WishMapper;

@Service
public class GoodsWishService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	WishMapper wishMapper;
	public String execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO dto = memberMapper.memberSelectOne(auth.getUserId());
		if(dto == null) {
			return "900";
		}else {
			wishMapper.wishAddDelete(goodsNum, dto.getMemberNum());
			Map<String , String> map = new HashMap<String , String>();
			map.put("goodsNum", goodsNum);
			map.put("memberNum", dto.getMemberNum());
			int wishCount = wishMapper.wishCountSelectOne(map);
			if(wishCount == 1) {
				return "1";
			}else {
				return "0"; 
			}
		}
		
	}
}