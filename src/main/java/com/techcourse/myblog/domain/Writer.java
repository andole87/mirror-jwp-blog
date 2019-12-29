package com.techcourse.myblog.domain;

import com.techcourse.myblog.common.AbstractEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity
public class Writer extends AbstractEntity {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public Writer(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
