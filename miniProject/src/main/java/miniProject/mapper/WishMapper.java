package miniProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.GoodsDTO;
import miniProject.domain.WishDTO;

@Mapper
public interface WishMapper {
	public void wishInsert(WishDTO dto);
	public List<GoodsDTO> wishSelectList(String memberNum);
	public void wishAddDelete(@Param("goodsNum") String goodsNum
			, @Param("memberNum") String memberNum);
	public int wishCountSelectOne(Map<String, String> map);
}