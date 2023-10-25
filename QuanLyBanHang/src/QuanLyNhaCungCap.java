import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLyNhaCungCap extends JFrame {
    private DefaultListModel<String> supplierListModel;
    private JList<String> supplierList;
    private JTextField supplierNameField;
    private JButton addSupplierButton;
    private JButton removeSupplierButton;

    public QuanLyNhaCungCap() {
        // Set up the main frame
        setTitle("Quản lý nhà cung cấp");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        supplierListModel = new DefaultListModel<>();
        supplierList = new JList<>(supplierListModel);

        supplierNameField = new JTextField(20);
        addSupplierButton = new JButton("Thêm nhà cung cấp");
        removeSupplierButton = new JButton("Xóa nhà cung cấp");

        addSupplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String supplierName = supplierNameField.getText();
                if (!supplierName.isEmpty()) {
                    supplierListModel.addElement(supplierName);
                    supplierNameField.setText("");
                }
            }
        });

        removeSupplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = supplierList.getSelectedIndex();
                if (selectedIndex != -1) {
                    supplierListModel.remove(selectedIndex);
                }
            }
        });

        // Create a panel for input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tên nhà cung cấp:"));
        inputPanel.add(supplierNameField);
        inputPanel.add(addSupplierButton);
        inputPanel.add(removeSupplierButton);

        // Set up the layout
        setLayout(new BorderLayout());
        add(new JScrollPane(supplierList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	QuanLyNhaCungCap frame = new QuanLyNhaCungCap();
                frame.setVisible(true);
            }
        });
    }
}
