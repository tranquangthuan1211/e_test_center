package com.example.eTestCenter.entity;

import com.example.eTestCenter.entity.enums.KetQuaThi;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bang_tinh")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BangTinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "danh_sach_du_thi_id", unique = true, nullable = false)
    private DanhSachDuThi danhSachDuThi;

    @Column(name = "diem_tong", precision = 5, scale = 2)
    private BigDecimal diemTong;

    @Enumerated(EnumType.STRING)
    @Column(name = "ket_qua", nullable = false, length = 50)
    private KetQuaThi ketQua;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_nhap_lieu_id")
    private NhanVien nhanVienNhapLieu;

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
