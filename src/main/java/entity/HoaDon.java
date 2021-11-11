package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class HoaDon implements Serializable {
    @Id
    private String maHoaDon;

    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;

    private LocalDateTime ngayTao;
    private double giamGia;
    private double tongTienHoaDon = 0.0;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ChiTietHoaDon> danhSachChiTietHoaDon;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon) {
        setMaHoaDon(maHoaDon);
    }

    public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, LocalDateTime ngayTao, double giamGia, double tongTienHoaDon, List<ChiTietHoaDon> danhSachChiTietHoaDon) {
        setMaHoaDon(maHoaDon);
        setKhachHang(khachHang);
        setNhanVien(nhanVien);
        setNgayTao(ngayTao);
        setGiamGia(giamGia);
        setTongTienHoaDon(tongTienHoaDon);
        setDanhSachChiTietHoaDon(danhSachChiTietHoaDon);
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getTongTienHoaDon() {
        return tongTienHoaDon;
    }

    public void setTongTienHoaDon(double tongTienHoaDon) {
        this.tongTienHoaDon = tongTienHoaDon;
    }

    public List<ChiTietHoaDon> getDanhSachChiTietHoaDon() {
        return danhSachChiTietHoaDon;
    }

    public void setDanhSachChiTietHoaDon(List<ChiTietHoaDon> danhSachChiTietHoaDon) {
        this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoaDon)) return false;

        HoaDon hoaDon = (HoaDon) o;

        return getMaHoaDon().equals(hoaDon.getMaHoaDon());
    }

    @Override
    public int hashCode() {
        return getMaHoaDon().hashCode();
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", khachHang=" + khachHang.getMaKhachHang() +
                ", nhanVien=" + nhanVien.getMaNhanVien() +
                ", ngayTao=" + ngayTao +
                ", giamGia=" + giamGia +
                ", tongTienHoaDon=" + tongTienHoaDon +
                ", danhSachChiTietHoaDon=" + danhSachChiTietHoaDon +
                '}';
    }
}
