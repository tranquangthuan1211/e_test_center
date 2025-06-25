package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "don_vi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonVi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_don_vi", unique = true, nullable = false, length = 50)
    private String maDonVi;

    @Column(name = "ten_don_vi", nullable = false, length = 255)
    private String tenDonVi;

    @Column(name = "dia_chi", length = 500)
    private String diaChi;

    @Column(name = "so_dien_thoai", length = 20)
    private String soDienThoai;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "donVi")
    private NguoiDangKy nguoiDangKy;

    @OneToMany(mappedBy = "donVi")
    private Set<NguoiDuThi> nguoiDuThis;

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