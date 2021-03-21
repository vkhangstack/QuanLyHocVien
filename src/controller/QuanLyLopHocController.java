package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.HocVien;
import model.LopHoc;
import service.HocVienService;
import service.HocVienServiceImpl;
import service.LopHocService;
import service.LopHocServiceImpl;
import utility.ClassTableModel;

public class QuanLyLopHocController {

    private JPanel jpnView;

    private LopHocService lopHocService = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private ClassTableModel classTableModel = null;

    private final String[] COLUMNS = {
        "STT", "Mã lớp học", "Mã khoá học", "Mã học viên",
        "Ngày đăng ký", "Trạng thái"
    };

    public QuanLyLopHocController(JPanel jpnView) {
        this.jpnView = jpnView;

        this.classTableModel = new ClassTableModel();
        this.lopHocService = new LopHocServiceImpl();
    }

    public void setDataToTable() {
        List<LopHoc> listItem = lopHocService.getList();
        DefaultTableModel model = classTableModel.setTableLopHoc(listItem, COLUMNS);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1300, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
}
