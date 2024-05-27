package A2.algo.socialBanger.Model.Entity.Abstract;

import java.time.LocalDateTime;

import A2.algo.socialBanger.Model.Entity.Post;
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
public class LikePlus {
    @Id
    private Long id;

    @Column
    private int user_id;
    
    @Column
    private int post_id;
    
    @Column
    private LocalDateTime createdAt;

    
    
}
