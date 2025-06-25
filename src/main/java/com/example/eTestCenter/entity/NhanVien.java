package com.example.eTestCenter.entity;

import com.example.eTestCenter.entity.enums.VaiTroNhanVien;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "nhan_vien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_nhan_vien", unique = true, nullable = false, length = 50)
    private String maNhanVien;

    @Column(name = "ho_ten", nullable = false, length = 255)
    private String hoTen;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh", length = 50)
    private String gioiTinh;

    @Column(name = "dia_chi", length = 500)
    private String diaChi;

    @Column(name = "so_dien_thoai", unique = true, length = 20)
    private String soDienThoai;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "vai_tro", nullable = false, length = 50)
    private VaiTroNhanVien vaiTro;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "nhanVienKeToan")
    private Set<PhieuThanhToan> phieuThanhToansCreated;

    @OneToMany(mappedBy = "nhanVienTiepNhan")
    private Set<PhieuDangKy> phieuDangKysProcessed;

    @OneToMany(mappedBy = "nhanVienNhapLieu")
    private Set<BangTinh> bangTinhsEntered;

    @OneToMany(mappedBy = "nhanVienTiepNhan")
    private Set<PhieuGiaHan> phieuGiaHansProcessed;

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