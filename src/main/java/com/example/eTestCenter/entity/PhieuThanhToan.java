package com.example.eTestCenter.entity;

import com.example.eTestCenter.entity.enums.PhuongThucThanhToan;
import com.example.eTestCenter.entity.enums.TrangThaiPhieuThanhToan;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "phieu_thanh_toan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_phieu_thanh_toan", unique = true, nullable = false, length = 50)
    private String maPhieuThanhToan;

    @Column(name = "tong_tien", nullable = false, precision = 18, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "so_tien_giam_gia", precision = 18, scale = 2, columnDefinition = "DECIMAL(18,2) DEFAULT 0.00")
    private BigDecimal soTienGiamGia;

    @Column(name = "thanh_tien", nullable = false, precision = 18, scale = 2)
    private BigDecimal thanhTien;

    @Column(name = "ngay_thanh_toan")
    private LocalDateTime ngayThanhToan;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_thanh_toan", nullable = false, length = 50)
    private TrangThaiPhieuThanhToan trangThaiThanhToan;

    @Enumerated(EnumType.STRING)
    @Column(name = "phuong_thuc_thanh_toan", length = 50)
    private PhuongThucThanhToan phuongThucThanhToan;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phieu_dang_ky_id", nullable = false)
    private PhieuDangKy phieuDangKy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_ke_toan_id")
    private NhanVien nhanVienKeToan;

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
