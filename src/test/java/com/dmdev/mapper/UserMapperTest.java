package com.dmdev.mapper;

import com.dmdev.dto.UserDto;
import com.dmdev.entity.Gender;
import com.dmdev.entity.Role;
import com.dmdev.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {



    @Test
    void shouldMapToUserDto() {

        User victim = User.builder()
                .id(1)
                .name("Ivan")
                .birthday(LocalDate.of(2000, 12, 12))
                .email("ivan2000@mail.ru")
                .role(Role.ADMIN)
                .gender(Gender.MALE)
                .build();
        UserDto actual = UserMapper.getInstance().map(victim);

        Assertions.assertEquals(
                actual,
                UserDto.builder()
                        .id(victim.getId())
                        .name(victim.getName())
                        .birthday(victim.getBirthday())
                        .email(victim.getEmail())
                        .role(victim.getRole())
                        .gender(victim.getGender())
                        .build());
    }



    @Test
    void shouldNotThrowNpeExceptionOnNullRole() {
        User victim = User.builder()
                .id(1)
                .name("Ivan")
                .birthday(LocalDate.of(2000, 12, 12))
                .email("ivan2000@mail.ru")
                .role(null)
                .gender(Gender.MALE)
                .build();
        UserDto actual = UserMapper.getInstance().map(victim);
        Assertions.assertEquals(
                actual,
                UserDto.builder()
                        .id(victim.getId())
                        .name(victim.getName())
                        .birthday(victim.getBirthday())
                        .email(victim.getEmail())
                        .role(victim.getRole())
                        .gender(victim.getGender())
                        .build());
    }

    @Test
    void shouldNotThrowNpeExceptionOnNullGender() {
        User victim = User.builder()
                .id(1)
                .name("Ivan")
                .birthday(LocalDate.of(2000, 12, 12))
                .email("ivan2000@mail.ru")
                .role(Role.USER)
                .gender(null)
                .build();
        UserDto actual = UserMapper.getInstance().map(victim);
        Assertions.assertEquals(
                actual,
                UserDto.builder()
                        .id(victim.getId())
                        .name(victim.getName())
                        .birthday(victim.getBirthday())
                        .email(victim.getEmail())
                        .role(victim.getRole())
                        .gender(victim.getGender())
                        .build());
    }
}