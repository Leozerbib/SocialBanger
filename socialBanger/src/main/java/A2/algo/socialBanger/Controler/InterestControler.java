package A2.algo.socialBanger.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Interest;
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
	
}
