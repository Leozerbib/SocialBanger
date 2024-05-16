package A2.algo.socialBanger.Model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Like;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.User;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT l FROM Like l WHERE l.post = ?1 AND l.user = ?2")
    Like findLikeByPostAndUser(Post post, User user);

    // Exemple d'insertion : likeRepository.save(new Like(...));
    // Exemple de mise à jour : likeRepository.save(existingLike);
    // Exemple de suppression : likeRepository.deleteById(likeId);
}

