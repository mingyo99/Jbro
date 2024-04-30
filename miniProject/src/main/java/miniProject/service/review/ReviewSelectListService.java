package miniProject.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.ReviewDTO;
import miniProject.mapper.ReviewMapper;

@Service
public class ReviewSelectListService {
	@Autowired
	ReviewMapper reviewMapper;
	public void execute(String goodsNum, Model model) {
		List<ReviewDTO> list = reviewMapper.goodsReviewList(goodsNum);
		System.out.println(goodsNum + list);
		model.addAttribute("list", list);
		model.addAttribute("newLineChar", "\n");
	}
}
