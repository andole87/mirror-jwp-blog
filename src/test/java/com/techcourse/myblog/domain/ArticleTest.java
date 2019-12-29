package com.techcourse.myblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArticleTest {
    @Autowired
    private TestEntityManager tm;

    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = Writer.builder()
                .nickName("nickname")
                .email("email@email.com")
                .password("password")
                .build();
    }

    @Test
    void create() {
        Article article = new Article(writer, "title", "contents");

        assertThat(article.getContents()).isEqualTo("contents");
        assertThat(article.getTitle()).isEqualTo("title");
        assertThat(article.getId()).isNull();
        assertThat(article.getWriter().getNickname()).isEqualTo("nickname");
    }

    @Test
    void update() {
        Article article = new Article(writer, "title", "contents");
        Article update = new Article(writer, "another", "another");

        article.update(update);

        assertThat(article.getTitle()).isEqualTo("another");
        assertThat(article.getContents()).isEqualTo("another");
    }

    @Test
    void manyToOne() {
        Article article = new Article(writer, "title", "contents");

        tm.persistAndFlush(article);

        assertThat(article.getId()).isNotNull();
        assertThat(article.getWriter().getId()).isNotNull();

        Article persist = tm.find(Article.class, article.getId());
        assertThat(persist.getTitle()).isEqualTo(article.getTitle());
        assertThat(persist.getContents()).isEqualTo(article.getContents());
    }
}