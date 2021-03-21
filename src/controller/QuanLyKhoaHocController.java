package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
import model.KhoaHoc;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.KhoaHocService;
import service.KhoaHocServiceImpl;
import utility.ClassTableModel;
import view.HocVienJFrame;
import view.KhoaHocJFrame;
import view.MainJFrame;

public class QuanLyKhoaHocController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnPrint;

    private ClassTableModel classTableModel = null;

    private final String[] COLUMNS = {
        "STT", "Mã khoá hoc", "Tên khoá học", "Mô tả",
        "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
    };

    private KhoaHocService khoaHocService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKhoaHocController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnPrint) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnPrint = btnPrint;

        this.classTableModel = new ClassTableModel();
        this.khoaHocService = new KhoaHocServiceImpl();
    }

    public void setDataToTable() {
        List<KhoaHoc> listItem = khoaHocService.getList();
        DefaultTableModel model = classTableModel.setTableKhoaHoc(listItem, COLUMNS);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        //Search
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            //jtfSearch lớn 1 kí tự sẽ start filter
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 00) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            //xoá 1 kí tự start Filter
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
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
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.err.println(selectedRowIndex);

                    KhoaHoc khoaHoc = new KhoaHoc();
                    khoaHoc.setMa_khoa_hoc((int) model.getValueAt(selectedRowIndex, 0));
                    khoaHoc.setTen_khoa_hoc(model.getValueAt(selectedRowIndex, 2).toString());
                    khoaHoc.setMo_ta(model.getValueAt(selectedRowIndex, 3).toString());
                    khoaHoc.setNgay_bat_dau((Date) model.getValueAt(selectedRowIndex, 4));
                    khoaHoc.setNgay_ket_thuc((Date) model.getValueAt(selectedRowIndex, 5));
                    khoaHoc.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 6));

                    //khi mouse click sẽ open KhoaHocJFrame
                    KhoaHocJFrame frame = new KhoaHocJFrame(khoaHoc);
                    frame.setTitle("Thông tin khoá học");
                    frame.setLocationRelativeTo(null);//center desktop
                    frame.setVisible(true);
                    frame.setResizable(false);//no resize

                }
            }

        });

        //design
        //custom width;
        table.getColumnModel().getColumn(0).setWidth(50);
        table.getColumnModel();

//        table.getColumnModel().getColumn(0).setMinWidth(0);
//        table.getColumnModel().getColumn(0).setPreferredWidth(0);
//        
//        table.getColumnModel().getColumn(1).setMaxWidth(80);
//        table.getColumnModel().getColumn(1).setMinWidth(80);
//        table.getColumnModel().getColumn(1).setPreferredWidth(80);
//        //design table
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
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

    public void setEvent() {
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
                KhoaHocJFrame frame = new KhoaHocJFrame(new KhoaHoc());
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Thông tin khoá học");
            }

        });

        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                btnPrint.setBackground(new Color(204, 0, 204));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnPrint.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Khoá Học");

                XSSFRow row = null;
                Cell cell = null;
                
                row = sheet.createRow(1);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue("STT");
                

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên khoá học");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Mô tả");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Ngày bắt đầu");

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Ngày kết thúc");

                List<KhoaHoc> listItem = khoaHocService.getList();
                if (listItem != null) {
                    FileOutputStream fis = null;
                    try {
                        int s = listItem.size();
                        for (int i = 0; i < s; i++) {
                            KhoaHoc khoaHoc = listItem.get(i);
                            
                            
                            row = sheet.createRow(2 + i);

                            cell = row.createCell(0, CellType.NUMERIC);
                            cell.setCellValue(i + 1);

                            cell = row.createCell(1, CellType.STRING);
                            cell.setCellValue(khoaHoc.getTen_khoa_hoc());

                            cell = row.createCell(2, CellType.STRING);
                            cell.setCellValue(khoaHoc.getMo_ta());

                            cell = row.createCell(3, CellType.STRING);
                            cell.setCellValue(khoaHoc.getNgay_bat_dau());
                            System.err.println(khoaHoc.isTinh_trang());
//                            if(hocVien.isGioi_tinh() == true){
//                                cell.setCellValue("Nam");
//                            } else {
//                                cell.setCellValue("Nữ");
//                            }
                            
                            cell = row.createCell(4, CellType.STRING);
                            cell.setCellValue(khoaHoc.getNgay_ket_thuc());

                        }   //save file
                        File file = new File("./fileExport/khoa_hoc.xlsx");
                        fis = new FileOutputStream(file);
                        try {
                            workbook.write(fis);
                        } catch (IOException ex) {
                            Logger.getLogger(QuanLyKhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        fis.close();
                        MainJFrame frame = new MainJFrame();
                        JOptionPane.showMessageDialog(frame, "File saving to" + file);

                        System.err.println("Print successes!");

                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyKhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fis.close();
                        } catch (IOException ex) {
                            Logger.getLogger(QuanLyKhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        });

    }

}
