package dao.implement;

import dao.HoaDonDao;
import entity.HoaDon;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonDao {
    private EntityManager entityManager;

    public HoaDonImpl() throws RemoteException {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    @Override
    public List<HoaDon> layDanhSachHoaDon() {
        return null;
    }

    @Override
    public boolean themHoaDon(HoaDon hoaDon) {
        return false;
    }

    @Override
    public HoaDon timHoaDonTheoMa(String maHoaDon) {
        return null;
    }

    @Override
    public long laySoLuongHoaDonTheoThang(int thang) {
        return 0;
    }

    @Override
    public long laySoLuongHoaDonTheoNgay(int ngay, int thang) {
        return 0;
    }

    @Override
    public long layDoanhThuTheoThang(int thang) {
        return 0;
    }

    @Override
    public long layDoanhThuTheoNgay(int ngay, int thang) {
        return 0;
    }
}
