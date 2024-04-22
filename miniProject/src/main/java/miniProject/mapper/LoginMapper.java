package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {
	public AuthInfoDTO loginSelect(String userId);
}
