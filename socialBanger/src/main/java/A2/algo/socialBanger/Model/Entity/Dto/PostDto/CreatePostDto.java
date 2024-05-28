package A2.algo.socialBanger.Model.Entity.Dto.PostDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import A2.algo.socialBanger.Model.Entity.Comment;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import A2.algo.socialBanger.Model.Entity.Dto.CommentDto.CommentDto;
import A2.algo.socialBanger.Model.Entity.Dto.User.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {
	
	
	private UserPlus user;

    private String content;
    
    private String img_url;


	
}
