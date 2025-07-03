package com.example.eTestCenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisForm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String dor; // ngay dang ki
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "registrationCount", "maxCount"})
    private TestSchedule schedule;
}
