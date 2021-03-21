package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;

public class LopHocDAOImpl implements LopHocDAO {

    @Override
    public List<LopHoc> getList() {

        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM lop_hoc";
        List<LopHoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHoc lopHoc = new LopHoc();
                KhoaHoc khoaHoc = new KhoaHoc();
                HocVien hocVien = new HocVien();
                lopHoc.setMa_lop_hoc(rs.getInt("ma_lop_hoc"));
                //lopHoc.setKhoaHoc(rs.getInt("select ma_hoc_vien from khoa_hoc"));
                //hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                //opHoc.setKhoaHoc(khoaHoc);
                hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                lopHoc.setNgay_dang_ky(rs.getDate("ngay_dang_ky"));
                lopHoc.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(lopHoc);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        LopHocDAO lopHocDAO = new LopHocDAOImpl();
        KhoaHocDAO khoaHocDAO = new KhoaHocDAOImpl();

        System.out.println(lopHocDAO.getList());
        System.err.println(khoaHocDAO.getList());
    }

}
