package miniProject.service.wish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.WishMapper;

@Service
public class WishListService {
	@Autowired
	WishMapper wishMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
		
		
		List<GoodsDTO> list = wishMapper.wishSelectList(memDto.getMemberNum());
		model.addAttribute("list", list);
	}
}
