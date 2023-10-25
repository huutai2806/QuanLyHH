import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLyHangHoa extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtMaSP;
    private JTextField txtTenSP;
    private JTextField txtDonGia;
    private JTextField txtXuatXu;
    private JTextField txtLoaiSP;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    public QuanLyHangHoa() {
        setTitle("Quản lý hàng hóa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã SP");
        tableModel.addColumn("Tên SP");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Xuất xứ");
        tableModel.addColumn("Loại SP");

        table = new JTable();

        txtMaSP = new JTextField(10);
        txtTenSP = new JTextField(20);
        txtDonGia = new JTextField(10);
        txtXuatXu = new JTextField(10);
        txtLoaiSP = new JTextField(15);
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Mã SP:"));
        inputPanel.add(txtMaSP);
        inputPanel.add(new JLabel("Tên SP:"));
        inputPanel.add(txtTenSP);
        inputPanel.add(new JLabel("Đơn giá:"));
        inputPanel.add(txtDonGia);
        inputPanel.add(new JLabel("Xuất xứ:"));
        inputPanel.add(txtXuatXu);
        inputPanel.add(new JLabel("Loại SP:"));
        inputPanel.add(txtLoaiSP);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnThem);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoa);

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maSP = txtMaSP.getText();
                String tenSP = txtTenSP.getText();
                String donGia = txtDonGia.getText();
                String xuatXu = txtXuatXu.getText();
                String loaiSP = txtLoaiSP.getText();
                String[] rowData = {maSP, tenSP, donGia, xuatXu, loaiSP};
                tableModel.addRow(rowData);
                clearFields();
            }
        });

        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.setValueAt(txtMaSP.getText(), selectedRow, 0);
                    tableModel.setValueAt(txtTenSP.getText(), selectedRow, 1);
                    tableModel.setValueAt(txtDonGia.getText(), selectedRow, 2);
                    tableModel.setValueAt(txtXuatXu.getText(), selectedRow, 3);
                    tableModel.setValueAt(txtLoaiSP.getText(), selectedRow, 4);
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
                txtMaSP.setText(tableModel.getValueAt(row, 0).toString());
                txtTenSP.setText(tableModel.getValueAt(row, 1).toString());
                txtDonGia.setText(tableModel.getValueAt(row, 2).toString());
                txtXuatXu.setText(tableModel.getValueAt(row, 3).toString());
                txtLoaiSP.setText(tableModel.getValueAt(row, 4).toString());
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void clearFields() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtDonGia.setText("");
        txtXuatXu.setText("");
        txtLoaiSP.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                QuanLyHangHoa frame = new QuanLyHangHoa();
                frame.setVisible(true);
            }
        });
    }
}
