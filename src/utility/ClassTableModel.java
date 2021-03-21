
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;


public class ClassTableModel {
    public  DefaultTableModel setTableHocVien(List<HocVien> listIem,String[] listColumn){
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return  false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex){
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listIem.size();
        HocVien hocVien = null;
        for(int i = 0;i < num;i++){
            hocVien = listIem.get(i);
            obj = new Object[columns];
            obj[0] = hocVien.getMa_hoc_vien();
            obj[1] = (i + 1);
            obj[2] = hocVien.getHo_ten();
            obj[3] = hocVien.getNgay_sinh();
            obj[4] = hocVien.isGioi_tinh() == true ? "Nam" : "Nữ";
            obj[5] = hocVien.getSo_dien_thoai();
            obj[6] = hocVien.getDia_chi();
            obj[7] = hocVien.isTinh_trang();
            dtm.addRow(obj);
        }
        
        return dtm;
        
    }
    public  DefaultTableModel setTableKhoaHoc(List<KhoaHoc> listIem,String[] listColumn){
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return  false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex){
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listIem.size();
        KhoaHoc khoaHoc = null;
        for(int i = 0;i < num;i++){
            khoaHoc = listIem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = khoaHoc.getMa_khoa_hoc();
            obj[2] = khoaHoc.getTen_khoa_hoc();
            obj[3] = khoaHoc.getMo_ta();
            obj[4] = khoaHoc.getNgay_bat_dau();
            obj[5] = khoaHoc.getNgay_ket_thuc();
            obj[6] = khoaHoc.isTinh_trang();
            dtm.addRow(obj);
        }
        
        return dtm;
        
    }
    
    
    public  DefaultTableModel setTableLopHoc(List<LopHoc> listIem,String[] listColumn){
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return  false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex){
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listIem.size();
        LopHoc lopHoc = null;
        KhoaHoc khoaHoc = null;
        HocVien hocVien = null;
        for(int i = 0;i < num;i++){
            lopHoc = listIem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = lopHoc.getMa_lop_hoc();
            obj[2] = lopHoc.getKhoaHoc();
            obj[3] = lopHoc.getHocVien();
            obj[4] = lopHoc.getNgay_dang_ky();
            obj[5] = lopHoc.isTinh_trang();
            dtm.addRow(obj);
        }
        
        return dtm;
        
    }
    
}
