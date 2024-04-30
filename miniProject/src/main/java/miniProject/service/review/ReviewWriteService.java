package miniProject.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.ReviewDTO;
import miniProject.mapper.ReviewMapper;

@Service
public class ReviewWriteService {
	@Autowired
	ReviewMapper reviewMapper;
	public void execute(String goodsNum, String purchaseNum, String reviewContent, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberId(auth.getUserId());
		dto.setPurchaseNum(purchaseNum);
		dto.setReviewContent(reviewContent);
		reviewMapper.reviewInsertUpdate(dto);
		
	}
}
