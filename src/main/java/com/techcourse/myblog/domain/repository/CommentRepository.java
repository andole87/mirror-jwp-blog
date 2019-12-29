package com.techcourse.myblog.domain.repository;

import com.techcourse.myblog.domain.Article;
import com.techcourse.myblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticle(Article article);
}
