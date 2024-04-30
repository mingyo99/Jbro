package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseList")
public class PurchaseListDTO {
	String purchaseNum;
	String goodsNum;
	Integer goodsPrice;
}
