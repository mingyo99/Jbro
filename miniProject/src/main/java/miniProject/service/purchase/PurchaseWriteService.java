package miniProject.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.command.PurchaseCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.MemberDTO;
import miniProject.domain.PurchaseDTO;
import miniProject.mapper.AutoMapper;
import miniProject.mapper.MemberMapper;
import miniProject.mapper.PurchaseMapper;

@Service
public class PurchaseWriteService {
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	AutoMapper autoMapper;
	public void execute(PurchaseCommand command, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDto = memberMapper.memberSelectOne(auth.getUserId());
		
		String purchaseNum = autoMapper.autoNumSelect("PURCHASE", "PURCHASE_NUM", "PUR");
		PurchaseDTO dto = new PurchaseDTO();
		
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseName(command.getPurchaseName());
		System.out.println(command.getPurchaseName());
		dto.setDeliveryAddr(command.getDeliveryAddr());
		dto.setDeliveryAddrDetail(command.getDeliveryAddrDetail());
		dto.setDeliveryPost(command.getDeliveryPost());
		dto.setDeliveryPhone(command.getDeliveryPhone());
		dto.setMessage(command.getMessage());
		dto.setDeliveryName(command.getDeliveryName());
		dto.setMemberNum(memDto.getMemberNum());
		
		purchaseMapper.purchaseInsert(dto);
	}
}
