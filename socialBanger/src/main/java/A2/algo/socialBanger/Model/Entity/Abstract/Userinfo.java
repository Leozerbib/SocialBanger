package A2.algo.socialBanger.Model.Entity.Abstract;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
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
@NamedQuery(name = "User.findByCommunSub", query = ""
		+ "select distinct u "
		+ "from Userinfo u "
		+ "left join fetch u.country "
		+ "left join fetch u.interests "
		+ "where u.id in ( "
		+ "   select distinct s3.subscribedUser.id "
		+ "   from Subscription s3 "
		+ "   where s3.subscribedUser.id not in ( "
		+ "      select s2.subscribedUser.id "
		+ "      from User u2 "
		+ "      left join u2.subscriptions s2 "
		+ "      where u2.id = :id "
		+ "   )"
		+ ")"
		+ "")
@NamedQuery(name = "User.findByCommunLikedPost", query = ""
		+ "select distinct u "
		+ "from Userinfo u "
		+ "left join fetch u.country "
		+ "left join fetch u.interests "
		+ "left join LikePlus l on u.id = l.user_id "
		+ "where l.post_id in ( "
		+ "   select l1.post_id "
		+ "   from User u1 "
		+ "   left join LikePlus l1 on u1.id = l1.user_id "
		+ "   where u1.id = :id "
		+ ")"
		+ "")
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
    @BatchSize(size = 100)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    private Country country;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    @BatchSize(size = 100)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    private Set<Interest> interests = new HashSet<>();
    
    
}

