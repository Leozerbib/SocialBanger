package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;


public interface UserService {
	
	public Response<User> addUtilisateur(User user);
	public Response<Boolean> deleteUtilisateur(Long id);
	public Response<Boolean> updateUtilisateur(User user);
	
	public Response<List<User>> getAllUtilisateur();
	public Response<User> getUtilisateurById(int id);
	public Response<User> getUtilisateurByName(User user);
	public Response<User> getUtilisateurByMail(String email);

	
	

}
