
package service;

import dao.KhoaHocDAO;
import dao.KhoaHocDAOImpl;
import java.util.List;
import model.KhoaHoc;


public class KhoaHocServiceImpl implements KhoaHocService{
    private KhoaHocDAO khoaHocDAO = null;

    public KhoaHocServiceImpl() {
        this.khoaHocDAO = new KhoaHocDAOImpl();
    }
    
    @Override
    public List<KhoaHoc> getList() {
        return  khoaHocDAO.getList();
    }

    @Override
    public int createOrUpdate(KhoaHoc khoaHoc) {
        return khoaHocDAO.createOrUpdate(khoaHoc);
    }

}
