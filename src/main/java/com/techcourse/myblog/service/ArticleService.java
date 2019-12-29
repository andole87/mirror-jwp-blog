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

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {
    private final WriterService writerService;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleResponseDto publish(String email, ArticleRequestDto requestDto) {
        Writer author = writerService.findByEmail(email);

        Article persist = articleRepository.save(requestDto.toEntity(author));
        return new ArticleResponseDto(persist);
    }

    public CommentResponseDto append(long articleId, String email, CommentRequestDto requestDto) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        Writer author = writerService.findByEmail(email);

        Comment persist = commentRepository.save(requestDto.toEntity(author, article));

        return new CommentResponseDto(persist);
    }
}
