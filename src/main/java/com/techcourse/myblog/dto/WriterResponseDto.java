package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Writer;
import lombok.Getter;

@Getter
public class WriterResponseDto {
    private Long id;
    private String nickname;
    private String email;

    public WriterResponseDto(Writer writer) {
        this.id = writer.getId();
        this.nickname = writer.getNickname();
        this.email = writer.getEmail();
    }
}
