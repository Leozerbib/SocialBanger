package A2.algo.socialBanger.Service.ServiceIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Repo.PostRepository;
import A2.algo.socialBanger.Service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("PostServiceImpl")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void createPost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Response<List<Post>> getPostByUserIdSub(int id) {
		List<Post> posts = postRepository.findByUserSub(id);
		if (posts.isEmpty()) {
			return Response.failedResponse("Post not found");
		}
		System.out.println("Post found : " + posts.toString());
		log.info("Post found : " + posts.get(0).toString());
		return	Response.successfulResponse("Post found", posts);
	}

}
