package A2.algo.socialBanger.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Country;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Service.ServiceIMPL.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/country")
@RequiredArgsConstructor
@Slf4j
public class CountryControler {

	@Autowired
	CountryServiceImpl countryServiceImpl;
	
	@RequestMapping("/getAll")
	public Response<List<Country>> getAll() {
		return countryServiceImpl.getAll();
	}
	
}
