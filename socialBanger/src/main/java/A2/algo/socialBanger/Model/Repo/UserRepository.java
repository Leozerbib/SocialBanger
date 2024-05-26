package A2.algo.socialBanger.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import A2.algo.socialBanger.Model.Entity.Abstract.Userinfo;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findUserByEmail(String email) ;
    
    User existsByEmail(String email);
    
    User findByEmail(String email);
    
    User findByUsername(String username);
    
    List<User> findAll();
    
    User findById(long id);
    
    List<Userinfo> findByInterest(int id);
    
    
    
    
    

    
    
    
    // Exemple d'insertion : userRepository.save(new User(...));
    // Exemple de mise à jour : userRepository.save(existingUser);
    // Exemple de suppression : userRepository.deleteById(userId);
}

