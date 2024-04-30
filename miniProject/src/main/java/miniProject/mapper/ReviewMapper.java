package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.ReviewDTO;

@Mapper
public interface ReviewMapper {
	public void reviewInsertUpdate(ReviewDTO dto);
	public String reviewSelectOne(ReviewDTO dto);
	public List<ReviewDTO> goodsReviewList(String goodsNum);
}
