package A2.algo.socialBanger.Service.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Repo.UserRepository;
import A2.algo.socialBanger.Service.UserService;
import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("UserServiceImpl")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public Response<Boolean> addUtilisateur(User user) {
		System.out.println("User created : " + user.toString());
		System.out.println(userRepository.save(user));
		
		return null;
	}

	@Override
	public Response<Boolean> deleteUtilisateur(Long id) {
		log.info("User deleted : " + id);
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return Response.successfulResponse("User deleted");
		}
		return Response.failedResponse("User not found");
	}

	@Override
	public Response<Boolean> updateUtilisateur(User user) {
		log.info("User updated : " + user.toString());
		userRepository.save(user);
		return null;
	}

	@Override
	public Response<User> getUtilisateurById(int id) {
		User user = userRepository.findById(id);
		if (user != null) {
			return Response.successfulResponse("User found", user);
		}
		return Response.failedResponse("User not found");
	}

	@Override
	public Response<User> getUtilisateurByName(User user) {
		
		return null;
	}

	@Override
	public Response<User> getUtilisateurByMail(String string) {
		User user = userRepository.findUserByEmail(string);
		if (user != null) {
			return Response.successfulResponse("User found", user);
		}
		return Response.failedResponse("User not found");
	}
	

	@Override
	public Response<List<User>> getAllUtilisateur() {
		List<User> users = userRepository.findAll();
		if (users != null) {
			return Response.successfulResponse("Users found", users);
		}
		return Response.failedResponse("Users not found");
	}

}
