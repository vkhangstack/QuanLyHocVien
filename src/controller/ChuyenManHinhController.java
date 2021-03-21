
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import view.HocVienJPanel;
import view.KhoaHocJPanel;
import view.LopHocJPanel;
import view.ThongKeJPanel;
import view.TrangChuPanel;
import view.UpdateJPanel;


public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }

    public  void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jpnItem.setBackground(new Color(96, 100, 191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        } 
           
        @Override
        public void mouseClicked(MouseEvent arg0) {
         switch (kind) {
             case  "TrangChu":
                 node = new TrangChuPanel();
                 setChangeBackground(kind);
                 break;
             case "HocVien":
                 node = new HocVienJPanel();
                 setChangeBackground(kind);
                 break;
             case "KhoaHoc":
                 node = new KhoaHocJPanel();
                 setChangeBackground(kind);
                 break;
             case "LopHoc":
                 //node = new LopHocJPanel();
                 setChangeBackground(kind);
                 //update
                 node = new UpdateJPanel();
                 setChangeBackground(kind);
                 //
                 break;
             case "ThongKe":
                 node = new ThongKeJPanel();
                 setChangeBackground(kind);
                 break;
              default:
                  node = new TrangChuPanel();
                  break;
         }
         root.removeAll();
         root.add(node);
         root.validate();
         root.repaint();        
         
         
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
           
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }
        
    }
    public void setChangeBackground(String kind){
        listItem.forEach(item -> {
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        });
    }
}
