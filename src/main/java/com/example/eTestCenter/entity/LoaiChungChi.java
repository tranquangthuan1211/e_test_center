package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "loai_chung_chi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiChungChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_loai_chung_chi", unique = true, nullable = false, length = 50)
    private String maLoaiChungChi;

    @Column(name = "ten_loai_chung_chi", nullable = false, length = 255)
    private String tenLoaiChungChi;

    @Column(name = "gia_tien", nullable = false, precision = 18, scale = 2)
    private BigDecimal giaTien;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "loaiChungChi")
    private Set<ChungChi> chungChis;

    @OneToMany(mappedBy = "loaiChungChi")
    private Set<LichThi> lichThis;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}