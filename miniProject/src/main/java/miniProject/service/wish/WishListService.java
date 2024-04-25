package miniProject.service.wish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.WishDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.WishMapper;

@Service
public class WishListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	WishMapper wishMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(String goodsNum, Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("goodsCommand", dto);
		
		List<WishDTO> list = wishMapper.wishSelectList(dto.getGoodsNum(), memDto.getMemberNum());
		model.addAttribute("list", list);
	}
}
