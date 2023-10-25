import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class QuanLyKhachHang extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtMaKH;
    private JTextField txtTenKH;
    private JTextField txtDiaChi;
    private JTextField txtDienThoai;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    public QuanLyKhachHang() {
        setTitle("Quản lý khách hàng");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã KH");
        tableModel.addColumn("Tên KH");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Điện thoại");

        table = new JTable(tableModel);

        txtMaKH = new JTextField(10);
        txtTenKH = new JTextField(20);
        txtDiaChi = new JTextField(20);
        txtDienThoai = new JTextField(10);

        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Mã KH:"));
        inputPanel.add(txtMaKH);
        inputPanel.add(new JLabel("Tên KH:"));
        inputPanel.add(txtTenKH);
        inputPanel.add(new JLabel("Địa chỉ:"));
        inputPanel.add(txtDiaChi);
        inputPanel.add(new JLabel("Điện thoại:"));
        inputPanel.add(txtDienThoai);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnThem);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoa);

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maKH = txtMaKH.getText();
                String tenKH = txtTenKH.getText();
                String diaChi = txtDiaChi.getText();
                String dienThoai = txtDienThoai.getText();
                String[] rowData = {maKH, tenKH, diaChi, dienThoai};
                tableModel.addRow(rowData);
                clearFields();
            }
        });

        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.setValueAt(txtMaKH.getText(), selectedRow, 0);
                    tableModel.setValueAt(txtTenKH.getText(), selectedRow, 1);
                    tableModel.setValueAt(txtDiaChi.getText(), selectedRow, 2);
                    tableModel.setValueAt(txtDienThoai.getText(), selectedRow, 3);
                    clearFields();
                }
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                    clearFields();
                }
            }
        });

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                txtMaKH.setText(tableModel.getValueAt(row, 0).toString());
                txtTenKH.setText(tableModel.getValueAt(row, 1).toString());
                txtDiaChi.setText(tableModel.getValueAt(row, 2).toString());
                txtDienThoai.setText(tableModel.getValueAt(row, 3).toString());
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void clearFields() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                QuanLyKhachHang frame = new QuanLyKhachHang();
                frame.setVisible(true);
            }
        });
    }
}
