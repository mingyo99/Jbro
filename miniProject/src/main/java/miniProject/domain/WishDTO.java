package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("wish")
public class WishDTO {
	Integer wishNum;
	String memberNum;
	String goodsNum;
}
