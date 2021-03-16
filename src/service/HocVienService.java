
package service;

import java.util.List;
import model.HocVien;


public interface HocVienService {
    public List<HocVien> getList();
    
    public int createOrUpdate(HocVien hocVien);
}
