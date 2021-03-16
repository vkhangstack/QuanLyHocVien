
package service;

import bean.KhoaHocBean;
import bean.LopHocBean;
import dao.ThongKeDAO;
import dao.ThongKeDAOImpl;
import java.util.List;


public class ThongKeServiceImpl implements ThongKeService{

    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        thongKeDAO = new ThongKeDAOImpl();
    }
    
    
    @Override
    public List<LopHocBean> getListByLopHoc() {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAO.getListByKhoaHoc();
    }
    
    
    
}
