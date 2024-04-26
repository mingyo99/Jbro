package miniProject.service.goods;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.WishMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	WishMapper wishMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(String goodsNum, Model model, HttpSession session) {
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("dto", dto);
		model.addAttribute("goodsNum", goodsNum);
		model.addAttribute("newLine", "\n");
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth != null) {
			MemberDTO mDto = memberMapper.memberSelectOne(auth.getUserId());
			Map<String , String> map = new HashMap<String , String>();
			map.put("goodsNum", goodsNum);
			map.put("memberNum", mDto.getMemberNum());
			int wishCount = wishMapper.wishCountSelectOne(map);
			model.addAttribute("wish", wishCount);
		}
	}
}