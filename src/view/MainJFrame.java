package view;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class MainJFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /** Creates new form MainJFrame */
    public MainJFrame() {
        initComponents();
        setTitle("Quản Lý Học Viên");
        setLocationRelativeTo(null);
        setResizable(true);
       
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnTrangChu, jlbTrangChu);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("TrangChu", jpnTrangChu,jlbTrangChu));
        listItem.add(new DanhMucBean("HocVien",jpnHocVien,jlbHocVien));
        listItem.add(new DanhMucBean("KhoaHoc", jpnKhoaHoc,jlbKhoaHoc));
        listItem.add(new DanhMucBean("LopHoc",jpnLopHoc, jlbLopHoc));
        listItem.add(new DanhMucBean("ThongKe",jpnThongKe,jlbThongKe));
        controller.setEvent(listItem);
        
    } 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnLogo = new javax.swing.JPanel();
        jlbLogo = new javax.swing.JLabel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnHocVien = new javax.swing.JPanel();
        jlbHocVien = new javax.swing.JLabel();
        jpnKhoaHoc = new javax.swing.JPanel();
        jlbKhoaHoc = new javax.swing.JLabel();
        jpnLopHoc = new javax.swing.JPanel();
        jlbLopHoc = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpnRoot.setBackground(new java.awt.Color(254, 254, 254));

        jpnMenu.setBackground(new java.awt.Color(254, 254, 254));

        jpnLogo.setBackground(new java.awt.Color(165, 22, 226));

        jlbLogo.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jlbLogo.setForeground(new java.awt.Color(254, 254, 254));
        jlbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resume.png"))); // NOI18N
        jlbLogo.setText("Quản Lý Học Viên");

        javax.swing.GroupLayout jpnLogoLayout = new javax.swing.GroupLayout(jpnLogo);
        jpnLogo.setLayout(jpnLogoLayout);
        jpnLogoLayout.setHorizontalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnLogoLayout.setVerticalGroup(
            jpnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnTrangChu.setBackground(new java.awt.Color(96, 100, 191));

        jlbTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(254, 254, 254));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jlbTrangChu.setText("Màn Hình Chính");

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnHocVien.setBackground(new java.awt.Color(76, 175, 80));

        jlbHocVien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbHocVien.setForeground(new java.awt.Color(254, 254, 254));
        jlbHocVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graduated.png"))); // NOI18N
        jlbHocVien.setText("Quản Lý Học Viên");
        jlbHocVien.setFocusable(false);
        jlbHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jpnHocVienLayout = new javax.swing.GroupLayout(jpnHocVien);
        jpnHocVien.setLayout(jpnHocVienLayout);
        jpnHocVienLayout.setHorizontalGroup(
            jpnHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHocVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHocVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnHocVienLayout.setVerticalGroup(
            jpnHocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHocVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHocVien, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnKhoaHoc.setBackground(new java.awt.Color(76, 175, 80));

        jlbKhoaHoc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbKhoaHoc.setForeground(new java.awt.Color(254, 254, 254));
        jlbKhoaHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/online-course.png"))); // NOI18N
        jlbKhoaHoc.setText("Quản Lý Khoá Học");
        jlbKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jpnKhoaHocLayout = new javax.swing.GroupLayout(jpnKhoaHoc);
        jpnKhoaHoc.setLayout(jpnKhoaHocLayout);
        jpnKhoaHocLayout.setHorizontalGroup(
            jpnKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoaHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnKhoaHocLayout.setVerticalGroup(
            jpnKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoaHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnLopHoc.setBackground(new java.awt.Color(76, 175, 80));

        jlbLopHoc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbLopHoc.setForeground(new java.awt.Color(254, 254, 254));
        jlbLopHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/training.png"))); // NOI18N
        jlbLopHoc.setText("Quản Lý Lớp Học");
        jlbLopHoc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jpnLopHocLayout = new javax.swing.GroupLayout(jpnLopHoc);
        jpnLopHoc.setLayout(jpnLopHocLayout);
        jpnLopHocLayout.setHorizontalGroup(
            jpnLopHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnLopHocLayout.setVerticalGroup(
            jpnLopHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnThongKe.setBackground(new java.awt.Color(76, 175, 80));

        jlbThongKe.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(254, 254, 254));
        jlbThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analytics.png"))); // NOI18N
        jlbThongKe.setText("Thống Kê Dữ Liệu");
        jlbThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Coder by Pham Van Khang");

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHocVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jpnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jpnView.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jpnRoot, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlbHocVien;
    private javax.swing.JLabel jlbKhoaHoc;
    private javax.swing.JLabel jlbLogo;
    private javax.swing.JLabel jlbLopHoc;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnHocVien;
    private javax.swing.JPanel jpnKhoaHoc;
    private javax.swing.JPanel jpnLogo;
    private javax.swing.JPanel jpnLopHoc;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables

}
