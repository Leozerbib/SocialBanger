package A2.algo.socialBanger.Model.Entity.Abstract;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Like;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.Subscription;
import A2.algo.socialBanger.Model.Entity.Enums.Gender;
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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;



		
	


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public")
@NamedQuery(name = "User.findById", query = "SELECT u FROM UserAll u left join fetch u.interests left join fetch u.country left join fetch u.subscriptions left join fetch u.posts left join fetch u.likes WHERE u.id = :id")
public class UserAll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String username;
    
    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
    
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Enumerated(EnumType.STRING)
    @Column
    private UserStatus userStatus;

    @Column
    private Integer age;
    
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    @BatchSize(size = 100)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    private Set<Interest> interests = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @BatchSize(size = 50)
    private Country country;
    
    @Formula("(select count(*) from subscriptions s where s.user_id = id)")
    private int count_subscribers;
    
    @Formula("(select count(*) from subscriptions s where s.subscribed_user_id = id)")
    private int count_subscriptions;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @BatchSize(size = 100)
    private Set<SubscriptionPlus> subscriptions = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @BatchSize(size = 100)
    private Set<PostPlus> posts = new HashSet<>();
    
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @BatchSize(size = 100)
    private Set<LikePlus> likes = new HashSet<>();


    
    
    
}
