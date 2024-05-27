package A2.algo.socialBanger.Model.Entity;

import java.time.LocalDateTime;

import A2.algo.socialBanger.Model.Entity.Abstract.PostPlus;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "likes", schema = "public")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserPlus user;
   

    @Column
    private LocalDateTime createdAt;

	public Like(Long id) {
		super();
		this.id = id;
	}
    
    
}
