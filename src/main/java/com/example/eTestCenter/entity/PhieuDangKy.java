package com.example.eTestCenter.entity;

import com.example.eTestCenter.entity.enums.TrangThaiPhieuDangKy;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "phieu_dang_ky")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_phieu", unique = true, nullable = false, length = 50)
    private String maPhieu;

    @Column(name = "ngay_lap_phieu", nullable = false)
    private LocalDate ngayLapPhieu;

    @Column(name = "ngay_het_han_thanh_toan")
    private LocalDate ngayHetHanThanhToan;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_dang_ky", nullable = false, length = 50)
    private TrangThaiPhieuDangKy trangThaiDangKy;

    @Column(name = "phi_dang_ky", nullable = false, precision = 18, scale = 2)
    private BigDecimal phiDangKy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_dang_ky_id", nullable = false)
    private NguoiDangKy nguoiDangKy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_du_thi_id", nullable = false)
    private NguoiDuThi nguoiDuThi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loai_chung_chi_id", nullable = false)
    private LoaiChungChi loaiChungChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_tiep_nhan_id")
    private NhanVien nhanVienTiepNhan;

    @OneToMany(mappedBy = "phieuDangKy")
    private Set<PhieuThanhToan> phieuThanhToans;

    @OneToMany(mappedBy = "phieuDangKy")
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