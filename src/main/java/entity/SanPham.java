package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "dssanpham")
public class SanPham implements Serializable {
    @Id
    private String maSanPham;
    private String loaiSanPham;
    private String nhaCungCap;
    private String tenSanPham;
    private double gia;
    private int soLuong;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> danhSachKichCo;
    private String thuongHieu;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> danhSachMauSac;

    public SanPham() {
    }

    public SanPham(String maSanPham) {
        setMaSanPham(maSanPham);
    }

    public SanPham(String maSanPham, String loaiSanPham, String nhaCungCap, String tenSanPham, double gia, int soLuong, List<String> danhSachKichCo, String thuongHieu, List<String> danhSachMauSac) {
        setMaSanPham(maSanPham);
        setLoaiSanPham(loaiSanPham);
        setNhaCungCap(nhaCungCap);
        setTenSanPham(tenSanPham);
        setGia(gia);
        setSoLuong(soLuong);
        setDanhSachKichCo(danhSachKichCo);
        setThuongHieu(thuongHieu);
        setDanhSachMauSac(danhSachMauSac);
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public List<String> getDanhSachKichCo() {
        return danhSachKichCo;
    }

    public void setDanhSachKichCo(List<String> danhSachKichCo) {
        this.danhSachKichCo = danhSachKichCo;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public List<String> getDanhSachMauSac() {
        return danhSachMauSac;
    }

    public void setDanhSachMauSac(List<String> danhSachMauSac) {
        this.danhSachMauSac = danhSachMauSac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SanPham)) return false;

        SanPham sanPham = (SanPham) o;

        return getMaSanPham().equals(sanPham.getMaSanPham());
    }

    @Override
    public int hashCode() {
        return getMaSanPham().hashCode();
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham='" + maSanPham + '\'' +
                ", loaiSanPham='" + loaiSanPham + '\'' +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", danhSachKichCo=" + danhSachKichCo +
                ", thuongHieu='" + thuongHieu + '\'' +
                ", danhSachMauSac=" + danhSachMauSac +
                '}';
    }
}
