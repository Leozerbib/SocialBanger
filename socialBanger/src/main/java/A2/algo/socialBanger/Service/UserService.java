package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Abstract.UserAll;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import A2.algo.socialBanger.Model.Entity.Abstract.Userinfo;


public interface UserService {
	
	public Response<User> addUtilisateur(User user);
	public Response<Boolean> deleteUtilisateur(Long id);
	public Response<Boolean> updateUtilisateur(User user);
	
	public Response<List<User>> getAllUtilisateur();
	public Response<UserAll> getUtilisateurById(int id);
	public Response<User> getUtilisateurByName(User user);
	public Response<User> getUtilisateurByMail(String email);
	public Response<List<Userinfo>> getAllUtilisateurByCommunInterest(int id);
	public List<Userinfo> getByCommunLikedPost(int id);
	public List<Userinfo> getByCommunSub(int id);

	
	

}
