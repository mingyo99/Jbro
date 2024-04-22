package miniProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import miniProject.command.LoginCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.mapper.LoginMapper;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(LoginCommand loginCommand, HttpSession session) {
		String userId = loginCommand.getUserId();
		String userPw = loginCommand.getUserPw();
		AuthInfoDTO auth = loginMapper.loginSelect(userId);
		if(auth != null) {
			if(passwordEncoder.matches(userPw, auth.getUserPw())) {
				session.setAttribute("auth", auth);
			}else {
				System.out.println("비밀번호 틀");
			}
		}else {
			System.out.println("아이디 틀");
		}
	}
}
