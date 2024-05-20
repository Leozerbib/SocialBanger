package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Country;

public interface CountryService {

	public Response<List<Country>> getAll();
	
}
