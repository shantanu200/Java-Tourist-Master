import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login_Page extends JFrame {

	private JPanel contentPane;
	private JTextField Email;
	private JTextField Username;
	private JPasswordField l_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page frame = new Login_Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	/**
	 * Create the frame.
	 */
	public Login_Page() {
		setFont(new Font("Code New Roman", Font.PLAIN, 14));
		final boolean flag = false;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 741);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(573, 10, 358, 684);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Login_Page.class.getResource("/images/bg2.jpg")));
		lblNewLabel_4.setBounds(0, 431, 358, 253);
		panel.add(lblNewLabel_4);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 204, 51));
		panel_1.setBounds(0, 0, 358, 451);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("TOURIST");
		lblNewLabel_5.setIcon(new ImageIcon(Login_Page.class.getResource("/images/tourist_girl.png")));
		lblNewLabel_5.setFont(new Font("Komika Axis", Font.PLAIN, 52));
		lblNewLabel_5.setBounds(10, 108, 313, 116);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" MASTER");
		lblNewLabel_6.setFont(new Font("Komika Axis", Font.PLAIN, 52));
		lblNewLabel_6.setBounds(100, 220, 258, 112);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("EMAIL:");
		lblNewLabel.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel.setBounds(67, 269, 184, 24);
		contentPane.add(lblNewLabel);
		
		Email = new JTextField();
		Email.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		Email.setBounds(67, 304, 366, 24);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(67, 357, 155, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME:");
		lblNewLabel_2.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(69, 187, 167, 24);
		contentPane.add(lblNewLabel_2);
		
		Username = new JTextField();
		Username.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		Username.setBounds(67, 229, 366, 24);
		contentPane.add(Username);
		Username.setColumns(10);
		
		l_Password = new JPasswordField();
		l_Password.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		l_Password.setBounds(67, 391, 366, 24);
		contentPane.add(l_Password);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean find = false;
				String username = Username.getText();
				String email = Email.getText();
				String password = l_Password.getText();
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
					Statement stmt = conn.createStatement();
					String que = "SELECT * FROM register";
					ResultSet rs = stmt.executeQuery(que);
					while(rs.next()) {
						String f_username = rs.getString("username");
						String f_email = rs.getString("email");
						String f_password = rs.getString("password");
						
						if(f_username.equals(username) && f_email.equals(email) && f_password.equals(password)) {
							find = true;
							break;
						}else if(!f_username.equals(username) && f_email.equals(email) && f_password.equals(password)) {
							JOptionPane.showMessageDialog(btnNewButton, "Invalid Username");
							break;
						}else if(f_username.equals(username) && !f_email.equals(email) && f_password.equals(password)) {
							JOptionPane.showMessageDialog(btnNewButton, "Invalid Email");
							break;
						}else if(f_username.equals(username) && f_email.equals(email) && !f_password.equals(password)) {
							JOptionPane.showMessageDialog(btnNewButton, "Password NOT MATCHED");
							break;
						}
						
						
					}
					
					if(find) {
						close();
				        Suggestion s = new Suggestion();
				        s.setVisible(true);
					}
				}catch(Exception E) {
					E.printStackTrace();				
					}
			}
		});
		btnNewButton.setBackground(new Color(153, 255, 102));
		btnNewButton.setFont(new Font("Code New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(175, 462, 146, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel(" SIGN IN");
		lblNewLabel_3.setFont(new Font("Komika Axis", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(161, 66, 191, 55);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("NEW USER?? SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Register R = new Register();
				R.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Code New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(51, 153, 255));
		btnNewButton_1.setBounds(144, 549, 208, 21);
		contentPane.add(btnNewButton_1);
		
		
	}
}
