package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "dsnhanvien")
public class NhanVien implements Serializable {
    @Id
    private String maNhanVien;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String email;
    private String soDienThoai;
    private String CMND;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien) {
        setMaNhanVien(maNhanVien);
    }

    public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, boolean gioiTinh, String email, String soDienThoai, String CMND) {
        setMaNhanVien(maNhanVien);
        setHoTen(hoTen);
        setNgaySinh(ngaySinh);
        setGioiTinh(gioiTinh);
        setEmail(email);
        setSoDienThoai(soDienThoai);
        setCMND(CMND);
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien)) return false;

        NhanVien nhanVien = (NhanVien) o;

        return getMaNhanVien().equals(nhanVien.getMaNhanVien());
    }

    @Override
    public int hashCode() {
        return getMaNhanVien().hashCode();
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", CMND='" + CMND + '\'' +
                '}';
    }
}
