package A2.algo.socialBanger.Model.Entity.Abstract;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.persister.entity.EntityNameUse.UseKind;
import org.hibernate.type.SqlTypes;

import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@NamedQuery(name = "User.findByInterest", query = "select u2 from Userinfo u2 left join u2.interests i where i.subcategory in (select i2.subcategory from User u3 left join u3.interests i2 where u3.id=?1)")
public class Userinfo { 
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Enumerated(EnumType.STRING)
    @Column
    private UserStatus userStatus;
    
    @Formula("(select count(*) from subscriptions s where s.user_id = id)")
    private int count_subscribers;
    
    @Formula("(select count(*) from subscriptions s where s.subscribed_user_id = id)")
    private int count_subscriptions;
    
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests = new HashSet<>();
    
    
}

