package com.techcourse.myblog.domain;

import com.techcourse.myblog.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Article extends AbstractEntity {
    private String title;
    private String contents;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_WRITER_ARTICLE"))
    private Writer writer;

    @Builder
    public Article(Writer writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }

    public Article update(Article another) {
        this.title = another.title;
        this.contents = another.contents;
        return this;
    }
}
