package A2.algo.socialBanger.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Abstract.InterestPlus;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    @Query("SELECT i FROM Interest i WHERE i.category = ?1")
    Interest findInterestByCategory(String category);

    List<Interest> findAll();
    
    List<InterestPlus> findById(int id);
    
    List<InterestPlus> findByCategory(String category);
    
    List<InterestPlus> findBySubcategory(String subcategory);
    // Exemple d'insertion : interestRepository.save(new Interest(...));
    // Exemple de mise à jour : interestRepository.save(existingInterest);
    // Exemple de suppression : interestRepository.deleteById(interestId);
}

