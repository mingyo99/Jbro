package miniProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.GoodsDTO;
import miniProject.domain.StartEndPageDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.service.StartEndPageService;

@Service
public class MainGoodsListService {
	@Autowired
	StartEndPageService startEndPageService;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Integer page,  Model model) {
		int limit = 6;
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, null);
		List<GoodsDTO> list = goodsMapper.allSelect(sepDTO);
		int count = goodsMapper.goodsCount(null);
		startEndPageService.execute(page, count, limit, model, null);
		model.addAttribute("list",list);
		
	}
}
