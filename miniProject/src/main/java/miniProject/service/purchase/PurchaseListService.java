package miniProject.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PurchaseMapper;

@Service
public class PurchaseListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(String goodsNum, Model model) {

		List<GoodsDTO> dto = purchaseMapper.purchaseSelectOne(goodsNum);
		model.addAttribute("dtos", dto);
	}
}
