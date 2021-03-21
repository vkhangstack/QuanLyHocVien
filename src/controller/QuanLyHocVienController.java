
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.HocVienService;
import service.HocVienServiceImpl;
import utility.ClassTableModel;
import view.HocVienJFrame;
import view.MainJFrame;


public class QuanLyHocVienController {
    private final JPanel jpnView;
    private final JButton btnAdd;
    private final JTextField jtfSearch;
    private JButton btnPrint;
    
    private ClassTableModel classTableModel = null;
    
    private final String[] COLUMNS = {
        "STT", "Mã học viên", "Tên học viên","Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"
    };
    
    private HocVienService hocVienService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnPrint) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnPrint = btnPrint;
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
//        table.getColumnModel().getColumn(0).setMaxWidth(0);
//        table.getColumnModel().getColumn(0).setMinWidth(0);
//        table.getColumnModel().getColumn(0).setPreferredWidth(0);
//        
//        table.getColumnModel().getColumn(1).setMaxWidth(50);
//        table.getColumnModel().getColumn(1).setMinWidth(50);
//        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        //design table
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(80, 40));
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
                btnAdd.setBackground(new Color(204, 0, 204));
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
        //button Print lắng nghe sự kiện
         btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                btnPrint.setBackground(new Color(204, 0, 204));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnPrint.setBackground(new Color(0, 200, 83));
            }
            //when mouse click sẽ tạo sheet và ghi file excel
            @Override
            public void mouseClicked(MouseEvent e) {
                
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Học Viên");
                
                XSSFRow row = null;
                Cell cell = null;
                
                row = sheet.createRow(3);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue("STT");
                
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Họ và tên");
                
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Ngày sinh");
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Giới tính");
                
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Số điện thoại");
                
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Địa chỉ");
                
                List<HocVien> listItem = hocVienService.getList();
                if(listItem != null){
                    FileOutputStream  fis = null;
                    try {
                        int  s = listItem.size();
                        for(int i = 0; i < s;i++){
                            HocVien hocVien = listItem.get(i);
                            
                            row = sheet.createRow(4 + i);
                            
                            cell  = row.createCell(0, CellType.NUMERIC);
                            cell.setCellValue(i + 1);
                            
                            cell = row.createCell(1, CellType.STRING);
                            cell.setCellValue(hocVien.getHo_ten());
                            
                            cell = row.createCell(2, CellType.STRING);
                            cell.setCellValue(hocVien.getNgay_sinh());
                            
                            cell = row.createCell(3, CellType.STRING);
                            cell.setCellValue(hocVien.isGioi_tinh() ? "Nam" : "Nữ"); // nếu isGioiTinh  == true write Nam và false ghi Nữ
                            System.err.println(hocVien.isGioi_tinh());
//                            if(hocVien.isGioi_tinh() == true){
//                                cell.setCellValue("Nam");
//                            } else {
//                                cell.setCellValue("Nữ");
//                            }
                            
                            cell = row.createCell(4, CellType.STRING);
                            cell.setCellValue(hocVien.getSo_dien_thoai());
                            
                            cell = row.createCell(5, CellType.STRING);
                            cell.setCellValue(hocVien.getDia_chi());
                        }   //save file
                        File file = new File("./fileExport/hoc_vien.xlsx");
                        fis = new FileOutputStream(file);
                        try {
                            workbook.write(fis);
                        } catch (IOException ex) {
                            Logger.getLogger(QuanLyHocVienController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        fis.close();
                        MainJFrame frame = new MainJFrame();
                        JOptionPane.showMessageDialog(frame, "File saving to"+ file);
                        
                                               
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fis.close();
                        } catch (IOException ex) {
                            Logger.getLogger(QuanLyHocVienController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
            
        });
    }
    
}
