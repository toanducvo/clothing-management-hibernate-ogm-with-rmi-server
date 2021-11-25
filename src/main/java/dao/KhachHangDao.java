package dao;

import entity.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KhachHangDao extends Remote {
	public List<KhachHang> layDanhSachKhachHang() throws RemoteException;

	public boolean themKhachHang(KhachHang khachHang) throws RemoteException;

	public KhachHang timKhachHangTheoSDT(String soDienThoai) throws RemoteException;

	public KhachHang timKhachHangTheoMa(String maKhachHang) throws RemoteException;

	public boolean capNhatThongTinKhachHang(KhachHang khachHang) throws RemoteException;
}
