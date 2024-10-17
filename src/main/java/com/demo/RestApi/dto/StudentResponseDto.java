package com.demo.RestApi.dto;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        int age,
        Integer schoolId
) {

}
