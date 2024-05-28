package A2.algo.socialBanger.Controler;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.PasswordUtils;
import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Abstract.UserAll;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import A2.algo.socialBanger.Model.Entity.Abstract.Userinfo;
import A2.algo.socialBanger.Model.Entity.Dto.User.LoginDto;
import A2.algo.socialBanger.Model.Entity.Dto.User.RegisterDto;
import A2.algo.socialBanger.Model.Entity.Enums.Gender;
import A2.algo.socialBanger.Model.Entity.Enums.UserStatus;
import A2.algo.socialBanger.Service.UserService;
import A2.algo.socialBanger.Service.ServiceIMPL.UserServiceImpl;
import jakarta.persistence.EnumType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserControler {
	
	@Autowired
	PasswordUtils passwordUtils = new PasswordUtils();
	
	Response response = new Response();
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
	
    @ResponseBody
    @RequestMapping(path = "/hello")
    public String sayHello() {
        log.info("GET called on /hello resource");
        return HELLO_TEXT;
    }
	
	@PostMapping("/Register")
	public Response<UserAll> register(@RequestBody RegisterDto createUser) {
	    if (createUser == null) {
	    	System.out.println("User null");
	        return Response.failedResponse("User null");
	    }
	    if (userServiceImpl.getUtilisateurByMail(createUser.getEmail()).getData()!=null ) {
			System.out.println("mail already exist");
	    	return Response.failedResponse("mail already exist");
	    }
	    Set<Interest> interests = new HashSet<Interest>(createUser.getInterests());
	    User user = new User(createUser.getFirstName(), createUser.getLastName(),createUser.getUsername(), createUser.getEmail(), passwordUtils.encryptPassword(createUser.getPassword()), LocalDateTime.now(), LocalDateTime.now(), UserStatus.Connected, createUser.getAge(), Gender.StringToGender(createUser.getGender()), interests , createUser.getCountry());
	    System.out.println("User created : " + user.toString());
	    userServiceImpl.addUtilisateur(user);
	    UserAll userAll = userServiceImpl.getUtilisateurById(userServiceImpl.getUtilisateurByMail(user.getEmail()).getData().getId().intValue()).getData();
	    return Response.successfulResponse("User created", userAll);
	}

	
	@PostMapping("/Login")
	public Response<UserAll> login(@RequestBody LoginDto loginUser) {
		User user = userServiceImpl.getUtilisateurByMail(loginUser.getEmail()).getData();
		if (user != null) {
			log.info("User trying to login : " + user.toString());
			System.out.println("User trying to login : " + user.toString());
			if (passwordUtils.matchPassword(loginUser.getPassword(), user.getPassword())) {
				user.setUserStatus(UserStatus.Connected);
				userServiceImpl.updateUtilisateur(user);
			    UserAll userAll = userServiceImpl.getUtilisateurById(user.getId().intValue()).getData();
				return Response.successfulResponse("Login successful",userAll);
			}
			return Response.failedResponse("Login failed : wrong password");
		}
		System.out.println("Login failed : wrong email");
		
		return Response.failedResponse("Login failed : wrong email");
	}
	
	@GetMapping("/Interest/Commun")
	public Response<List<Userinfo>> CommunInterest(@RequestParam int id){
		List<Userinfo> userPlus = userServiceImpl.getAllUtilisateurByCommunInterest(id).getData();
		if (userPlus.isEmpty()) {
			return Response.failedResponse("No User Found");
		} 
		return Response.successfulResponse("Succes", userPlus);
	}
	
	
	@PostMapping("/update")
	public Response<Boolean> update(@RequestBody RegisterDto updateUser) {
		return response;
		
	}
	
	@PostMapping("/delete")
	public Response<Boolean> delete(@RequestBody Long id) {
		if (id == null) {
			return Response.failedResponse("User not found");
		}
		if (userServiceImpl.deleteUtilisateur(id).isSuccess() == false) {
			return Response.failedResponse("User not found");
		}
		return Response.successfulResponse("User deleted");
	}
	
	
	

	@GetMapping("/getById")
	public Response<UserAll> getById(@RequestParam int id) {
		UserAll user = userServiceImpl.getUtilisateurById(id).getData();
		log.info("User found : " + user.toString());
		if (user == null) {
			return Response.failedResponse("User not found");
		}
		return Response.successfulResponse("User found", user);
		
	}
	
	
	
	
	@PostMapping("/getByName")
	public Response<User> getByName(@RequestBody RegisterDto getUser) {
		return response;
	}
	
	@RequestMapping("/getAll")
	public Response<List<User>> getAll() {
		List<User> users = userServiceImpl.getAllUtilisateur().getData();
		if (users == null) {
			return Response.failedResponse("Users not found");
		}
		return Response.successfulResponse("Users found", users);
	}
	
	@GetMapping("/CommunLikedPost")
	public Response<List<Userinfo>> CommunLikedPost(@RequestParam int id) {
		return Response.successfulResponse("All User Found",userServiceImpl.getByCommunLikedPost(id));
	}
	
	@GetMapping("/CommunSub")
	public Response<List<Userinfo>> CommunSub(@RequestParam int id) {
		return Response.successfulResponse("All User Found", userServiceImpl.getByCommunSub(id));
	}

            
	
}
