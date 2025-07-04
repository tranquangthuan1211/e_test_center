package com.example.eTestCenter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String dot;
    private String address;
    private int registration_count;
    private int max_count;
    private String name_test;

}
