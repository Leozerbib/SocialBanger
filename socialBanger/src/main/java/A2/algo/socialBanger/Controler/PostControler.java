package A2.algo.socialBanger.Controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.Dto.PostDto.PostDto;
import A2.algo.socialBanger.Service.ServiceIMPL.PostServiceImpl;
import A2.algo.socialBanger.Service.ServiceIMPL.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostControler {
	
	@Autowired
	PostServiceImpl postServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

	@RequestMapping(path = "/hello")
	public String sayHello() {
		log.info("GET called on /hello resource");
		return HELLO_TEXT;
	}
	
	@GetMapping("/getpostsub")
	public Response<List<PostDto>> getPostByUserIdSub(@RequestParam int id) {
		if (userServiceImpl.getUtilisateurById(id) == null) {
			System.out.println("User not found");
			return Response.failedResponse("User not found");
		}
		log.info("Get all posts by user id");
		List<PostDto> posts = new ArrayList<PostDto>();
		for (Post post : postServiceImpl.getPostByUserIdSub(id).getData()) {
			posts.add(PostDto.postToPostDto(post));
		}
		return Response.successfulResponse("Post found", posts);
	}
	
}
