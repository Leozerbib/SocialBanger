package A2.algo.socialBanger.Model.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postinterest", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class postInterest {

    @Id
	private Long post_id;
	
    @Id
	private Long interest_id;
}
