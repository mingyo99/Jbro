package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import miniProject.domain.GoodsDTO;
import miniProject.domain.PurchaseDTO;

@Mapper
public interface PurchaseMapper {
	public List<GoodsDTO> purchaseSelectOne(String goodsNum);
	public List<PurchaseDTO> purchaseSelect(String memberNum);
	public void purchaseInsert(PurchaseDTO dto);
	public void purchaseStatusUpdate(@Param("purchaseNum") String purchaseNum, @Param("status") String status);
}
