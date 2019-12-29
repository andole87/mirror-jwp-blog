package com.techcourse.myblog.service;

import com.techcourse.myblog.domain.Article;
import com.techcourse.myblog.domain.Comment;
import com.techcourse.myblog.domain.Writer;
import com.techcourse.myblog.domain.repository.ArticleRepository;
import com.techcourse.myblog.domain.repository.CommentRepository;
import com.techcourse.myblog.dto.ArticleRequestDto;
import com.techcourse.myblog.dto.ArticleResponseDto;
import com.techcourse.myblog.dto.CommentRequestDto;
import com.techcourse.myblog.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {
    private final WriterService writerService;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleResponseDto publish(ArticleRequestDto requestDto) {
        Writer author = writerService.findByEmail(requestDto.getEmail());
        Article persist = articleRepository.save(requestDto.toEntity(author));
        return new ArticleResponseDto(persist);
    }

    public CommentResponseDto append(long articleId, String email, CommentRequestDto requestDto) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        Writer author = writerService.findByEmail(email);

        Comment persist = commentRepository.save(requestDto.toEntity(author, article));

        return new CommentResponseDto(persist);
    }

    public ArticleResponseDto findById(long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        return new ArticleResponseDto(article);
    }

    public List<ArticleResponseDto> findAllArticles() {
        return articleRepository.findAll().stream()
                .map(ArticleResponseDto::new)
                .collect(Collectors.toList());
    }

    public CommentResponseDto append(long articleId, CommentRequestDto requestDto) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        Writer author = writerService.findByEmail(requestDto.getEmail());

        Comment persist = commentRepository.save(requestDto.toEntity(author, article));

        return new CommentResponseDto(persist);
    }

    public List<CommentResponseDto> findAllComment(long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        return commentRepository.findByArticle(article).stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}
