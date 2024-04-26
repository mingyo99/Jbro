package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("wish")
public class WishDTO {
	Date wishDate;
	String memberNum;
	String goodsNum;
}
