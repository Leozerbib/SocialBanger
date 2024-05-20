package A2.algo.socialBanger.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    @Query("SELECT i FROM Interest i WHERE i.category = ?1")
    Interest findInterestByCategory(String category);

    List<Interest> findAll();
    // Exemple d'insertion : interestRepository.save(new Interest(...));
    // Exemple de mise à jour : interestRepository.save(existingInterest);
    // Exemple de suppression : interestRepository.deleteById(interestId);
}

