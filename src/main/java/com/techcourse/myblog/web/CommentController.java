package com.techcourse.myblog.web;

import com.techcourse.myblog.dto.CommentRequestDto;
import com.techcourse.myblog.dto.CommentResponseDto;
import com.techcourse.myblog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/articles/{articleId}/comments")
public class CommentController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity append(@PathVariable long articleId, @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto comment = articleService.append(articleId, requestDto);
        return ResponseEntity.created(URI.create("http://localhost:8080/articles/" + articleId + "/comments/" + comment.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getAllCommentByArticleId(@PathVariable long articleId) {
        List<CommentResponseDto> comments = articleService.findAllComment(articleId);
        return ResponseEntity.ok(comments);
    }
}
