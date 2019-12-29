package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Article;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String contents;

    public ArticleResponseDto(Article persist) {
        this.id = persist.getId();
        this.title = persist.getTitle();
        this.contents = persist.getContents();
    }
}
