package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.implement.HoaDonImpl;
import dao.implement.KhachHangImpl;

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
            LocateRegistry.createRegistry(9988);
            Naming.bind("rmi://192.168.1.9:9988/hoadonDao", hoaDonDao);
            Naming.bind("rmi://192.168.1.9:9988/khachhangDAo", khachHangDao);
            
			System.out.println("Remote Object bound in RMIRegistry");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
