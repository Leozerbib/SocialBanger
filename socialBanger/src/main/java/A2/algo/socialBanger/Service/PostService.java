package A2.algo.socialBanger.Service;

import java.util.List;

import A2.algo.socialBanger.Config.Response;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.Abstract.PostPlus;
import A2.algo.socialBanger.Model.Entity.Dto.PostDto.CreatePostDto;

public interface PostService {
	
	public void createPost(CreatePostDto postDto);
	
	public void updatePost();
	
	public void deletePost();
	
	public Response<List<Post>> getPostByUserIdSub(int id);
	
	public List<PostPlus> getUserLikesPostInterest(int id);

}
