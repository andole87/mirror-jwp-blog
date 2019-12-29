package com.techcourse.myblog.domain;

import com.techcourse.myblog.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Comment extends AbstractEntity {

    @Lob
    @Column(name = "contents")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "FK_COMMENT_WRITER"))
    private Writer author;

    @ManyToOne
    @JoinColumn(name = "article_id", foreignKey = @ForeignKey(name = "FK_COMMENT_ARTICLE"))
    private Article article;

    @Builder
    public Comment(Writer author, Article article, String contents) {
        this.author = author;
        this.article = article;
        this.contents = contents;
    }

    public void update(Comment another) {
        this.contents = another.contents;
    }
}
