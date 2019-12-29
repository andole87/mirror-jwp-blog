package com.techcourse.myblog.domain.repository;

import com.techcourse.myblog.domain.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
    Optional<Writer> findByEmail(String email);
}
