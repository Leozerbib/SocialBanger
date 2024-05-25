package A2.algo.socialBanger.Model.Entity;

import java.time.LocalDateTime;

import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subscriptions", schema = "public")
@NamedQuery(name = "Subscription.findSubscriber",query = "select s from Subscription s left join fetch s.user u where s.subscribedUser.id = ?1")
@NamedQuery(name = "Subscription.findSub",query = "select s from Subscription s left join fetch s.subscribedUser u where s.user.id = ?1")

public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserPlus user;

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id", referencedColumnName = "id")
    private UserPlus subscribedUser;

    @Column
    private LocalDateTime createdAt;
    
    
}
