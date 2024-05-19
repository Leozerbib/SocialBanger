package A2.algo.socialBanger.Model.Entity.Dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Entity.Interest;
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
public class UserDto {
    

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer age;

    private Gender gender;

    private Set<Interest> interests = new HashSet<>();

    private Country country;

	public UserDto(String firstName, String lastName, String email, String password, Integer age, Gender gender,
			Set<Interest> interests, Country country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.interests = interests;
		this.country = country;
	}

	public UserDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
    
    
}
