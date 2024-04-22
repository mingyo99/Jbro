package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AutoMapper {
	public String autoNumSelect(@Param("tableName") String tableName, @Param("columnName") String columnName, @Param("sep") String sep);
}
