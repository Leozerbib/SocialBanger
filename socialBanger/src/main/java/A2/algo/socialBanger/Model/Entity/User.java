package A2.algo.socialBanger.Model.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

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
@NamedQueries({ 
		@NamedQuery(
				name = "User.findByEmail", 
				query = "SELECT u FROM User u WHERE u.email = :email"),
		@NamedQuery(
				name = "User.findByEmailAndPassword", 
				query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
		@NamedQuery(
				name = "User.findAll", 
				query = "SELECT u FROM User u"),
		@NamedQuery(
				name = "User.findById", 
				query = "SELECT u FROM User u LEFT JOIN fetch u.country c Left JOIN fetch u.interests i WHERE u.id = :id"),
		@NamedQuery(
				name = "User.findByCountry", 
                query = "SELECT u FROM User u LEFT JOIN fetch u.country c Left JOIN fetch u.interests i WHERE u.country = :country"),
		@NamedQuery(
				name = "User.findByGender", 
                query = "SELECT u FROM User u LEFT JOIN fetch u.country c Left JOIN fetch u.interests i where u.gender = Male"),
})		
public class User {
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
    
    private int count_subscribers;
    
    private int count_subscriptions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
    
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private Set<Subscription> subscriptions = new HashSet<>();
    
    @OneToMany(mappedBy = "subscribedUser" ,fetch = FetchType.LAZY)
    private Set<Subscription> subscribers = new HashSet<>();
    
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<>();

	public User(Long id, String firstName, String lastName, String username, LocalDateTime createdAt, UserStatus userStatus, Integer age,
			Gender gender, Set<Interest> interests, Country country, Set<Subscription> subscriptions,
			Set<Subscription> subscribers, Set<Post> posts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.createdAt = createdAt;
		this.userStatus = userStatus;
		this.age = age;
		this.gender = gender;
		this.interests = interests;
		this.country = country;
		this.subscriptions = subscriptions;
		this.count_subscribers = subscribers.size();
		this.count_subscriptions = subscriptions.size();
		this.subscribers = subscribers;
		this.posts = posts;
	}

	public User(Long id, String firstName, String lastName, LocalDateTime createdAt, UserStatus userStatus, Integer age,
			Gender gender, Set<Interest> interests, Country country, Set<Subscription> subscriptions,
			Set<Subscription> subscribers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = createdAt;
		this.userStatus = userStatus;
		this.age = age;
		this.gender = gender;
		this.interests = interests;
		this.country = country;
		this.subscriptions = subscriptions;
		this.count_subscribers = subscribers.size();
		this.count_subscriptions = subscriptions.size();
		this.subscribers = subscribers;
	}

	public User(String firstName, String lastName, String username, String email, String password, LocalDateTime createdAt,
			LocalDateTime updatedAt, UserStatus userStatus, Integer age, Gender gender, Set<Interest> interests,
			Country country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userStatus = userStatus;
		this.age = age;
		this.gender = gender;
		this.interests = interests;
		this.country = country;
	}
    
    
    
}
