package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "lich_thi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LichThi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_lich_thi", unique = true, nullable = false, length = 50)
    private String maLichThi;

    @Column(name = "ngay_thi", nullable = false)
    private LocalDate ngayThi;

    @Column(name = "gio_thi")
    private LocalTime gioThi;

    @Column(name = "thoi_luong_thi_phut")
    private Integer thoiLuongThiPhut;

    @Column(name = "phong_thi", length = 50)
    private String phongThi;

    @Column(name = "so_luong_dang_ky_toi_da")
    private Integer soLuongDangKyToiDa;

    @Column(name = "so_luong_da_dang_ky")
    private Integer soLuongDaDangKy = 0;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loai_chung_chi_id", nullable = false)
    private LoaiChungChi loaiChungChi;

    @OneToMany(mappedBy = "lichThi")
    private Set<DanhSachDuThi> danhSachDuThis;

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
