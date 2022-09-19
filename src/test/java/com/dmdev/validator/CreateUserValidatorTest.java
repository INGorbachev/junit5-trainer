package com.dmdev.validator;

import com.dmdev.dto.CreateUserDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateUserValidatorTest {

    @Test
    void validateInvalidBirthday() {

        var error = Error.of("invalid.birthday", "Birthday is invalid");
        var victim = CreateUserDto.builder()
                .name("Name")
                .birthday("2000,11-10")
                .email("mail@mail.ru")
                .password("password")
                .role("ADMIN")
                .gender("FEMALE")
                .build();
        var expected = CreateUserValidator.getInstance().validate(victim);

        assertThat(expected.getErrors()).containsExactly(error);
    }

    @Test
    void validateInvalidGender() {

        var error = Error.of("invalid.gender", "Gender is invalid");
        var victim = CreateUserDto.builder()
                .name("Name")
                .birthday("2000-11-10")
                .email("mail@mail.ru")
                .password("password")
                .role("ADMIN")
                .gender("INVALID")
                .build();
        var expected = CreateUserValidator.getInstance().validate(victim);

        assertThat(expected.getErrors()).containsExactly(error);
    }

    @Test
    void validateInvalidRole() {

        var error = Error.of("invalid.role", "Role is invalid");
        var victim = CreateUserDto.builder()
                .name("Name")
                .birthday("2000-11-10")
                .email("mail@mail.ru")
                .password("password")
                .role("INVALID")
                .gender("MALE")
                .build();
        var expected = CreateUserValidator.getInstance().validate(victim);

        assertThat(expected.getErrors()).containsExactly(error);
    }
}