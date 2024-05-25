package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Post;

public interface PostService {
	
	public void createPost();
	
	public void updatePost();
	
	public void deletePost();
	
	public Response<List<Post>> getPostByUserIdSub(int id);

}
