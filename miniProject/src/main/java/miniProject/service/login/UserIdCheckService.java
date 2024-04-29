package miniProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.mapper.LoginMapper;

@Service
public class UserIdCheckService {
	@Autowired
	LoginMapper loginMapper;
	public String execute(String userId) {
		return loginMapper.idCheckSelectOne(userId);
	}
}
