package miniProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.command.GoodsIpgoCommand;
import miniProject.domain.GoodsIpgoDTO;
import miniProject.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoUpdateService { 
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand) {
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setIpgoNum(goodsIpgoCommand.getGoodsIpgoNum());
		dto.setIpgoPrice(goodsIpgoCommand.getIpgoPrice());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		dto.setMadeDate(goodsIpgoCommand.getMadeDate());
		goodsIpgoMapper.goodsIpgoUpdate(dto);
	}
}