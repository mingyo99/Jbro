package miniProject.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.mapper.GoodsMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("dto", dto);
		model.addAttribute("newLine", "\n");
	}
}