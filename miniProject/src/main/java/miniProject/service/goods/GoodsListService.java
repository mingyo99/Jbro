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
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	StartEndPageService startEndPageService;
	String searchWord;
	public void execute(String searchWord , Model model, int page) {
		int limit = 10;
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		List<GoodsDTO> list = goodsMapper.allSelect(sepDTO);
		int count = goodsMapper.goodsCount(searchWord);
		startEndPageService.execute(page, count,limit, model, searchWord);
		model.addAttribute("dtos", list);
	}
}