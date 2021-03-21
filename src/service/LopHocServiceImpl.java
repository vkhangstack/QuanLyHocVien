
package service;

import dao.LopHocDAO;
import dao.LopHocDAOImpl;
import java.util.List;
import model.LopHoc;


public class LopHocServiceImpl implements LopHocService{
    private LopHocDAO LopHocDAO = null;
    public LopHocServiceImpl(){
        this.LopHocDAO = new LopHocDAOImpl();
    } 

    @Override
    public List<LopHoc> getList() {              
        return LopHocDAO.getList();
        
    }

}
