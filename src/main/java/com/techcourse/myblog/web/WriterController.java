package com.techcourse.myblog.web;

import com.techcourse.myblog.dto.WriterRequestDto;
import com.techcourse.myblog.dto.WriterResponseDto;
import com.techcourse.myblog.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/writers")
public class WriterController {
    private static final String BASE_URL = "http://localhost:8080/wirters/";
    private final WriterService writerService;

    @PostMapping
    public ResponseEntity register(@RequestBody WriterRequestDto dto) {
        WriterResponseDto result = writerService.register(dto);
        return ResponseEntity.created(URI.create(BASE_URL + result.getId())).build();
    }
}
