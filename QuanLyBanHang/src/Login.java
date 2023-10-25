import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class Login
public class Login {
	private JFrame loginFrame;

	public Login() {
		loginFrame = new JFrame("Đăng nhập");
		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginFrame.setSize(300, 150);

		JPanel loginPanel = new JPanel();
		loginFrame.add(loginPanel);

		JLabel usernameLabel = new JLabel("Tên đăng nhập:");
		JTextField usernameField = new JTextField(20);
		JLabel passwordLabel = new JLabel("Mật khẩu:");
		JPasswordField passwordField = new JPasswordField(20);
		JButton loginButton = new JButton("Đăng nhập");

		loginPanel.add(usernameLabel);
		loginPanel.add(usernameField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		loginPanel.add(loginButton);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());

				// Thực hiện xác thực thông tin đăng nhập ở đây

				if (authenticate(username, password)) {
					JOptionPane.showMessageDialog(loginFrame, "Đăng nhập thành công!");
					loginFrame.dispose();
					// Hiển thị giao diện hoặc chức năng sau khi đăng nhập thành công
				} else {
					JOptionPane.showMessageDialog(loginFrame,
							"Đăng nhập thất bại. Vui lòng kiểm tra lại tên đăng nhập và mật khẩu.");
				}
			}
		});

		loginFrame.setVisible(true);
	}

	private static boolean authenticate(String username, String password) {
		// Thực hiện xác thực đăng nhập ở đây
		// Trong ví dụ này, đơn giản chỉ kiểm tra giá trị cứng "admin" cho cả tên đăng
		// nhập và mật khẩu
		return username.equals("admin") && password.equals("admin");
	}
}
