package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Writer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WriterRequestDto {
    private String nickname;
    private String email;
    private String password;

    public Writer toEntity() {
        return Writer.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .build();
    }
}
