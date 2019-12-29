package com.techcourse.myblog.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class WriterTest {
    @Test
    void create() {
        Writer writer = new Writer("nickname", "email@email.com", "password");
        assertThat(writer.getNickName()).isEqualTo("nickname");
        assertThat(writer.getPassword()).isEqualTo("password");
        assertThat(writer.getEmail()).isEqualTo("email@email.com");
        assertThat(writer.getId()).isNull();
    }

    @Test
    void equalsAndHashCode() {
        Writer writer = new Writer("nick", "email@email.com", "password");
        Writer writer2 = new Writer("abc", "abc@abc.com", "password");

        assertThat(writer).isEqualTo(writer2);
        assertThat(new HashSet<>(Arrays.asList(writer, writer2)).size()).isEqualTo(1);
    }
}