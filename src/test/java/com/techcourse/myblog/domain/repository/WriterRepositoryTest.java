package com.techcourse.myblog.domain.repository;

import com.techcourse.myblog.domain.Writer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WriterRepositoryTest {
    @Autowired
    private WriterRepository repository;

    @Test
    void CRUD() {
        Writer writer = Writer.builder()
                .nickname("nickname")
                .password("password")
                .email("email@email.com")
                .build();

        repository.saveAndFlush(writer);

        assertThat(writer.getId()).isNotNull();

        writer.update(new Writer("another", "update@update.com", "password"));
        repository.saveAndFlush(writer);

        Optional<Writer> findResult = repository.findById(writer.getId());

        assertThat(findResult.isPresent()).isTrue();

        Writer persist = findResult.get();
        assertThat(persist.getNickname()).isEqualTo("another");
        assertThat(persist.getEmail()).isEqualTo("update@update.com");

        repository.delete(persist);

        assertThat(repository.findById(persist.getId()).isPresent()).isFalse();
    }
}