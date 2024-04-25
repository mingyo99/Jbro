package miniProject.service.wish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.WishDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.WishMapper;

@Service
public class WishInsertService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	WishMapper wishMapper;
	
	public void execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
		WishDTO dto = new WishDTO();
		
		dto.setMemberNum(memDto.getMemberNum());
		dto.setGoodsNum(goodsNum);
		wishMapper.wishInsert(dto);
	}
}
