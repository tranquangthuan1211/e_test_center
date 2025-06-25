package com.example.eTestCenter.entity;

import com.example.eTestCenter.entity.enums.TrangThaiChungChi;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "chung_chi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChungChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_chung_chi", unique = true, nullable = false, length = 100)
    private String maChungChi;

    @Column(name = "ngay_cap", nullable = false)
    private LocalDate ngayCap;

    @Column(name = "diem_tong", precision = 5, scale = 2)
    private BigDecimal diemTong;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_chung_chi", length = 50)
    private TrangThaiChungChi trangThaiChungChi;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_du_thi_id", nullable = false)
    private NguoiDuThi nguoiDuThi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loai_chung_chi_id", nullable = false)
    private LoaiChungChi loaiChungChi;

    @OneToMany(mappedBy = "chungChi")
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
