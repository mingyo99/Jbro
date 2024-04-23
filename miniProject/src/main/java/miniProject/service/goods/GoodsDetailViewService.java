package miniProject.service.goods;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsStockDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.WishMapper;

@Service
public class GoodsDetailViewService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	WishMapper wishMapper;
	@Autowired
	MemberMapper memberMapper;
	public GoodsStockDTO execute(String goodsNum, Model model, HttpSession session) {
		goodsMapper.visitCount(goodsNum);
		GoodsStockDTO  dto = goodsMapper.goodsStockSelectOne(goodsNum);
		model.addAttribute("goodsStockCommand", dto);
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(auth != null) {
			MemberDTO memdto = memberMapper.memberSelectOne(auth.getUserId());
			Map<String, String> map = new HashMap<String, String>();
			map.put("goodsNum", goodsNum);
			try {
				map.put("memberNum", memdto.getMemberNum());
				int i = wishMapper.wishCountSelectOne(map);
				model.addAttribute("wish", i);
			}catch(Exception e) {
				model.addAttribute("wish", 0);
			}
		}
		return dto;
	}
}