package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.KhoaHoc;
import service.KhoaHocService;
import service.KhoaHocServiceImpl;

public class KhoaHocController {

    private JButton btnSubmit;
    private JTextField jtfMaKhoaHoc;
    private JTextField jtfTenKhoaHoc;
    private JDateChooser jdcNgayBegin;
    private JDateChooser jdcNgayEnd;
    private JTextArea jtfMoTa;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;
    
    
    private KhoaHoc khoaHoc = null;
    private KhoaHocService khoaHocService = null;

    public KhoaHocController(JButton btnSubmit, JTextField jtfMaKhoaHoc, JTextField jtfTenKhoaHoc, JDateChooser jdcNgayBegin, JDateChooser jdcNgayEnd, JTextArea jtfMoTa, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaKhoaHoc = jtfMaKhoaHoc;
        this.jtfTenKhoaHoc = jtfTenKhoaHoc;
        this.jdcNgayBegin = jdcNgayBegin;
        this.jdcNgayEnd = jdcNgayEnd;
        this.jtfMoTa = jtfMoTa;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        this.khoaHocService = new KhoaHocServiceImpl();
    }
    
    public void setView(KhoaHoc khoaHoc){
        this.khoaHoc = khoaHoc;
        
        jtfMaKhoaHoc.setText("#" + khoaHoc.getMa_khoa_hoc());
        jtfTenKhoaHoc.setText(khoaHoc.getTen_khoa_hoc());
        jdcNgayBegin.setDate(khoaHoc.getNgay_bat_dau());
        jdcNgayEnd.setDate(khoaHoc.getNgay_ket_thuc());
        jtfMoTa.setText(khoaHoc.getMo_ta());
        jcbTinhTrang.setSelected(khoaHoc.isTinh_trang());
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(204, 0, 204));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfTenKhoaHoc.getText().length() == 0 || jdcNgayBegin.getDate() == null || jdcNgayEnd.getDate() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                } else {
                    //khoaHoc.setMa_khoa_hoc(jtfMaKhoaHoc.getInt());
                    khoaHoc.setTen_khoa_hoc(jtfTenKhoaHoc.getText());
                    khoaHoc.setMo_ta(jtfMoTa.getText());
                    khoaHoc.setNgay_bat_dau(jdcNgayBegin.getDate());
                    khoaHoc.setNgay_ket_thuc(jdcNgayEnd.getDate());
                    khoaHoc.setTinh_trang(jcbTinhTrang.isSelected());
                    int lastID = khoaHocService.createOrUpdate(khoaHoc);
                    if(lastID > 0){
                        khoaHoc.setMa_khoa_hoc(lastID);
                        jtfMaKhoaHoc.setText("#" + lastID);
                        jlbMsg.setText("Cập nhật dữ liệu thành công!");
                    }
                }
                
            }
        
        });
    }
    
    
}
