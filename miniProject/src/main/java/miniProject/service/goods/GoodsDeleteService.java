package miniProject.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.domain.GoodsDTO;
import miniProject.mapper.GoodsMapper;

@Service
public class GoodsDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum) {
		//파일 삭제코드를 추가합니다. // 일단 bin에만 파일을 놓겠습니다.
		GoodsDTO dto = goodsMapper.selectOne(goodsNum); // 먼저 삭제할 파일의 정보를 자져옵니다.
		goodsMapper.goodsDelete(goodsNum);
	}
}