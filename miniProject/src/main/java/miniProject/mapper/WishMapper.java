package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import miniProject.domain.WishDTO;

@Mapper
@Repository(value="miniProject.mapper.WishMapper")
public interface WishMapper {
	public void wishInsert(WishDTO dto);
	public WishDTO wishSelectOne(String goodsNum);
	public List<WishDTO> wishSelectList(String goodsNum, String memberNum);
}