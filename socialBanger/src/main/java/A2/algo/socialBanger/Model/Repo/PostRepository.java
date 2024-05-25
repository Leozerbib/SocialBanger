package A2.algo.socialBanger.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.user = ?1")
    List<Post> findPostsByUser(User user);
    
    List<Post> findByUserSub(int id);

    // Exemple d'insertion : postRepository.save(new Post(...));
    // Exemple de mise à jour : postRepository.save(existingPost);
    // Exemple de suppression : postRepository.deleteById(postId);
}

