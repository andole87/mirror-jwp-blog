package com.techcourse.myblog.domain.repository;

import com.techcourse.myblog.domain.Article;
import com.techcourse.myblog.domain.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository repository;

    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = Writer.builder()
                .nickname("nickname")
                .password("password")
                .email("email@email.com")
                .build();
    }

    @Test
    void CRUD() {
        Article article = Article.builder()
                .author(writer)
                .title("title")
                .contents("contents")
                .build();

        repository.saveAndFlush(article);

        assertThat(article.getId()).isNotNull();

        Article update = Article.builder()
                .author(writer)
                .title("update")
                .contents("update")
                .build();

        article.update(update);
        repository.saveAndFlush(article);

        Optional<Article> result = repository.findById(article.getId());

        assertThat(result.isPresent()).isTrue();
        Article persist = result.get();

        assertThat(persist.getTitle()).isEqualTo("update");
        assertThat(persist.getContents()).isEqualTo("update");

        repository.delete(persist);

        assertThat(repository.findById(persist.getId())).isEmpty();
    }
}