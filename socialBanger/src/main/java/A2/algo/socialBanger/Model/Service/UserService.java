package A2.algo.socialBanger.Model.Service;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;

public interface UserService {
	
	public Response<Boolean> addUtilisateur(User user);
	public Response<Boolean> deleteUtilisateur(User user);
	public Response<Boolean> updateUtilisateur(User user);
	public Response<Boolean> getUtilisateurById(User user);
	public Response<Boolean> getUtilisateurByName(User user);
	public Response<User> getUtilisateurByMail(String email);
	public Response<Boolean> addUtilisateurByCountry(User user);

}
