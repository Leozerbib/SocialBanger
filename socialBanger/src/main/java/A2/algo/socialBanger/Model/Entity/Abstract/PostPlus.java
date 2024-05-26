package A2.algo.socialBanger.Model.Entity.Abstract;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import A2.algo.socialBanger.Model.Entity.Comment;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Like;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "posts", schema = "public")
public class PostPlus {
	
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
    
    @Formula("(select count(*) from likes s where s.post_id = id)")
    private int likesCount;
    
    @Formula("(select count(*) from comments s where s.post_id = id)")
    private int commentsCount;
    
    public PostPlus() {
    	
    }

	public PostPlus(Long id, UserPlus user, String content, LocalDateTime createdAt, LocalDateTime updatedAt,
			String location, String img_url, int likesCount, int commentsCount) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.location = location;
		this.img_url = img_url;
		this.likesCount = likesCount;
		this.commentsCount = commentsCount;
	}
    
    

}
