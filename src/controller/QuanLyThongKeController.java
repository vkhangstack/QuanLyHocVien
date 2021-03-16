package controller;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import service.ThongKeService;
import service.ThongKeServiceImpl;

public class QuanLyThongKeController {

    private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        thongKeService = new ThongKeServiceImpl();
    }

    public void setDateToChar(JPanel jpnItem) {
        List<LopHocBean> listItem = thongKeService.getListByLopHoc();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (LopHocBean item : listItem) {
                dataset.addValue(item.getSoLuongHocVien(), "Học Viên", item.getNgayDangKy());
            }
            JFreeChart chart = ChartFactory.createBarChart("Thống kê số lượng học viên đăng ký",
                    "Thời gian", "Số lượng", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();

        }
    }

    public void setDateToChar2(JPanel jpnItem) {
        List<KhoaHocBean> listItem = thongKeService.getListByKhoaHoc();
        if (listItem != null) {
            TaskSeriesCollection ds = new TaskSeriesCollection();
            Task task;
            TaskSeries taskSeries;
            for (KhoaHocBean item : listItem) {
                taskSeries = new TaskSeries(item.getTenKhoaHoc());
                task = new Task(item.getTenKhoaHoc(), item.getNgayBatDau(), item.getNgayKetThuc());
                taskSeries.add(task);
                ds.add(taskSeries);
            }
            JFreeChart chart = ChartFactory.createGanttChart("Thống kê tình trạng khoá học",
                    "Khoá học", "Thời gian", ds);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
}
