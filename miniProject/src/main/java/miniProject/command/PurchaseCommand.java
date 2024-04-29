package miniProject.command;

import java.util.Date;

import lombok.Data;

@Data
public class PurchaseCommand {
	String purchaseNum;
	Date purchaseDate;
	Integer purchasePrice;
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPost;
	String deliveryPhone;
	String message;
	String purchaseStatus;
	String memberNum;
	String deliveryName;
	String purchaseName;
}
