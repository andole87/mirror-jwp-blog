package com.techcourse.myblog.web;

import com.techcourse.myblog.dto.ArticleRequestDto;
import com.techcourse.myblog.dto.ArticleResponseDto;
import com.techcourse.myblog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity publish(@RequestBody ArticleRequestDto requestDto) {
        ArticleResponseDto article = articleService.publish(requestDto);
        return ResponseEntity.created(URI.create("http://localhost:8080/articles/" + article.getId())).build();
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponseDto> getOneArticle(@PathVariable long articleId) {
        ArticleResponseDto article = articleService.findById(articleId);
        return ResponseEntity.ok(article);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getAllArticle() {
        List<ArticleResponseDto> articles = articleService.findAllArticles();
        return ResponseEntity.ok(articles);
    }
}
