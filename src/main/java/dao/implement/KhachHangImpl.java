package dao.implement;

import dao.KhachHangDao;
import entity.KhachHang;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangDao {
    private EntityManager entityManager;

    public KhachHangImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<KhachHang> layDanhSachKhachHang() {
        return null;
    }

    @Override
    public boolean themKhachHang(KhachHang khachHang) {
        return false;
    }

    @Override
    public KhachHang timKhachHangTheoSDT(String soDienThoai) {
        return null;
    }

    @Override
    public KhachHang timKhachHangTheoMa(String maKhachHang) {
        return null;
    }
}
