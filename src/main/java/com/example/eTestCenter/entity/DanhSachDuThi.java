package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import scala.collection.mutable.Set;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "danh_sach_du_thi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhSachDuThi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_du_thi_id", nullable = false)
    private NguoiDuThi nguoiDuThi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lich_thi_id", nullable = false)
    private LichThi lichThi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieu_dang_ky_id", nullable = false)
    private PhieuDangKy phieuDangKy;

    @Column(name = "thoi_gian_dang_ky")
    private LocalDateTime thoiGianDangKy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "danhSachDuThi", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private BangTinh bangTinh;

    @OneToOne(mappedBy = "danhSachDuThi", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private PhieuDuThi phieuDuThi;

    @OneToMany(mappedBy = "danhSachDuThi")
    private Set<PhieuGiaHan> phieuGiaHans;

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