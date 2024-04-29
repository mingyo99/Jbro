package miniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("category")
public class CategoryDTO {
	String gender;
	String weight;
	String height;
	String style;
	String orderBy;
}
