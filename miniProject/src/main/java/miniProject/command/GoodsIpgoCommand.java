package miniProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class GoodsIpgoCommand {
	String goodsIpgoNum;
	String goodsNum;
	Integer ipgoQty;
	Integer ipgoPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date ipgoDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date madeDate;
}