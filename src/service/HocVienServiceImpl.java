
package service;

import dao.HocVienDAO;
import dao.HocVienDAOImpl;
import java.util.List;
import model.HocVien;


public class HocVienServiceImpl implements HocVienService{
    private HocVienDAO HocVienDAO = null;
    public HocVienServiceImpl(){
        this.HocVienDAO = new HocVienDAOImpl();
    }
    @Override
    public List<HocVien> getList() {
        return HocVienDAO.getList();
    }

    @Override
    public int createOrUpdate(HocVien hocVien) {
        return HocVienDAO.createOrUpdate(hocVien);
    }

    
}
