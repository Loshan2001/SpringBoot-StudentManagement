package com.demo.RestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer id;
    private String schoolName;

}
