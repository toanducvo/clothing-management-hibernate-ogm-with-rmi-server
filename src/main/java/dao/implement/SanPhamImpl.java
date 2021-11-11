package dao.implement;

import dao.SanPhamDao;
import entity.SanPham;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SanPhamImpl extends UnicastRemoteObject implements SanPhamDao {
    private EntityManager entityManager;

    public SanPhamImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<SanPham> layDanhSachSanPham() {
        return null;
    }

    @Override
    public boolean themSanPham(SanPham sanPham) {
        return false;
    }

    @Override
    public boolean xoaSanPham(String maSanPham) {
        return false;
    }

    @Override
    public boolean capNhatSanPham(String maSanPham, SanPham sanPham) {
        return false;
    }

    @Override
    public SanPham timSanPhamTheoMa(String maSanPham) {
        return null;
    }

    @Override
    public List<SanPham> timSanPhamTheoTen(String tenSanPham) {
        return null;
    }
}
