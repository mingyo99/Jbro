package miniProject.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value="miniProject.mapper.WishMapper")
public interface WishMapper {
	public void wishAddDelete(@Param("goodsNum") String goodsNum
							, @Param("memberNum") String memberNum);
	public int wishCountSelectOne(Map<String , String> map);
	
}