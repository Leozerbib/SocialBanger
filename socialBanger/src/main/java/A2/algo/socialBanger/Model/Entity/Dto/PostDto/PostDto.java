package A2.algo.socialBanger.Model.Entity.Dto.PostDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import A2.algo.socialBanger.Model.Entity.Comment;
import A2.algo.socialBanger.Model.Entity.Hashtag;
import A2.algo.socialBanger.Model.Entity.Interest;
import A2.algo.socialBanger.Model.Entity.Like;
import A2.algo.socialBanger.Model.Entity.Post;
import A2.algo.socialBanger.Model.Entity.User;
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
public class PostDto {
	
    private Long id;

    private UserDto user;

    private String content;

    
    private LocalDateTime createdAt;

    
    private LocalDateTime updatedAt;

    
    private String location;
    
    private String img_url;
        
    private Set<CommentDto> comments = new HashSet<>();
    
    private int countLikes;
    
    
	public static PostDto postToPostDto(Post post) {
		Set<CommentDto> comments = new HashSet<>();
		for (Comment c : post.getComments()) {
			comments.add(CommentDto.from(c));
		}
		return new PostDto(post.getId(), UserDto.fromUser(post.getUser()), post.getContent(), post.getCreatedAt(), post.getUpdatedAt(),
				post.getLocation(), post.getImg_url() , comments,post.getLikes().size());
	}


	@Override
	public String toString() {
		return "PostDto [id=" + id + ", user=" + user + ", content=" + content + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", location=" + location + ", img_url=" + img_url + ", interests="
				 + ", comments=" + comments + ", countLikes=" + countLikes + "]";
	}
	
	
}
