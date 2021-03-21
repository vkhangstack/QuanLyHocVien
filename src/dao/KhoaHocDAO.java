
package dao;

import java.util.List;
import model.KhoaHoc;


public interface KhoaHocDAO {
    public List<KhoaHoc> getList();
    
    public int createOrUpdate(KhoaHoc khoaHoc);
}
