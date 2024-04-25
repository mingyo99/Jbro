package miniProject.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsCartDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.CartMapper;
import miniProject.mapper.MemberMapper;

@Service
public class CartListService {
		@Autowired
		CartMapper cartMapper;
		@Autowired
		MemberMapper memberMapper;
		public void execute(String goodsNum,Model model, HttpSession session) {
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			MemberDTO memDTO = memberMapper.memberSelectOne(auth.getUserId());
			
			List<GoodsCartDTO> list = cartMapper.cartSelectList(memDTO.getMemberNum());
			Integer totPri = 0;
			Integer totQty = 0;
			for(GoodsCartDTO dto : list) {
				totPri += dto.getTotalPrice();
				totQty += dto.getCartDTO().getCartQty();
			}
			model.addAttribute("list", list);
			model.addAttribute("totPri", totPri);
			model.addAttribute("totQty", totQty);
		}
	}
