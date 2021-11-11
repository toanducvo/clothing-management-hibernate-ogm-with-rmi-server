package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "dskhachhang")
public class KhachHang implements Serializable {
    @Id
    private String maKhachHang;
    private String hoTen;
    private String soDienThoai;
    private boolean gioiTinh;
    private String email;
    private LocalDate ngaySinh;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang) {
        setMaKhachHang(maKhachHang);
    }

    public KhachHang(String maKhachHang, String hoTen, String soDienThoai, boolean gioiTinh, String email, LocalDate ngaySinh) {
        setMaKhachHang(maKhachHang);
        setHoTen(hoTen);
        setSoDienThoai(soDienThoai);
        setGioiTinh(gioiTinh);
        setEmail(email);
        setNgaySinh(ngaySinh);
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhachHang)) return false;

        KhachHang khachHang = (KhachHang) o;

        return getMaKhachHang().equals(khachHang.getMaKhachHang());
    }

    @Override
    public int hashCode() {
        return getMaKhachHang().hashCode();
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", email='" + email + '\'' +
                ", ngaySinh=" + ngaySinh +
                '}';
    }
}
