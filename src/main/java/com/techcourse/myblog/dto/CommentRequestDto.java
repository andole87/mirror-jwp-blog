package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Article;
import com.techcourse.myblog.domain.Comment;
import com.techcourse.myblog.domain.Writer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CommentRequestDto {
    private String contents;

    public Comment toEntity(Writer author, Article article) {
        return Comment.builder()
                .author(author)
                .article(article)
                .contents(this.contents)
                .build();
    }
}
