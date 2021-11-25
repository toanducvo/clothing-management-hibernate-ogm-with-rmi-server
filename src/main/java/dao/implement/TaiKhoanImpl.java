package dao.implement;

import dao.TaiKhoanDao;
import entity.SanPham;
import util.HibernateUtil;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaiKhoanImpl extends UnicastRemoteObject implements TaiKhoanDao {
    private EntityManager entityManager;

    public TaiKhoanImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public boolean dangNhap(String tenDangNhap, String matKhau) {
    	
    	OgmSession session = entityManager.unwrap(OgmSession.class);
        Transaction trans = session.getTransaction();
        AtomicBoolean rs = new AtomicBoolean(false);
        
        String query = "db.dstaikhoan.find({'_id': '"+tenDangNhap+"'})";
        
       List<?> list = session.createNativeQuery(query).getResultList();
       
       for(Object obj: list) {
			Object[] o = (Object[]) obj;
			String temp = (String)o[1];
			if(temp.equals(matKhau))
				rs.set(true);
		}
        
        try {
        	trans.begin();
        	
            trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
        return rs.get();
    }
}
