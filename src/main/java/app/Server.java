package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import dao.TaiKhoanDao;
import dao.implement.HoaDonImpl;
import dao.implement.KhachHangImpl;
import dao.implement.NhanVienImpl;
import dao.implement.SanPhamImpl;
import dao.implement.TaiKhoanImpl;

public class Server {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            System.setProperty("java.security.policy", "rmi/policy.policy");
            System.setSecurityManager(new SecurityManager());
        }

        try {
        	HoaDonDao hoaDonDao = new HoaDonImpl();
        	KhachHangDao khachHangDao = new KhachHangImpl();
        	SanPhamDao sanPhamDao = new SanPhamImpl();
        	NhanVienDao nhanVienDao = new NhanVienImpl();
        	TaiKhoanDao taikhoanDao = new TaiKhoanImpl();
            LocateRegistry.createRegistry(9988);
            Naming.bind("rmi://192.168.1.9:9988/hoaDonDao", hoaDonDao);
            Naming.bind("rmi://192.168.1.9:9988/khachHangDao", khachHangDao);
            Naming.bind("rmi://192.168.1.9:9988/sanPhamDao", sanPhamDao);
            Naming.bind("rmi://192.168.1.9:9988/nhanVienDao", nhanVienDao);
            Naming.bind("rmi://192.168.1.9:9988/taiKhoanDao", taikhoanDao);
            
            
            
            
			System.out.println("Remote Object bound in RMIRegistry");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
