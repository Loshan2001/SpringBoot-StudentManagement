package com.demo.RestApi.entity;

import jakarta.persistence.*;

import javax.sound.midi.Sequence;

@Entity
@Table
public record Order(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
         int id,
         String customerName,
         String productName,
         int quantity
) {

}
