package com.example.eTestCenter.entity;

import jakarta.persistence.*;

@Entity
public class RegisForm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String dor; // ngay dang ki
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private TestSchedule schedule;
}
