package A2.algo.socialBanger.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Subscription;
import A2.algo.socialBanger.Service.ServiceIMPL.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class SubscriptionControleur {
	
	@Autowired
	SubscriptionServiceImpl subscriptionServiceImpl;
	
	@GetMapping("/Subscriber")
	public Response<List<Subscription>> getSubscriber(@RequestParam int id){
		List<Subscription> subscriptions = subscriptionServiceImpl.getSubscriber(id);
		if (subscriptions.isEmpty() || subscriptions == null) {
			return Response.failedResponse("No sub...");
		}
		return Response.successfulResponse("Wow", subscriptions);
	}
	
	@GetMapping("/Sub")
	public Response<List<Subscription>> getSub(@RequestParam int id){
		List<Subscription> subscriptions = subscriptionServiceImpl.getSub(id);
		if (subscriptions.isEmpty() || subscriptions == null) {
			return Response.failedResponse("No sub...");
		}
		return Response.successfulResponse("Wow", subscriptions);
	}
	
}
