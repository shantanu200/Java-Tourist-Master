import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField l_fname;
	private JTextField l_destination;
	private JTextField l_contact;
	private JTextField l_adate;
	private JTextField l_sdays;
	public String name = null;
	public String des = null;
	public String ncontact = null;
	public String adate = null;
	public String hotel1 = null;
	public String hotel2 = null;
	public String hotel3 = null;
	public int price1;
	public int price2;
	public int price3;
	public int s_days;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 102, 51));
		panel.setBounds(0, 0, 931, 704);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK HOTEL!!");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Komika Axis", Font.PLAIN, 30));
		lblNewLabel.setBounds(244, 26, 234, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" AND");
		lblNewLabel_1.setFont(new Font("Komika Axis", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(393, 74, 112, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENJOY VACCATION!!");
		lblNewLabel_2.setFont(new Font("Komika Axis", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(403, 106, 345, 45);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(booking.class.getResource("/images/booking.png")));
		lblNewLabel_3.setBounds(96, 33, 80, 93);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(booking.class.getResource("/images/booking2.png")));
		lblNewLabel_4.setBounds(758, 26, 95, 82);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FULL NAME:");
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_5.setBounds(244, 237, 144, 18);
		panel.add(lblNewLabel_5);
		
		l_fname = new JTextField();
		l_fname.setFont(new Font("Code New Roman", Font.PLAIN, 16));
		l_fname.setBounds(389, 227, 302, 28);
		panel.add(l_fname);
		l_fname.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DESTINATION:");
		lblNewLabel_6.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_6.setBounds(244, 294, 125, 18);
		panel.add(lblNewLabel_6);
		
		l_destination = new JTextField();
		l_destination.setFont(new Font("Code New Roman", Font.PLAIN, 16));
		l_destination.setBounds(393, 284, 298, 28);
		panel.add(l_destination);
		l_destination.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("CONTACT NO:");
		lblNewLabel_7.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(244, 352, 144, 18);
		panel.add(lblNewLabel_7);
		
		l_contact = new JTextField();
		l_contact.setFont(new Font("Code New Roman", Font.PLAIN, 16));
		l_contact.setBounds(393, 342, 298, 28);
		panel.add(l_contact);
		l_contact.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("ARRIVING DATE:");
		lblNewLabel_8.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_8.setBounds(244, 402, 154, 18);
		panel.add(lblNewLabel_8);
		
		l_adate = new JTextField();
		l_adate.setFont(new Font("Code New Roman", Font.PLAIN, 16));
		l_adate.setBounds(393, 392, 298, 28);
		panel.add(l_adate);
		l_adate.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("STAYING DAYS:");
		lblNewLabel_9.setFont(new Font("Code New Roman", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(244, 453, 144, 18);
		panel.add(lblNewLabel_9);
		
		l_sdays = new JFormattedTextField();
		l_sdays.setFont(new Font("Code New Roman", Font.PLAIN, 16));
		l_sdays.setBounds(393, 443, 298, 28);
		panel.add(l_sdays);
		l_sdays.setColumns(10);
		
		JButton btnNewButton = new JButton("BOOK \r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean flag = false;
				String fname = l_fname.getText();
				String city = l_destination.getText();
				String contact = l_contact.getText();
				String a_date = l_adate.getText();
				int days = Integer.parseInt(l_sdays.getText());

			
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
					Statement stmt = conn.createStatement();
					String que = "SELECT * FROM tourist";
					ResultSet rs = stmt.executeQuery(que);
					
					while(rs.next()) {
						city = city.toLowerCase();
						String db_city = rs.getString("city");
						if(city.equals(db_city)) {
							name = fname;
							des = city;
							ncontact = contact;
							adate = a_date;
							hotel1 = rs.getString("hotel1");
							hotel2 = rs.getString("hotel2");
							hotel3 = rs.getString("hotel3");
							price1 = rs.getInt("price1");
							price2 = rs.getInt("price2");
							price3 = rs.getInt("price3");
							s_days = days;
							flag = true;
							break;
						}
					}
					
					if(flag) {
						hotels hotel = new hotels();
						hotel.gethotels(hotel1,hotel2,hotel3,price1,price2,price3,s_days,name,des,ncontact,adate);
						hotel.setVisible(true);
					}
					
				}catch(Exception E){
					E.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(51, 255, 51));
		btnNewButton.setBounds(375, 527, 167, 21);
		panel.add(btnNewButton);
	}
}
