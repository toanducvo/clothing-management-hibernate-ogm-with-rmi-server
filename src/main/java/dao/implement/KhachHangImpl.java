package dao.implement;

import dao.KhachHangDao;
import entity.KhachHang;
import util.HibernateUtil;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangDao {
    private EntityManager entityManager;

    public KhachHangImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<KhachHang> layDanhSachKhachHang() {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dskhachhang.find({})";
        	
        	List<KhachHang> dsKhachHang = session.createNativeQuery(query, KhachHang.class)
					.getResultList();
      
            trans.commit();
            return dsKhachHang;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
    	
        return null;
    }

    @Override
    public boolean themKhachHang(KhachHang khachHang) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicBoolean rs = new AtomicBoolean(false);
        
        try {
        	trans.begin();
        	
        	session.save(khachHang);
        	rs.set(true);
        
            trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }

//  db.dskhachhang.find({soDienThoai: '0345285471'})
    @Override
    public KhachHang timKhachHangTheoSDT(String soDienThoai) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dskhachhang.find({'soDienThoai': '"+soDienThoai+"'})";
        	
        	List<KhachHang> dsKhachHang = session.createNativeQuery(query, KhachHang.class)
					.getResultList();
      
            trans.commit();
            return dsKhachHang.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
    	
        return null;
    }

//    db.dskhachhang.find({_id: 'KH00001'})
    @Override
    public KhachHang timKhachHangTheoMa(String maKhachHang) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dskhachhang.find({'_id': '"+maKhachHang+"'})";
        	
        	List<KhachHang> dsKhachHang = session.createNativeQuery(query, KhachHang.class)
					.getResultList();
      
            trans.commit();
            return dsKhachHang.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return null;
    }
}
