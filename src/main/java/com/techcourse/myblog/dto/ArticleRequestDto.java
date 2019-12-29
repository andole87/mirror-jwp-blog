package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Article;
import com.techcourse.myblog.domain.Writer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class ArticleRequestDto {
    private String email;
    private String title;
    private String contents;

    @Builder
    public ArticleRequestDto(String email, String title, String contents) {
        this.email = email;
        this.title = title;
        this.contents = contents;
    }

    public Article toEntity(Writer author) {
        return Article.builder()
                .author(author)
                .title(title)
                .contents(contents)
                .build();
    }

    public String getEmail() {
        return email;
    }
}
