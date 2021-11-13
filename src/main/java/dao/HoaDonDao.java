package dao;

import entity.HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HoaDonDao extends Remote {
    public List<HoaDon> layDanhSachHoaDon() throws RemoteException;

    public boolean themHoaDon(HoaDon hoaDon) throws RemoteException;

    public HoaDon timHoaDonTheoMa(String maHoaDon) throws RemoteException;

    public long laySoLuongHoaDonTheoThang(int thang) throws RemoteException;

    public long laySoLuongHoaDonTheoNgay(int ngay, int thang) throws RemoteException;

    public double layDoanhThuTheoThang(int thang) throws RemoteException;

    public double layDoanhThuTheoNgay(int ngay, int thang) throws RemoteException;
}
