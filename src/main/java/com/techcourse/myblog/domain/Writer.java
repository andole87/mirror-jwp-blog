package com.techcourse.myblog.domain;

import com.techcourse.myblog.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class Writer extends AbstractEntity {
    private String nickName;
    private String email;
    private String password;

    @Builder
    public Writer(String nickName, String email, String password) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }
}
