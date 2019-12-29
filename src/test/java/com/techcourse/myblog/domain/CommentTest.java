package com.techcourse.myblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CommentTest {
    @Autowired
    private TestEntityManager tm;

    private Writer writer;
    private Article article;


    @BeforeEach
    void setUp() {
        writer = Writer.builder()
                .nickname("nick")
                .password("password")
                .email("email@email.com")
                .build();

        article = Article.builder()
                .author(writer)
                .title("title")
                .contents("contents")
                .build();
    }

    @Test
    void create() {
        Comment comment = new Comment(writer, article, "comment");

        assertThat(comment.getContents()).isEqualTo("comment");
        assertThat(comment.getId()).isNull();
    }

    @Test
    void update() {
        Comment comment = new Comment(writer, article, "comment");
        Comment update = new Comment(writer, article, "update");

        comment.update(update);

        assertThat(comment.getContents()).isEqualTo("update");
    }

    @Test
    void relation() {
        tm.persist(article);

        Comment comment = new Comment(writer, article, "contents");
        tm.persistAndFlush(comment);

        assertThat(comment.getId()).isNotNull();
        Comment persist = tm.find(Comment.class, comment.getId());

        assertThat(persist.getAuthor().getId()).isNotNull();
        assertThat(persist.getArticle().getId()).isNotNull();
    }
}