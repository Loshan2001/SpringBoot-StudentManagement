package com.demo.RestApi.dto;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        int age,
        Integer schoolId
) {
}
