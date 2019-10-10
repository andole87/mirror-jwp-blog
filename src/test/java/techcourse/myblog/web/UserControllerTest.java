package techcourse.myblog.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import techcourse.myblog.domain.user.UserEmail;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserControllerTest extends AuthedWebTestClient {
    @Test
    void 인덱스_페이지_GET() {
        get("/users")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void 회원가입_실패_테스트() {
        long count = userRepository.count();
        webTestClient.post().uri("/users")
                .body(params(Arrays.asList("name", "password", "email"), "a", "b", "c"))
                .exchange()
                .expectStatus().isUnauthorized();

        assertThat(userRepository.count()).isEqualTo(count);
    }

    @Test
    void 회원가입_성공_테스트() {
        webTestClient.post().uri("/users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(params(Arrays.asList("name", "password", "email"), "temp", "A!1bcdefg", "temp@test.com"))
                .exchange()
                .expectStatus().is3xxRedirection()
                .expectHeader().valueMatches("Location", ".+\\/login");
    }

    @Test
    void 회원정보_수정_테스트() {
        put("/users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(params(Arrays.asList("name", "email"), "mobumsaeng", "edit@gmail.com"))
                .exchange().expectStatus().is3xxRedirection();

        assertDoesNotThrow(() -> userRepository.findByEmail(UserEmail.of("edit@gmail.com")).orElseThrow(IllegalAccessError::new));
    }
}