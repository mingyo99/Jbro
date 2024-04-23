package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("goodsIpgo")
@AllArgsConstructor //생성자
@NoArgsConstructor // 디펄트 생성자
public class GoodsIpgoDTO { // 디비에 있는 table의 컬럼명과 같아야 한다.
	String ipgoNum;
	String goodsNum;
	Integer ipgoQty;
	Date ipgoDate;
	Date madeDate;
	Integer ipgoPrice;
	String empNum;
}