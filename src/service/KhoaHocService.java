package service;

import java.util.List;
import model.KhoaHoc;

public interface KhoaHocService {

    public List<KhoaHoc> getList();
    
    public int createOrUpdate(KhoaHoc khoaHoc);
}
