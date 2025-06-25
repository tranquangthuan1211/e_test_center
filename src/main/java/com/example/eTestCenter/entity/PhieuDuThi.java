package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "phieu_du_thi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuDuThi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_phieu_du_thi", unique = true, nullable = false, length = 50)
    private String maPhieuDuThi;

    @Column(name = "so_bao_danh", unique = true, nullable = false, length = 50)
    private String soBaoDanh;

    @Column(name = "thoi_gian_phat_hanh", nullable = false)
    private LocalDateTime thoiGianPhatHanh;

    @Column(name = "dia_diem_thi_cu_the", length = 500)
    private String diaDiemThiCuThe;

    @Column(name = "ghi_chu", length = 1000)
    private String ghiChu;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "danh_sach_du_thi_id", unique = true, nullable = false)
    private DanhSachDuThi danhSachDuThi;

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
