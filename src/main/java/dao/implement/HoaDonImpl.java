package dao.implement;

import dao.HoaDonDao;
import entity.HoaDon;
import entity.KhachHang;
import util.HibernateUtil;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonDao {
    private EntityManager entityManager;

    public HoaDonImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<HoaDon> layDanhSachHoaDon() {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dshoadon.find({})";
        	
        	List<HoaDon> dsHoaDon = session.createNativeQuery(query, HoaDon.class)
					.getResultList();
      
            trans.commit();
            return dsHoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
    	
        return null;
    }

    @Override
    public boolean themHoaDon(HoaDon hoaDon) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicBoolean rs = new AtomicBoolean(false);
        
        try {
        	trans.begin();
        	
        	session.save(hoaDon);
        	rs.set(true);
        
            trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }

    @Override
    public HoaDon timHoaDonTheoMa(String maHoaDon) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        
        try {
        	trans.begin();
        	
        	String query = "db.dshoadon.find({'_id': '"+maHoaDon+"'})";
        	
        	List<HoaDon> dsHoaDon = session.createNativeQuery(query, HoaDon.class)
					.getResultList();
      
            trans.commit();
            return dsHoaDon.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return null;
    }

//    db.dshoadon.aggregate([{$match: {$expr: {$and: [{$eq: [{$year: "$ngayTao"},2021]}, {$eq: [{$month: "$ngayTao"}, 11]}]}}}, 
//    						{$group: {_id: null, soHoaDon: {$count: {}}}}])
    @Override
    public long laySoLuongHoaDonTheoThang(int thang) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicInteger rs = new AtomicInteger(0);
        
        try {
        	trans.begin();
        	
        	String query = "db.dshoadon.aggregate([{'$match': {'$expr': {'$and': [{'$eq': [{'$year': '$ngayTao'},2021]}, {'$eq': [{'$month': '$ngayTao'}, "+thang+"]}]}}}, {'$group': {'_id': null, 'soHoaDon': {'$count': {}}}}])";
        	
        	List<?> list = session.createNativeQuery(query).getResultList();
        	
        	for(Object obj: list) {
				Object[] o = (Object[]) obj;
				rs.set((int) o[1]);
			}
      
            trans.commit();
           
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }

    @Override
    public long laySoLuongHoaDonTheoNgay(int ngay, int thang) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicInteger rs = new AtomicInteger(0);
        
        try {
        	trans.begin();
        	
        	String query = "db.dshoadon.aggregate([{'$match': {'$expr': {'$and': [{'$eq': [{'$year': '$ngayTao'},2021]}, {'$eq': [{'$month': '$ngayTao'}, "+thang+"]}, {$eq: [{$dayOfMonth: \"$ngayTao\"}, "+ngay+"]}]}}}, {'$group': {'_id': null, 'soHoaDon': {'$count': {}}}}])";
        	
        	List<?> list = session.createNativeQuery(query).getResultList();
        	
        	for(Object obj: list) {
				Object[] o = (Object[]) obj;
				rs.set((int) o[1]);
			}
      
            trans.commit();
           
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }
    
//    db.dshoadon.aggregate([{$match: {$expr: {$and: [{$eq: [{$year: "$ngayTao"},2021]}, {$eq: [{$month: "$ngayTao"}, 11]}]}}}, {$group: {_id: null, doanhThu: {$sum: "$tongTienHoaDon"}}}])

    @Override
    public double layDoanhThuTheoThang(int thang) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicReference<Double> rs = new AtomicReference<>();
        
        try {
        	trans.begin();
        	
        	String query = "db.dshoadon.aggregate([{'$match': {'$expr': {'$and': [{'$eq': [{'$year': '$ngayTao'},2021]}, {'$eq': [{'$month': '$ngayTao'}, "+thang+"]}]}}}, {'$group': {'_id': null, 'doanhThu': {'$sum': '$tongTienHoaDon'}}}])";
        	
        	List<?> list = session.createNativeQuery(query).getResultList();
        	
        	for(Object obj: list) {
				Object[] o = (Object[]) obj;
				rs.set((double) o[1]);
			}
      
            trans.commit();
           
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }
    
//    db.dshoadon.aggregate([{$match: {$expr: {$and: [{$eq: [{$year: "$ngayTao"},2021]}, {$eq: [{$month: "$ngayTao"}, 11]}, {$eq: [{$dayOfMonth: "$ngayTao"}, 1]}]}}}, {$group: {_id: null, doanhThu: {$sum: "$tongTienHoaDon"}}}])

    @Override
    public double layDoanhThuTheoNgay(int ngay, int thang) {
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicReference<Double> rs = new AtomicReference<>();
        
        try {
        	trans.begin();
        	
        	String query = "db.dshoadon.aggregate([{'$match': {'$expr': {'$and': [{'$eq': [{'$year': '$ngayTao'},2021]}, {'$eq': [{'$month': '$ngayTao'}, "+thang+"]}, {'$eq': [{'$dayOfMonth': '$ngayTao'}, "+ngay+"]}]}}}, {'$group': {'_id': null, 'doanhThu': {'$sum': '$tongTienHoaDon'}}}])";
        	
        	List<?> list = session.createNativeQuery(query).getResultList();
        	
        	for(Object obj: list) {
				Object[] o = (Object[]) obj;
				rs.set((double) o[1]);
			}
      
            trans.commit();
           
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }
}
