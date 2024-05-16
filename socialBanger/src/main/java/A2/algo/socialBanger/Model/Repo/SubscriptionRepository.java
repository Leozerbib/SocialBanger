package A2.algo.socialBanger.Model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Subscription;
import A2.algo.socialBanger.Model.Entity.User;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query("SELECT s FROM Subscription s WHERE s.user = ?1 AND s.subscribedUser = ?2")
    Subscription findSubscriptionByUserAndSubscribedUser(User user, User subscribedUser);

    // Exemple d'insertion : subscriptionRepository.save(new Subscription(...));
    // Exemple de mise à jour : subscriptionRepository.save(existingSubscription);
    // Exemple de suppression : subscriptionRepository.deleteById(subscriptionId);
}

