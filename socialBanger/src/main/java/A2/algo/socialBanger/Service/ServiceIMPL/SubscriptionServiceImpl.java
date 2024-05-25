package A2.algo.socialBanger.Service.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import A2.algo.socialBanger.Model.Entity.Subscription;
import A2.algo.socialBanger.Model.Repo.SubscriptionRepository;
import A2.algo.socialBanger.Service.SubscriptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("SubscriptionServiceImpl")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Override
	public List<Subscription> getSubscriber(int id) {
		return subscriptionRepository.findSubscriber(id);
	}

	@Override
	public List<Subscription> getSub(int id) {
		return subscriptionRepository.findSub(id);
	}
	

}
