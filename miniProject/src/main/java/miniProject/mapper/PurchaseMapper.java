package miniProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.GoodsDTO;

@Mapper
public interface PurchaseMapper {
	public List<GoodsDTO> purchaseSelectOne(String goodsNum);
	
}
