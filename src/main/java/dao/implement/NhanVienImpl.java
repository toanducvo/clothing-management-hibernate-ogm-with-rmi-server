package dao.implement;

import dao.NhanVienDao;
import entity.NhanVien;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVienDao {
    private EntityManager entityManager;

    public NhanVienImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public NhanVien layNhanVienTheoMa(String maNhanVien) {
        return null;
    }
}
