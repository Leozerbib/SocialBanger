package A2.algo.socialBanger.Model.Service.ServiceIMPL;

import org.springframework.stereotype.Service;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("MonthlyWaterConsumptionService")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Override
	public Response<Boolean> addUtilisateur(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Boolean> deleteUtilisateur(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Boolean> updateUtilisateur(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Boolean> getUtilisateurById(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Boolean> getUtilisateurByName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<User> getUtilisateurByMail(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Response<Boolean> addUtilisateurByCountry(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
