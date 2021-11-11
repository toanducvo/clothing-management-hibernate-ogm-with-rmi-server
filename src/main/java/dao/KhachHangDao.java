package dao;

import entity.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KhachHangDao extends Remote {
    List<KhachHang> layDanhSachKhachHang() throws RemoteException;

    boolean themKhachHang(KhachHang khachHang) throws RemoteException;

    KhachHang timKhachHangTheoSDT(String soDienThoai) throws RemoteException;

    KhachHang timKhachHangTheoMa(String maKhachHang) throws RemoteException;
}
