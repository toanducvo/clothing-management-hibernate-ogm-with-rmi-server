package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import facade.HoaDonFacade;
import facade.KhachHangFacade;
import facade.NhanVienFacade;
import facade.SanPhamFacade;
import facade.TaiKhoanFacade;
import facade.impl.HoaDonImpl;
import facade.impl.KhachHangImpl;
import facade.impl.NhanVienImpl;
import facade.impl.SanPhamImpl;
import facade.impl.TaiKhoanImpl;

public class Server {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            System.setProperty("java.security.policy", "rmi/policy.policy");
            System.setSecurityManager(new SecurityManager());
        }

        try {
        	
        	HoaDonFacade hoaDonDao = new HoaDonImpl();
    		KhachHangFacade khachHangDao = new KhachHangImpl();
    		NhanVienFacade nhanVienDao = new NhanVienImpl();
    		SanPhamFacade sanPhamDao = new SanPhamImpl();
    		TaiKhoanFacade taikhoanDao = new TaiKhoanImpl();
    		
        	
            LocateRegistry.createRegistry(9988);
            Naming.bind("rmi://192.168.1.12:9988/hoaDonDao", hoaDonDao);
            Naming.bind("rmi://192.168.1.12:9988/khachHangDao", khachHangDao);
            Naming.bind("rmi://192.168.1.12:9988/sanPhamDao", sanPhamDao);
            Naming.bind("rmi://192.168.1.12:9988/nhanVienDao", nhanVienDao);
            Naming.bind("rmi://192.168.1.12:9988/taiKhoanDao", taikhoanDao);

            
			System.out.println("Remote Object bound in RMIRegistry");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
