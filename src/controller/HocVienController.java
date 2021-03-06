package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;

public class HocVienController {

    private final JButton btnSubmit;
    private final JTextField jtfMaHocVien;
    private final JTextField jtfHoTen;
    private final JDateChooser jdcNgaySinh;
    private final JRadioButton jrdGioiTinhNam;
    private final JRadioButton JrdGioiTinhNu;
    private final JTextField jtfSoDienThoai;
    private final JTextArea jtaDiaChi;
    private final JCheckBox jcbTinhTrang;
    private final JLabel jlbMsg;
    private HocVien hocVien = null;
    private HocVienService hocVienService = null;

    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, JDateChooser jdcNgaySinh,
            JRadioButton jrdGioiTinhNam, JRadioButton JrdGioiTinhNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi,
            JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdGioiTinhNam = jrdGioiTinhNam;
        this.JrdGioiTinhNu = JrdGioiTinhNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;

        this.hocVienService = new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;

        jtfMaHocVien.setText("#" + hocVien.getMa_hoc_vien());
        jtfHoTen.setText(hocVien.getHo_ten());
        jdcNgaySinh.setDate(hocVien.getNgay_sinh());
        if (hocVien.isGioi_tinh()) {
            jrdGioiTinhNam.setSelected(true);
            JrdGioiTinhNu.setSelected(false);
        } else {
            jrdGioiTinhNam.setSelected(false);
            JrdGioiTinhNu.setSelected(true);
        }

        jtfSoDienThoai.setText(hocVien.getSo_dien_thoai());
        jtaDiaChi.setText(hocVien.getDia_chi());
        jcbTinhTrang.setSelected(hocVien.isTinh_trang());

    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null) {
                    jlbMsg.setText("Vui lo??ng nh????p d???? li????u b????t bu????c");
                } else {
                    hocVien.setHo_ten(jtfHoTen.getText());
                    hocVien.setNgay_sinh(jdcNgaySinh.getDate());
                    hocVien.setGioi_tinh(jrdGioiTinhNam.isSelected());
                    hocVien.setSo_dien_thoai(jtfSoDienThoai.getText());
                    hocVien.setDia_chi(jtaDiaChi.getText());
                    hocVien.setTinh_trang(jcbTinhTrang.isSelected());
                    int lastID = hocVienService.createOrUpdate(hocVien);
                    if (lastID > 0) {
                        hocVien.setMa_hoc_vien(lastID);
                        jtfMaHocVien.setText("#" + lastID);
                        jlbMsg.setText("C????p nh????t d???? li????u tha??nh c??ng!");
                    }

                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(204, 0, 204));
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });
    }

}
