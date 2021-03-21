package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.TaiKhoan;
import service.TaiKhoanService;
import service.TaiKhoanServiceImpl;
import view.MainJFrame;

public class TaiKhoanController {

    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;
    private JLabel jlbMsg;

    public TaiKhoanService taiKhoanService = null;

    public TaiKhoanController(JDialog dialog, JButton btnSumbit, JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSumbit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;

        taiKhoanService = new TaiKhoanServiceImpl();

    }

    @SuppressWarnings("deprecation")
    public void checklogin() {
        if (jtfTenDangNhap.getText().length() == 0 || jtfMatKhau.getText().length() == 0) {
            jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
        } else {
            TaiKhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(), jtfMatKhau.getText());
            if (taiKhoan == null) {
                jlbMsg.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
            } else {
                if (!taiKhoan.isTinh_trang()) {
                    jlbMsg.setText("Tài khoản đang bị tạm khoá!");
                } else {

                    MainJFrame frame = new MainJFrame();
                    frame.setTitle("Quản Lý Học Viên");
                    //frame.setExtendedState(JFrame.NORMAL);
                    frame.setVisible(true);
                    dialog.dispose();
                }
            }

        }
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            @SuppressWarnings("deprecation")
            public void mouseClicked(MouseEvent e) {
                checklogin();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(255, 255, 255));
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
