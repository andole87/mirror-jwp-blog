package com.techcourse.myblog.dto;

import com.techcourse.myblog.domain.Writer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class WriterRequestDto {
    private String nickname;
    private String email;
    private String password;

    @Builder
    public WriterRequestDto(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public Writer toEntity() {
        return Writer.builder()
                .nickname(nickname)
                .password(password)
                .email(email)
                .build();
    }
}
