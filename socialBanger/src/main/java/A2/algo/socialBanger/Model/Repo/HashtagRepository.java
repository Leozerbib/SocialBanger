package A2.algo.socialBanger.Model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    @Query("SELECT h FROM Hashtag h WHERE h.name = ?1")
    Hashtag findHashtagByName(String name);

    // Exemple d'insertion : hashtagRepository.save(new Hashtag(...));
    // Exemple de mise à jour : hashtagRepository.save(existingHashtag);
    // Exemple de suppression : hashtagRepository.deleteById(hashtagId);
}

