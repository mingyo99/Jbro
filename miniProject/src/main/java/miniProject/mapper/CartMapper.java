package miniProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import miniProject.domain.GoodsCartDTO;

@Repository(value="miniProject.mapper.CartMapper")
public interface CartMapper {
	public void cartInsert(Map<String, Object> map);
	public List<GoodsCartDTO> cartSelectList(String memberNum);
	public int cartQtyDown(@Param("goodsNum") String goodsNum
			              ,@Param("memberNum") String memberNum);
	public int goodsNumsDelete(Map<String, Object> condition);
}