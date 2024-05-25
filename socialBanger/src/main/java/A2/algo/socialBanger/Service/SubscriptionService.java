package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Subscription;

public interface SubscriptionService {
	
	public List<Subscription> getSubscriber(int id);
	
	public List<Subscription> getSub(int id);

}
