package Controler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.PasswordUtils;
import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.User;
import A2.algo.socialBanger.Model.Entity.Dto.UserDto;
import A2.algo.socialBanger.Model.Entity.Enums.Gender;
import A2.algo.socialBanger.Model.Entity.Enums.UserStatus;
import A2.algo.socialBanger.Model.Service.UserService;
import A2.algo.socialBanger.Model.Service.ServiceIMPL.UserServiceImpl;
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
	
	
	@PostMapping("/register")
	public Response<Boolean> register(@RequestBody UserDto createUser) {
	    if (createUser == null) {
	        return Response.failedResponse("User null");
	    }
	    if (userServiceImpl.getUtilisateurByMail(createUser.getEmail()).getData()!=null ) {
			return Response.failedResponse("mail already exist");
	    }
	    
	    User user = new User(null, createUser.getFirstName(), createUser.getLastName(), createUser.getEmail(), createUser.getPassword(), LocalDateTime.now(), LocalDateTime.now(), UserStatus.Connected, createUser.getAge(), createUser.getGender(), createUser.getInterests(), createUser.getCountry());
	    System.out.println("User created : " + user.toString());
	    return userServiceImpl.addUtilisateur(user);
	}

	
	@PostMapping("/Login")
	public Response<User> login(@RequestBody UserDto loginUser) {
		User user = userServiceImpl.getUtilisateurByMail(loginUser.getEmail()).getData();
		if (user != null) {
			if (passwordUtils.matchPassword(user.getPassword(), user.getPassword())) {
				return Response.successfulResponse("Login successful",user);
			}
			return Response.failedResponse("Login failed : wrong password");
		}
		return Response.failedResponse("Login failed : wrong email");
	}
	
}
