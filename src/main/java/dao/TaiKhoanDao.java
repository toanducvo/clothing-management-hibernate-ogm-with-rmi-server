package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TaiKhoanDao extends Remote {
    boolean dangNhap(String tenDangNhap, String matKhau) throws RemoteException;
}
