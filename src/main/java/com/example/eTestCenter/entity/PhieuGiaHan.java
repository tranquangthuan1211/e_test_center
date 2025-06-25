package com.example.eTestCenter.entity;

import com.example.eTestCenter.entity.enums.TrangThaiPhieuGiaHan;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "phieu_gia_han")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiaHan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_phieu_gia_han", unique = true, nullable = false, length = 50)
    private String maPhieuGiaHan;

    @Column(name = "ngay_yeu_cau", nullable = false)
    private LocalDate ngayYeuCau;

    @Column(name = "ngay_gia_han")
    private LocalDate ngayGiaHan;

    @Column(name = "ly_do", length = 1000)
    private String lyDo;

    @Column(name = "phi_gia_han", precision = 18, scale = 2)
    private BigDecimal phiGiaHan;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_gia_han", nullable = false, length = 50)
    private TrangThaiPhieuGiaHan trangThaiGiaHan;

    @Column(name = "so_lan_gia_han", nullable = false)
    private Integer soLanGiaHan;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chung_chi_id")
    private ChungChi chungChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "danh_sach_du_thi_id")
    private DanhSachDuThi danhSachDuThi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_tiep_nhan_id")
    private NhanVien nhanVienTiepNhan;

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
