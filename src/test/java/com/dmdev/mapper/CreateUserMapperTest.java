package com.dmdev.mapper;

import com.dmdev.dto.CreateUserDto;
import com.dmdev.entity.Gender;
import com.dmdev.entity.Role;
import com.dmdev.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CreateUserMapperTest {



    @Test
    void shouldMapToUser() {

        CreateUserDto victim = CreateUserDto.builder()
                .name("Ivan")
                .birthday("2000-12-12")
                .email("ivan2000@mail.ru")
                .password("pass")
                .role("USER")
                .gender("MALE")
                .build();
        User actual = CreateUserMapper.getInstance().map(victim);

        Assertions.assertEquals(
                actual,
                User.builder()
                        .name(victim.getName())
                        .birthday(LocalDate.parse(victim.getBirthday()))
                        .email(victim.getEmail())
                        .password(victim.getPassword())
                        .role(Role.find(victim.getRole()).orElse(null))
                        .gender(Gender.find(victim.getGender()).orElse(null))
                        .build());
    }

    @Test
    void shouldNotThrowNpeOnNullRole() {

        CreateUserDto victim = CreateUserDto.builder()
                .name("Ivan")
                .birthday("2000-12-12")
                .email("ivan2000@mail.ru")
                .password("pass")
                .role(null)
                .gender("MALE")
                .build();
        User actual = CreateUserMapper.getInstance().map(victim);

        Assertions.assertEquals(
                actual,
                User.builder()
                        .name(victim.getName())
                        .birthday(LocalDate.parse(victim.getBirthday()))
                        .email(victim.getEmail())
                        .password(victim.getPassword())
                        .role(Role.find(victim.getRole()).orElse(null))
                        .gender(Gender.find(victim.getGender()).orElse(null))
                        .build());
    }

    @Test
    void shouldNotThrowNpeOnNullGender() {

        CreateUserDto victim = CreateUserDto.builder()
                .name("Ivan")
                .birthday("2000-12-12")
                .email("ivan2000@mail.ru")
                .password("pass")
                .role("USER")
                .gender(null)
                .build();
        User actual = CreateUserMapper.getInstance().map(victim);

        Assertions.assertEquals(
                actual,
                User.builder()
                        .name(victim.getName())
                        .birthday(LocalDate.parse(victim.getBirthday()))
                        .email(victim.getEmail())
                        .password(victim.getPassword())
                        .role(Role.find(victim.getRole()).orElse(null))
                        .gender(Gender.find(victim.getGender()).orElse(null))
                        .build());
    }
}