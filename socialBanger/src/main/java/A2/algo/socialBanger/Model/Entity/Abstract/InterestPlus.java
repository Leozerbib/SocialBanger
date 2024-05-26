package A2.algo.socialBanger.Model.Entity.Abstract;

import java.util.HashSet;
import java.util.Set;

import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interests", schema = "public")
@NamedQuery(name = "Interest.findById", query = "SELECT i FROM InterestPlus i left join fetch i.users u left join fetch i.posts WHERE i.id = :id")
@NamedQuery(name = "Interest.findByCategory", query = "SELECT i FROM InterestPlus i left join fetch i.users u join fetch i.posts WHERE i.category = :category")
@NamedQuery(name = "Interest.findBySubcategory", query = "SELECT i FROM InterestPlus i left join fetch i.users u join fetch i.posts WHERE i.subcategory = :subcategory")
public class InterestPlus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(name = "postinterest",
            joinColumns = @jakarta.persistence.JoinColumn(name = "interest_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "post_id"))
    private Set<PostPlus> posts = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "user_interests",
            joinColumns = @jakarta.persistence.JoinColumn(name = "interest_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "user_id"))
    private Set<UserPlus> users = new HashSet<>();
    
    @Column()
    private String category;
    
    @Column(unique = true)
    private String subcategory;
}
