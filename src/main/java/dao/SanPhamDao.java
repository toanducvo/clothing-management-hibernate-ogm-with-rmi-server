package dao;

import entity.SanPham;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SanPhamDao extends Remote {
    List<SanPham> layDanhSachSanPham() throws RemoteException;

    boolean themSanPham(SanPham sanPham) throws RemoteException;

    boolean xoaSanPham(String maSanPham) throws RemoteException;

    boolean capNhatSanPham(String maSanPham, SanPham sanPham) throws RemoteException;

    SanPham timSanPhamTheoMa(String maSanPham) throws RemoteException;

    List<SanPham> timSanPhamTheoTen(String tenSanPham) throws RemoteException;
}
