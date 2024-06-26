package dev.goormthon.jejucart.domain.comment;

import dev.goormthon.jejucart.domain.comment.dto.CommentRequest;
import dev.goormthon.jejucart.global.common.BaseResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static dev.goormthon.jejucart.global.status.SuccessStatus.COMMENT_SAVE_SUCCESS;

@AllArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글을 작성하는 컨트롤러입니다.
     * @param writeDto
     * @param id
     * @return
     */
    @PostMapping("/api/v1/policy/{id}/comment")
    public BaseResponseDto<?> saveComment(@RequestBody CommentRequest.WriteDto writeDto, @PathVariable Long id) {
        commentService.save(writeDto, id);
        return BaseResponseDto.SuccessResponse(COMMENT_SAVE_SUCCESS);
    }
}
