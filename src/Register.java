import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Username;
	private JTextField Location;
	private JTextField Email;
	private JPasswordField l_Password;
	private JTextField l_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 741);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(339, 10, 582, 684);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Name = new JTextField();
		Name.setFont(new Font("Code New Roman", Font.PLAIN, 18));
		Name.setBounds(94, 185, 397, 28);
		panel.add(Name);
		Name.setColumns(10);
		
		Username = new JTextField();
		Username.setFont(new Font("Code New Roman", Font.PLAIN, 18));
		Username.setBounds(94, 267, 397, 28);
		panel.add(Username);
		Username.setColumns(10);
		
		Location = new JTextField();
		Location.setFont(new Font("Code New Roman", Font.PLAIN, 18));
		Location.setBounds(94, 353, 397, 28);
		panel.add(Location);
		Location.setColumns(10);
		
		Email = new JTextField();
		Email.setFont(new Font("Code New Roman", Font.PLAIN, 18));
		Email.setBounds(94, 427, 397, 32);
		panel.add(Email);
		Email.setColumns(10);
		
		l_password = new JTextField();
		l_password.setFont(new Font("Code New Roman", Font.PLAIN, 18));
		l_password.setBounds(94, 500, 397, 32);
		panel.add(l_password);
		l_password.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				String username = Username.getText();
				String location = Location.getText();
				String email = Email.getText();
				String password = l_password.getText();
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
					Statement stmt = conn.createStatement();
					String que = "INSERT INTO register"+"(name,username,location,email,password)"+"VALUES("+"'"+name+"',"+"'"+username+"',"+"'"+location+"',"+"'"+email+"',"+"'"+password+"'"+")";
					int i = stmt.executeUpdate(que);
					
					
					if(i==1) {
						JOptionPane.showMessageDialog(btnNewButton, "User Created Successfully.");
						close();
						Login_Page lp = new Login_Page();
						lp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Error: Unsuccessful Registration.");
					}
					
				}catch(Exception E){
					E.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(102, 255, 0));
		btnNewButton.setFont(new Font("Code New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(168, 558, 189, 51);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel(" SIGN UP\r\n");
		lblNewLabel_5.setBackground(new Color(240, 240, 240));
		lblNewLabel_5.setFont(new Font("Komika Axis", Font.PLAIN, 40));
		lblNewLabel_5.setBounds(168, 22, 196, 74);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		lblNewLabel.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel.setBounds(94, 152, 61, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:");
		lblNewLabel_1.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(94, 232, 127, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOCATION:");
		lblNewLabel_2.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(94, 320, 116, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL:");
		lblNewLabel_3.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(94, 391, 100, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD:");
		lblNewLabel_4.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(94, 469, 127, 21);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Existing User?? Sign In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Login_Page lp = new Login_Page();
				lp.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(102, 204, 255));
		btnNewButton_1.setBounds(168, 637, 189, 21);
		panel.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Register.class.getResource("/images/bg1.jpg")));
		lblNewLabel_8.setBounds(0, 463, 343, 215);
		contentPane.add(lblNewLabel_8);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(102, 255, 204));
		panel_1.setBounds(0, 10, 343, 478);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("TOURIST");
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setIcon(new ImageIcon(Register.class.getResource("/images/bg.png")));
		lblNewLabel_6.setFont(new Font("Komika Axis", Font.PLAIN, 52));
		lblNewLabel_6.setBounds(0, 120, 312, 108);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("MASTER");
		lblNewLabel_9.setFont(new Font("Komika Axis", Font.PLAIN, 52));
		lblNewLabel_9.setBounds(105, 224, 228, 114);
		panel_1.add(lblNewLabel_9);
	}
}
