
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;
import utility.ClassTableModel;
import view.HocVienJFrame;


public class QuanLyHocVienController {
    private final JPanel jpnView;
    private final JButton btnAdd;
    private final JTextField jtfSearch;
    
    private ClassTableModel classTableModel = null;
    
    private final String[] COLUMNS = {
        "Mã học viên", "STT", "Tên học viên","Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"
    };
    
    private HocVienService hocVienService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.hocVienService = new HocVienServiceImpl();
    }
    public void actionPerfomed(ActionEvent e){
        
    }
    public void setDataToTable(){
        List<HocVien> listItem = hocVienService.getList();
        DefaultTableModel model = classTableModel.setTableHocVien(listItem, COLUMNS);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            //jtfSearch lớn 1 kí tự sẽ start filter
            @Override
            public void insertUpdate(DocumentEvent e) {
               String text = jtfSearch.getText();
               if(text.trim().length() == 00){
                   rowSorter.setRowFilter(null);
               } else {
                   rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
               }
            }
            //xoá 1 kí tự start Filter
            @Override
            public void removeUpdate(DocumentEvent e) {
               String text = jtfSearch.getText();
               if(text.trim().length() == 0){
                   rowSorter.setRowFilter(null);
               } else {
                   rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
               }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        //table lắng nghe sự kiện mouse.
          table.addMouseListener(new MouseAdapter() {
             @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.err.println(selectedRowIndex);
                    
                    HocVien hocVien = new HocVien();
                    hocVien.setMa_hoc_vien((int) model.getValueAt(selectedRowIndex, 0));
                    hocVien.setHo_ten(model.getValueAt(selectedRowIndex, 2).toString());
                    hocVien.setNgay_sinh((Date) model.getValueAt(selectedRowIndex, 3));
                    hocVien.setGioi_tinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    hocVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 5) != null ? model.getValueAt(selectedRowIndex, 5).toString() : "");
                    hocVien.setDia_chi(model.getValueAt(selectedRowIndex, 6) != null ? model.getValueAt(selectedRowIndex, 6).toString() : "");
                    hocVien.setTinh_trang((boolean)model.getValueAt(selectedRowIndex, 7));
                    
                    //khi mouse click sẽ open HocVienJFrame
                    HocVienJFrame frame = new HocVienJFrame(hocVien);
                    frame.setTitle("Thông tin học viên");
                    frame.setLocationRelativeTo(null);//center desktop
                    frame.setVisible(true);
                    frame.setResizable(false);//no resize
                    
                    
                }
            }
            
        });
        //design
        //custom width;
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        //design table
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
      
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1300, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                HocVienJFrame frame = new HocVienJFrame(new HocVien());
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Thông tin học viên");
    
                
            }
            
        });
    }
    
}
