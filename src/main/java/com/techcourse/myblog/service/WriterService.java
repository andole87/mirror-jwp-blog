package com.techcourse.myblog.service;

import com.techcourse.myblog.domain.Writer;
import com.techcourse.myblog.domain.repository.WriterRepository;
import com.techcourse.myblog.dto.WriterRequestDto;
import com.techcourse.myblog.dto.WriterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class WriterService {
    private final WriterRepository writerRepository;

    public WriterResponseDto register(WriterRequestDto requestDto) {
        Writer writer = requestDto.toEntity();
        writerRepository.save(writer);
        return new WriterResponseDto(writer);
    }

    public Writer findByEmail(String email) {
        return writerRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
    }
}
