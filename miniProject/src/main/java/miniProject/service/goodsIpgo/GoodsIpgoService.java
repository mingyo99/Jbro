package miniProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.command.GoodsIpgoCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsIpgoDTO;
import miniProject.mapper.EmployeeMapper;
import miniProject.mapper.GoodsIpgoMapper;
@Service
public class GoodsIpgoService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand, HttpSession session) {
		//입고한 직원이 누구인지 알기 위해 직원 로그인 정보를 가지고 온다.
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		//아이디가 아닌 직원번호가 필요하므로 아이디를 이용해서 직원정보를 가지고 온다.
		String empNum = employeeMapper.getEmpNum(auth.getUserId());
		// 입고 DTO를 만들어준다.
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		dto.setEmpNum(empNum);
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setIpgoNum(goodsIpgoCommand.getGoodsIpgoNum());
		dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		dto.setMadeDate(goodsIpgoCommand.getMadeDate());
		goodsIpgoMapper.goodsIpgoInsert(dto);
	}
}