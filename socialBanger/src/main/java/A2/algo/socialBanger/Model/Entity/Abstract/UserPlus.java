package A2.algo.socialBanger.Model.Entity.Abstract;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.persister.entity.EntityNameUse.UseKind;
import org.hibernate.type.SqlTypes;

import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class UserPlus { 
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Enumerated(EnumType.STRING)
    @Column
    private UserStatus userStatus;
    
	public UserPlus(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.userStatus = user.getUserStatus();
	}
	
	
	
    
    
}

