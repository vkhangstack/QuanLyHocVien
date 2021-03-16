package main;

import java.awt.Menu;
import javax.swing.ImageIcon;
import view.DangNhapJDialog;
import view.MainJFrame;

public class Main {

    public static void main(String[] args) {
        //new MainJFrame().setVisible(true);
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng nhập hệ thống!");
        dialog.setResizable(false);
        dialog.setVisible(true);
        
    }

}
