package A2.algo.socialBanger.Service.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Repo.CountryRepository;
import A2.algo.socialBanger.Service.CountryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("CountryServiceImpl")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Response<List<Country>> getAll() {
		log.info("Get all countries");
		List<Country> countries = countryRepository.findAll();
		if (countries != null) {
			return Response.successfulResponse("Countries found", countries);
		}
		return Response.failedResponse("Countries not found");
	}

}
