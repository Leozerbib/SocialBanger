package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Interest;

public interface InterestService {
	
	public Response<List<Interest>> getAll();

}
