
package dao;

import java.util.List;
import model.HocVien;


public interface HocVienDAO {
    public List<HocVien> getList();
    
    public int createOrUpdate(HocVien hocVien);
}
