package A2.algo.socialBanger.Service.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Abstract.InterestPlus;
import A2.algo.socialBanger.Model.Repo.InterestRepository;
import A2.algo.socialBanger.Service.InterestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("InterestServiceImpl")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InterestServiceImpl implements InterestService{

	@Autowired
	InterestRepository interestRepository;
	
	@Override
	public Response<List<Interest>> getAll() {
		log.info("Get all interests");
		List<Interest> interests = interestRepository.findAll();
		if (interests != null) {
			return Response.successfulResponse("Interests found", interests);
		}
		return Response.failedResponse("Interests not found");
	}

	@Override
	public List<InterestPlus> getById(int id) {
		return interestRepository.findById(id);
	}

	@Override
	public List<InterestPlus> getByCategory(String category) {
		return interestRepository.findByCategory(category);
	}

	@Override
	public List<InterestPlus> getBySubCategory(String subcategory) {
		return interestRepository.findBySubcategory(subcategory);
	}
	

}
