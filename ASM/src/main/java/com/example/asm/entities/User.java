package com.example.asm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "[user]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gioitinh")
    private String gioiTinh;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "matkhau")
    private String matKhau;

    @Column(name = "email")
    private String email;

    @Column(name = "trangthai")
    private Integer trangThai;

    @OneToMany(mappedBy = "user")
    private List<HoaDon> listHD;

    @OneToMany(mappedBy = "user")
    private List<GioHang> listGH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrole", referencedColumnName = "id")
    private Role role;
}
