package miniProject.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.PurchaseDTO;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PurchaseMapper;

@Service
public class OrderListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
		List<PurchaseDTO> dto = purchaseMapper.purchaseSelect(memDto.getMemberNum());
		model.addAttribute("dtos",dto);
	}
}
