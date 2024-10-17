package com.demo.RestApi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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
   @OneToOne(
           mappedBy = "student",
           cascade = CascadeType.ALL
   )
    private StudentProfile studentProfile;

   @ManyToOne(

   )
   @JoinColumn(
           name = "school_id"
   )
   private School school;
}
