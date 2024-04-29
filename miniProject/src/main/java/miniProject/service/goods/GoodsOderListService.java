package miniProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import miniProject.domain.PurchaseDTO;
import miniProject.mapper.PurchaseMapper;

@Service
public class GoodsOderListService {
	@Autowired
	PurchaseMapper purchaseMapper;
	public void execute(Model model) {
		List<PurchaseDTO> list = purchaseMapper.purchaseSelect(null);
		model.addAttribute("dtos", list);
	}
}
