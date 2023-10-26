import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class Product extends JFrame {

	private JPanel contentPane;
	private JLabel txtMaSP;
	private JLabel txtTenSP;
	private JLabel txtDonGia;
	private JLabel txtXuatxu;
	private JLabel txtLoaiSP;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tableSP;
	DefaultTableModel dfTableModel = new DefaultTableModel(
			null, 
			new String[] {
					"Mã HH","Tên HH","Giá","Xuất xứ","Loại hàng",
			}
			); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Product() throws SQLException {
		setTitle("Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtQLTT = new JLabel("Quản lý thông tin sản phẩm ");
		txtQLTT.setBounds(178, 28, 268, 33);
		contentPane.add(txtQLTT);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 72, 604, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtMaSP = new JLabel("Mã SP");
		txtMaSP.setBounds(22, 14, 46, 14);
		panel.add(txtMaSP);
		
		txtTenSP = new JLabel("Tên SP");
		txtTenSP.setBounds(315, 14, 46, 14);
		panel.add(txtTenSP);
		
		txtDonGia = new JLabel("Đơn giá");
		txtDonGia.setBounds(22, 59, 46, 14);
		panel.add(txtDonGia);
		
		txtXuatxu = new JLabel("Xuất xứ");
		txtXuatxu.setBounds(315, 59, 46, 14);
		panel.add(txtXuatxu);
		
		txtLoaiSP = new JLabel("Loại SP");
		txtLoaiSP.setBounds(315, 98, 46, 14);
		panel.add(txtLoaiSP);
		
		textField = new JTextField();
		textField.setBounds(91, 11, 149, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 56, 149, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(378, 11, 149, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(378, 56, 149, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(378, 95, 149, 20);
		panel.add(textField_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 275, 604, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 584, 133);
		panel_1.add(scrollPane);
		List<Hanghoa> lst = new  ArrayList<Hanghoa>();
		CSDL csdl = new CSDL();
		try {
			lst = csdl.getHanghoa();
			for(Hanghoa hh:lst) {
				Vector value = new Vector();
				value.add(hh.getMahh());
				value.add(hh.getTenhh());
				value.add(hh.getDongia());
				value.add(hh.getXuatxu());
				value.add(hh.getLoaisp());
				dfTableModel.addRow(value);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		tableSP = new JTable();
		tableSP.setModel(dfTableModel);
		tableSP.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting() && tableSP.getSelectedRow() != -1) {
		            int selectedRow = tableSP.getSelectedRow();
		            textField.setText((String) dfTableModel.getValueAt(selectedRow, 0));
		            textField_2.setText((String) dfTableModel.getValueAt(selectedRow, 1));
		            textField_1.setText(dfTableModel.getValueAt(selectedRow, 2).toString());
		            textField_3.setText((String) dfTableModel.getValueAt(selectedRow, 3));
		            textField_4.setText((String) dfTableModel.getValueAt(selectedRow, 4));
		        }
		    }
		});
		scrollPane.setViewportView(tableSP);
		JButton btnGhi = new JButton("Ghi");
	    btnGhi.setBounds(71, 220, 89, 23);
	    contentPane.add(btnGhi);
	    btnGhi.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String maSP = textField.getText();
	            String tenSP = textField_2.getText();
	            String donGia = textField_1.getText();
	            String xuatXu = textField_3.getText();
	            String loaiSP = textField_4.getText();
	            saveToDatabase(maSP, tenSP, donGia, xuatXu, loaiSP);
				
				Vector value = new Vector();
				value.add(maSP);
				value.add(tenSP);
				value.add(donGia);
				value.add(xuatXu);
				value.add(loaiSP);
				dfTableModel.addRow(value);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
	        }

			private void saveToDatabase(String maSP, String tenSP, String donGia, String xuatXu, String loaiSP) {
				// TODO Auto-generated method stub
				
			}
	    });
	    JButton btnKhong = new JButton("Không");
	    btnKhong.setBounds(196, 220, 89, 23);
	    contentPane.add(btnKhong);
	    btnKhong.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            textField.setText("");
	            textField_1.setText("");
	            textField_2.setText("");
	            textField_3.setText("");
	            textField_4.setText("");
	        }
	    });
	    JButton btnSua = new JButton("Sửa");
	    btnSua.setBounds(317, 220, 89, 23);
	    contentPane.add(btnSua);
	    btnSua.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int selectedRow = tableSP.getSelectedRow();
	            if (selectedRow >= 0) {
	                String maSP = textField.getText();
	                String tenSP = textField_2.getText();
	                String donGia = textField_1.getText();
	                String xuatXu = textField_3.getText();
	                String loaiSP = textField_4.getText();

	                dfTableModel.setValueAt(maSP, selectedRow, 0);
	                dfTableModel.setValueAt(tenSP, selectedRow, 1);
	                dfTableModel.setValueAt(donGia, selectedRow, 2);
	                dfTableModel.setValueAt(xuatXu, selectedRow, 3);
	                dfTableModel.setValueAt(loaiSP, selectedRow, 4);

	                textField.setText("");
	                textField_2.setText("");
	                textField_1.setText("");
	                textField_3.setText("");
	                textField_4.setText("");
	            }
	        }
	    });
	    JButton btnXoa = new JButton("Xóa");
	    btnXoa.setBounds(438, 220, 89, 23);
	    contentPane.add(btnXoa);
	    btnXoa.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int selectedRow = tableSP.getSelectedRow();
	            if (selectedRow >= 0) {
	            	 String maSP = (String) dfTableModel.getValueAt(selectedRow, 0);
	                dfTableModel.removeRow(selectedRow);
	            }
	        }
	    });
	}
	}

	    

