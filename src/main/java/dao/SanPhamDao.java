package dao;

import entity.SanPham;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SanPhamDao extends Remote {
	public List<SanPham> layDanhSachSanPham() throws RemoteException;

	public boolean themSanPham(SanPham sanPham) throws RemoteException;

	public boolean xoaSanPham(String maSanPham) throws RemoteException;

	public boolean capNhatSanPham(SanPham sanPham) throws RemoteException;

	public SanPham timSanPhamTheoMa(String maSanPham) throws RemoteException;

	public SanPham timSanPhamTheoTen(String tenSanPham) throws RemoteException;
}
