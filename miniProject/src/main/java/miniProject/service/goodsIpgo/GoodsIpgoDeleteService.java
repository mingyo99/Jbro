package miniProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDeleteService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(String ipgoNumNgoodsNum []) {
		goodsIpgoMapper.ipgoGoodsNumDelete(ipgoNumNgoodsNum);
	}
}