package dao;

import entity.HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HoaDonDao extends Remote {
    List<HoaDon> layDanhSachHoaDon() throws RemoteException;

    boolean themHoaDon(HoaDon hoaDon) throws RemoteException;

    HoaDon timHoaDonTheoMa(String maHoaDon) throws RemoteException;

    long laySoLuongHoaDonTheoThang(int thang) throws RemoteException;

    long laySoLuongHoaDonTheoNgay(int ngay, int thang) throws RemoteException;

    long layDoanhThuTheoThang(int thang) throws RemoteException;

    long layDoanhThuTheoNgay(int ngay, int thang) throws RemoteException;
}
