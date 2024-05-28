package A2.algo.socialBanger.Model.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;

import A2.algo.socialBanger.Model.Entity.Abstract.LikePlus;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts", schema = "public")
@NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
@NamedQuery(name = "Post.findByUserSub", query = ""
		+ "select p from Post p left join fetch p.user u left join fetch p.comments c left join fetch c.user left join fetch p.likes where u.id in (select s.subscribedUser.id from Subscription s where user.id = ?1) order by p.createdAt desc")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @BatchSize(size = 50)
    private UserPlus user;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private String location;
    
    @Column
    private String img_url;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "postinterest", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "interest_id"))
    @BatchSize(size = 50)
    private Set<Interest> interests = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @BatchSize(size = 50)
    private Set<Comment> comments = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @BatchSize(size = 50)
    private Set<LikePlus> likes = new HashSet<>();

	public Post(Long id, UserPlus user, String content, LocalDateTime createdAt, LocalDateTime updatedAt,
			String location, String img_url, Set<Comment> comments, Set<LikePlus> likes) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.location = location;
		this.img_url = img_url;
		this.comments = comments;
		this.likes = likes;
	}

	public Post(UserPlus user, String content, String img_url, Set<Interest> interests) {
		super();
		this.user = user;
		this.content = content;
		this.img_url = img_url;
		this.interests = interests;
	}
	
	
    
    
    
}
