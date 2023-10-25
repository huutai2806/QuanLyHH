import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Quản lý bán hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 804);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 914, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng nhập");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login(); // Hiển thị cửa sổ Đăng nhập
			}
		});
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đăng xuất");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Logout(); // Thực hiện Đăng xuất
			}
		});
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Thoát");
		mnNewMenu.add(mntmNewMenuItem_21);
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Exit(); // Thực hiện Thoát
			}
		});

		JMenuBar menuBar_1 = new JMenuBar();
		mnNewMenu.add(menuBar_1);

		JMenu mnNewMenu_1 = new JMenu("Quản lý");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sản phẩm");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product frmProduct = null;
				try {
					frmProduct = new Product();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmProduct.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nhà cung cấp");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở giao diện quản lý nhà cung cấp
                QuanLyNhaCungCap nhaCungCapFrame = new QuanLyNhaCungCap();
                nhaCungCapFrame.setVisible(true);
            }
        });
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Khách hàng");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuanLyKhachHang quanLyKhachHangFrame = new QuanLyKhachHang();
                quanLyKhachHangFrame.setVisible(true);
            }
        });;
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Hóa đơn bán hàng");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuanLyHangHoa quanLyHangHoa = new QuanLyHangHoa();
                quanLyHangHoa.setVisible(true);
            }
        });
		contentPane.setVisible(true);
	}
}
