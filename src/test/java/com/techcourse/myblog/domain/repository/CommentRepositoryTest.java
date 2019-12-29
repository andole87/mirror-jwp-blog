package com.techcourse.myblog.domain.repository;

import com.techcourse.myblog.domain.Article;
import com.techcourse.myblog.domain.Comment;
import com.techcourse.myblog.domain.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    private TestEntityManager tm;

    @Autowired
    private CommentRepository repository;

    private Writer writer;
    private Article article;

    @BeforeEach
    void setUp() {
        writer = Writer.builder()
                .nickname("nickname")
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
    void CRUD() {
        tm.persistAndFlush(article);
        Comment comment = Comment.builder()
                .author(writer)
                .article(article)
                .contents("contents")
                .build();

        repository.save(comment);

        assertThat(comment.getId()).isNotNull();

        Comment update = Comment.builder()
                .author(writer)
                .article(article)
                .contents("update")
                .build();

        comment.update(update);
        repository.save(comment);

        Optional<Comment> result = repository.findById(comment.getId());

        assertThat(result.isPresent()).isTrue();

        Comment persist = result.get();
        assertThat(persist.getContents()).isEqualTo("update");

        repository.delete(persist);

        assertThat(repository.findById(persist.getId())).isEmpty();
    }
}