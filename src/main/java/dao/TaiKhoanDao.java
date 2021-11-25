package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TaiKhoanDao extends Remote {
	public boolean dangNhap(String tenDangNhap, String matKhau) throws RemoteException;
	
	
}
