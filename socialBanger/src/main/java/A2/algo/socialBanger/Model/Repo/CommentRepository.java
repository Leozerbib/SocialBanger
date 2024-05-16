package A2.algo.socialBanger.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Comment;
import A2.algo.socialBanger.Model.Entity.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.post = ?1")
    List<Comment> findCommentsByPost(Post post);

    // Exemple d'insertion : commentRepository.save(new Comment(...));
    // Exemple de mise à jour : commentRepository.save(existingComment);
    // Exemple de suppression : commentRepository.deleteById(commentId);
}

