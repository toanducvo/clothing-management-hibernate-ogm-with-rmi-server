package dao.implement;

import dao.SanPhamDao;
import entity.KhachHang;
import entity.SanPham;
import util.HibernateUtil;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SanPhamImpl extends UnicastRemoteObject implements SanPhamDao {
    private EntityManager entityManager;

    public SanPhamImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<SanPham> layDanhSachSanPham() {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dssanpham.find({})";
        	
        	List<SanPham> dsSanPham = session.createNativeQuery(query, SanPham.class)
					.getResultList();
      
            trans.commit();
            return dsSanPham;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
    	
        return null;
    }

    @Override
    public boolean themSanPham(SanPham sanPham) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicBoolean rs = new AtomicBoolean(false);
        
        try {
        	trans.begin();
        	
        	session.save(sanPham);
        	rs.set(true);
        
            trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }

    @Override
    public boolean xoaSanPham(String maSanPham) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicBoolean rs = new AtomicBoolean(false);
        
        try {
        	trans.begin();
        
        	session.delete(session.find(SanPham.class, maSanPham));
      
            trans.commit();
            rs.set(true);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
    	
        return rs.get();
    }

    @Override
    public boolean capNhatSanPham(SanPham sanPham) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicBoolean rs = new AtomicBoolean(false);
        
        try {
        	trans.begin();
        	
        	session.merge(sanPham);
        	rs.set(true);
        
            trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return false;
		}
        return rs.get();
    }

    @Override
    public SanPham timSanPhamTheoMa(String maSanPham) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dssanpham.find({'_id': '"+maSanPham+"'})";
        	
        	List<SanPham> dsSanPham = session.createNativeQuery(query, SanPham.class)
					.getResultList();
      
            trans.commit();
            return dsSanPham.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return null;
    }

    @Override
    public SanPham timSanPhamTheoTen(String tenSanPham) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dssanpham.find({'tenSanPham': '"+tenSanPham+"'})";
        	
        	List<SanPham> dsSanPham = session.createNativeQuery(query, SanPham.class)
					.getResultList();
      
            trans.commit();
            return dsSanPham.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return null;
    }
}
