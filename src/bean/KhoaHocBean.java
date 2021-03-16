package bean;

import java.util.Date;

public class KhoaHocBean {

    private String tenKhoaHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public KhoaHocBean() {
    }

    public KhoaHocBean(String tenKhoaHoc, Date ngayBatDau, Date ngayKetThuc) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
}
