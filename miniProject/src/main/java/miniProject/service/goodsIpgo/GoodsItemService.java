package miniProject.service.goodsIpgo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.domain.GoodsDTO;
import miniProject.domain.StartEndPageDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.service.StartEndPageService;

@Service
public class GoodsItemService { 
	//상품 정보를 가지고 오는 것이므로 GoodsMapper를 이용합니다.
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public Map<String, Object> execute(String searchWord, int page){
		int limit = 10;
		Map<String, Object> map = new HashMap<String, Object>();
		// allSelect를 사용하려면 StartEndPageDTO가 있어야 하며
		// StartEndPageDTO를 가지고 오기 위해서는 StartEndPageService가 필요합니다.
		// execute를 사용하기 위해서는 page와 searchWord가 필요합니다.
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		List<GoodsDTO> list = goodsMapper.allSelect(sepDTO);
		// 페이징 코드를 추가한다. model을 이용하는 것이 아니므로 StartEndPageService에 있는 메서드를 사용못한다. 
		int count = goodsMapper.goodsCount(searchWord);
		int limitPage = 10;
		int startPage = (int)((double)page / limitPage + 0.95 -1) * limitPage + 1 ;
		int endPage = startPage + limitPage -1 ;
		int maxPage = (int)((double)count / limit + 0.95);
		if(maxPage < endPage) endPage = maxPage;
		// model 대신 map에 저장한다.
		map.put("dtos", list);
		map.put("searchWord", searchWord);
		map.put("page", page);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("count", count);
		map.put("maxPage", maxPage);
		return map;
	}
}