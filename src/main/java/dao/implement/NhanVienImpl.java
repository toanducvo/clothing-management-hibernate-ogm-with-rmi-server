package dao.implement;

import dao.NhanVienDao;
import entity.NhanVien;
import entity.SanPham;
import util.HibernateUtil;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVienDao {
    private EntityManager entityManager;

    public NhanVienImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public NhanVien layNhanVienTheoMa(String maNhanVien) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dsnhanvien.find({'_id': '"+maNhanVien+"'})";
        	
        	List<NhanVien> dsNhanVien = session.createNativeQuery(query, NhanVien.class)
					.getResultList();
      
            trans.commit();
            return dsNhanVien.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return null;
    }
}
