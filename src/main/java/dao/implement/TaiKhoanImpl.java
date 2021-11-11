package dao.implement;

import dao.TaiKhoanDao;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TaiKhoanImpl extends UnicastRemoteObject implements TaiKhoanDao {
    private EntityManager entityManager;

    public TaiKhoanImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public boolean dangNhap(String tenDangNhap, String matKhau) {
        return false;
    }
}
