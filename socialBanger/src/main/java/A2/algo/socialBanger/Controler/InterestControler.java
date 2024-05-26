package A2.algo.socialBanger.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Abstract.InterestPlus;
import A2.algo.socialBanger.Service.ServiceIMPL.InterestServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/interest")
@RequiredArgsConstructor
@Slf4j
public class InterestControler {

	@Autowired
	InterestServiceImpl interestServiceImpl;
	
	@RequestMapping("/getAll")
	public Response<List<Interest>> getAll() {
		return interestServiceImpl.getAll();
	}
	
	@RequestMapping("/getById")
	public Response<List<InterestPlus>> getById(@RequestParam int id) {
		List<InterestPlus> interestPlus = interestServiceImpl.getById(id);
		if (interestPlus != null) {
			return Response.successfulResponse("Interest found", interestPlus);
		}
		return Response.failedResponse("Interest not found");
	}
	
	@RequestMapping("/getByCategory")
	public Response<List<InterestPlus>> getByCategory(@RequestParam String category) {
		List<InterestPlus> interestPlus = interestServiceImpl.getByCategory(category);
		if (interestPlus != null) {
			return Response.successfulResponse("Interest found", interestPlus);
		}
		return Response.failedResponse("Interest not found");
	}
	
	@RequestMapping("/getBySubCategory")
	public Response<List<InterestPlus>> getBySubCategory(@RequestParam String subcategory) {
		List<InterestPlus> interestPlus = interestServiceImpl.getBySubCategory(subcategory);
		if (interestPlus != null) {
			return Response.successfulResponse("Interest found", interestPlus);
		}
		return Response.failedResponse("Interest not found");
	}
	
	
	
}
