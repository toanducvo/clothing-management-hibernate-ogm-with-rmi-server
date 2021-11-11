package entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ChiTietHoaDon implements Serializable {
    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien = 0.0;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(SanPham sanPham, int soLuong, double donGia, double thanhTien) {
        setSanPham(sanPham);
        setSoLuong(soLuong);
        setDonGia(donGia);
        setThanhTien(thanhTien);
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }


    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "sanPham=" + sanPham.getMaSanPham() +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
