package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Abstract.InterestPlus;

public interface InterestService {
	
	public Response<List<Interest>> getAll();
	
	public List<InterestPlus> getById(int id);
	
	public List<InterestPlus> getByCategory(String category);
	
	public List<InterestPlus> getBySubCategory(String subcategory);

}
