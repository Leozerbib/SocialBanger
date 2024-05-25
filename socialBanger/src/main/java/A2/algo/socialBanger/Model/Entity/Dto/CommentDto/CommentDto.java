package A2.algo.socialBanger.Model.Entity.Dto.CommentDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import A2.algo.socialBanger.Model.Entity.Comment;
import A2.algo.socialBanger.Model.Entity.Abstract.UserPlus;
import A2.algo.socialBanger.Model.Entity.Dto.User.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;

    private UserDto user;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
	public static CommentDto from(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setUser(UserDto.fromUser(comment.getUser()));
		commentDto.setContent(comment.getContent());
		commentDto.setCreatedAt(comment.getCreatedAt());
		commentDto.setUpdatedAt(comment.getUpdatedAt());
		return commentDto;
	}
}
