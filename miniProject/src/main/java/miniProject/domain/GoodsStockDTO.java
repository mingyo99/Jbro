package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsStock")
public class GoodsStockDTO {
	GoodsDTO goodsDTO;
	Integer stock;
}
