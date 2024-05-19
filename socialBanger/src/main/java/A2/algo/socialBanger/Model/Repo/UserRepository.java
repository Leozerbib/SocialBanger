package A2.algo.socialBanger.Model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findUserByEmail(String email);

    
    
    
    // Exemple d'insertion : userRepository.save(new User(...));
    // Exemple de mise à jour : userRepository.save(existingUser);
    // Exemple de suppression : userRepository.deleteById(userId);
}

