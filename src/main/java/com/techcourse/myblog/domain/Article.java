package com.techcourse.myblog.domain;

import com.techcourse.myblog.common.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article extends AbstractEntity {

    @Column(name = "title", length = 100)
    private String title;

    @Lob
    @Column(name = "contents")
    private String contents;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "FK_WRITER_ARTICLE"))
    private Writer author;

    @Builder
    public Article(Writer author, String title, String contents) {
        this.author = author;
        this.title = title;
        this.contents = contents;
    }

    public Article update(Article another) {
        this.title = another.title;
        this.contents = another.contents;
        return this;
    }
}
