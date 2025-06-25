package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import scala.collection.mutable.Set;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "nguoi_dang_ky")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loai_nguoi_dang_ky", nullable = false, length = 50)
    private String loaiNguoiDangKy;

    @Column(name = "ho_ten", length = 255)
    private String hoTen;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "so_dien_thoai", length = 20)
    private String soDienThoai;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_du_thi_id", unique = true)
    private NguoiDuThi nguoiDuThi;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "don_vi_id", unique = true)
    private DonVi donVi;

    @OneToMany(mappedBy = "nguoiDangKy")
    private Set<PhieuDangKy> phieuDangKys;

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