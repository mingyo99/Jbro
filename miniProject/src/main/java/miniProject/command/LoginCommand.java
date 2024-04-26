package miniProject.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginCommand {
	@NotBlank(message = "")
	String userId;
	@NotBlank(message = "")
	String userPw;
}
