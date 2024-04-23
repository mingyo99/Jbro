package miniProject.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.mapper.AutoMapper;

@Service
public class GoodsIpgoAutoNumservice {
	@Autowired
	AutoMapper autoMapper;
	public void execute(Model model) {
		String num = autoMapper.autoNumSelect("goodsipgo", "ipgo_num", "ip_");
		model.addAttribute("ipgoNum", num);
	}
}