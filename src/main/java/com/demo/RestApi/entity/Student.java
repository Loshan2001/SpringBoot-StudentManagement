package com.demo.RestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
}
