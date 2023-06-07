package com.example.asm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "tainghe")
public class TaiNghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer taiNgheId;

    @Column(name = "tentainghe")
    private String tenTaiNghe;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "tanso")
    private Integer tanSo;

    @Column(name = "congketnoi")
    private String congKetNoi;

    @Column(name = "kichthuocmangloa")
    private Double kichThuocMangLoa;

}
