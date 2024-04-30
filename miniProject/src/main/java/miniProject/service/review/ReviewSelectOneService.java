package miniProject.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.ReviewDTO;
import miniProject.mapper.ReviewMapper;

@Service
public class ReviewSelectOneService {
	@Autowired
	ReviewMapper reviewMapper;
	public void execute(String goodsNum, String purchaseNum, Model model) {
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		String reviewContent = reviewMapper.reviewSelectOne(dto);
		model.addAttribute("reviewContent", reviewContent);
	}
}
