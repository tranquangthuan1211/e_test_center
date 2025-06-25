package com.example.eTestCenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "nguoi_du_thi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDuThi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_nguoi_du_thi", unique = true, nullable = false, length = 50)
    private String maNguoiDuThi;

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

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "don_vi_id")
    private DonVi donVi;

    @OneToOne(mappedBy = "nguoiDuThi")
    private NguoiDangKy nguoiDangKyTuDo;

    @OneToMany(mappedBy = "nguoiDuThi")
    private Set<PhieuDangKy> phieuDangKys;

    @OneToMany(mappedBy = "nguoiDuThi")
    private Set<ChungChi> chungChis;

    @OneToMany(mappedBy = "nguoiDuThi")
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
