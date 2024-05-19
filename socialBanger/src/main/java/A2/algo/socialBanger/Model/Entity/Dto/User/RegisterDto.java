package A2.algo.socialBanger.Model.Entity.Dto.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import A2.algo.socialBanger.Config.PasswordUtils;
import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Enums.Gender;
import A2.algo.socialBanger.Model.Entity.Enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RegisterDto {
    
	

    private String firstName;

    private String lastName;
    
    private String Username;

    private String email;

    private String password;

    private Integer age;

    private String gender;

    private Set<Interest> interests = new HashSet<>();

    private Country country;

	public RegisterDto(String firstName, String lastName,String Username, String email, String password, Integer age, String gender,
			Set<Interest> interests, Country country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.Username = Username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.interests = interests;
		this.country = country;
	}

    
    
}
