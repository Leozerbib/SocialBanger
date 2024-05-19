package A2.algo.socialBanger.Model.Entity.Dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginDto {

	private String email;
	private String password;
	
	public LoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	

}
