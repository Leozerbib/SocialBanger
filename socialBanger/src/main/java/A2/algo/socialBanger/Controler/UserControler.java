package A2.algo.socialBanger.Controler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.PasswordUtils;
import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;
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
	
	@PostMapping("/register")
	public Response<Boolean> register(@RequestBody RegisterDto createUser) {
	    if (createUser == null) {
	        return Response.failedResponse("User null");
	    }
	    if (userServiceImpl.getUtilisateurByMail(createUser.getEmail()).getData()!=null ) {
			return Response.failedResponse("mail already exist");
	    }
	    
	    User user = new User(createUser.getFirstName(), createUser.getLastName(),createUser.getUsername(), createUser.getEmail(), passwordUtils.encryptPassword(createUser.getPassword()), LocalDateTime.now(), LocalDateTime.now(), UserStatus.Connected, createUser.getAge(), Gender.StringToGender(createUser.getGender()), createUser.getInterests(), createUser.getCountry());
	    System.out.println("User created : " + user.toString());
	    return userServiceImpl.addUtilisateur(user);
	}

	
	@PostMapping("/Login")
	public Response<User> login(@RequestBody LoginDto loginUser) {
		User user = userServiceImpl.getUtilisateurByMail(loginUser.getEmail()).getData();
		if (user != null) {
			log.info("User trying to login : " + user.toString());
			if (passwordUtils.matchPassword(loginUser.getPassword(), user.getPassword())) {
				user.setUserStatus(UserStatus.Connected);
				userServiceImpl.updateUtilisateur(user);
				return Response.successfulResponse("Login successful",user);
			}
			return Response.failedResponse("Login failed : wrong password");
		}
		return Response.failedResponse("Login failed : wrong email");
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
	public Response<User> getById(@RequestBody int id) {
		User user = userServiceImpl.getUtilisateurById(id).getData();
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

            
	
}
