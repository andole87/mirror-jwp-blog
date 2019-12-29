package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Comment;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommentResponseDto {
    private Long id;
    private String nickname;
    private String contents;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.nickname = comment.getAuthor().getNickname();
        this.contents = comment.getContents();
    }
}
