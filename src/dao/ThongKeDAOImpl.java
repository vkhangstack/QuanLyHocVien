package dao;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.lang.System.Logger;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

   

public class ThongKeDAOImpl implements ThongKeDAO {

    @Override
    public List<LopHocBean> getListByLopHoc() {
        try {

            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ngay_dang_ky, COUNT(*) AS so_luong FROM lop_hoc GROUP BY ngay_dang_ky";
            List<LopHocBean> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHocBean lopHocBean = new LopHocBean();
                lopHocBean.setNgayDangKy(rs.getString("ngay_dang_ky"));
                lopHocBean.setSoLuongHocVien(rs.getInt("so_luong"));
                list.add(lopHocBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        try {

            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc FROM khoa_hoc WHERE tinh_trang = TRUE";
            List<KhoaHocBean> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHocBean khoaHocBean = new KhoaHocBean();
                khoaHocBean.setTenKhoaHoc(rs.getString("ten_khoa_hoc"));
                khoaHocBean.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                khoaHocBean.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
                list.add(khoaHocBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
