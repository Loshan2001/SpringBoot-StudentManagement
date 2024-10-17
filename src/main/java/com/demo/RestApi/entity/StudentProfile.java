package com.demo.RestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String bio;

    @OneToOne(

    )
    @JoinColumn(
            name = "student_id"
    )
    private Student student;
}
