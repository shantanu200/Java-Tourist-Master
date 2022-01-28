import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.Component;
import java.awt.Button;

public class Suggestion extends JFrame {

	private JPanel contentPane;
	private JTextField city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suggestion frame = new Suggestion();
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
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	public Suggestion() {
		setFont(new Font("Dialog", Font.PLAIN, 22));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 741);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(0, 10, 931, 131);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOURIST MANAGER");
		lblNewLabel.setFont(new Font("Komika Axis", Font.PLAIN, 19));
		lblNewLabel.setBounds(275, 20, 214, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search City Name Here");
		lblNewLabel_1.setFont(new Font("Code New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(285, 53, 192, 13);
		panel.add(lblNewLabel_1);
		
		city = new JTextField();
		city.setFont(new Font("Code New Roman", Font.PLAIN, 24));
		city.setBounds(275, 76, 214, 27);
		panel.add(city);
		city.setColumns(10);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(204, 51, 51));
		panel_1.setBounds(0, 135, 931, 569);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel place = new JLabel("");
		place.setBackground(Color.WHITE);
		place.setFont(new Font("Code New Roman", Font.BOLD, 30));
		place.setAlignmentX(Component.CENTER_ALIGNMENT);
		place.setBounds(82, 42, 230, 54);
		place.setForeground(Color.white);
		panel_1.add(place);
		
		JLabel place1 = new JLabel("");
		place1.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		place1.setBounds(82, 128, 313, 24);
		place1.setForeground(Color.white);
		panel_1.add(place1);
		
		JLabel place2 = new JLabel("");
		place2.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		place2.setBounds(82, 184, 320, 24);
		place2.setForeground(Color.white);
		panel_1.add(place2);
		
		JLabel place3 = new JLabel("");
		place3.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		place3.setBounds(82, 237, 313, 24);
		place3.setForeground(Color.white);
		panel_1.add(place3);
		
		JLabel food = new JLabel("");
		food.setFont(new Font("Code New Roman", Font.BOLD, 30));
		food.setBounds(82, 298, 313, 54);
		food.setForeground(Color.white);
		panel_1.add(food);
		
		JLabel food1 = new JLabel("");
		food1.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		food1.setBounds(82, 375, 313, 24);
		food1.setForeground(Color.white);
		panel_1.add(food1);
		
		JLabel food2 = new JLabel("");
		food2.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		food2.setBounds(82, 416, 230, 24);
		food2.setForeground(Color.white);
		panel_1.add(food2);
		
		JLabel food3 = new JLabel("");
		food3.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		food3.setBounds(82, 456, 230, 24);
		food3.setForeground(Color.white);
		panel_1.add(food3);
		
		JLabel hotel = new JLabel("");
		hotel.setFont(new Font("Code New Roman", Font.BOLD, 30));
		hotel.setBounds(608, 42, 262, 54);
		hotel.setForeground(Color.white);
		panel_1.add(hotel);
		
		JLabel hotel1 = new JLabel("");
		hotel1.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		hotel1.setBounds(608, 128, 262, 24);
		hotel1.setForeground(Color.white);
		panel_1.add(hotel1);
		
		JLabel hotel2 = new JLabel("");
		hotel2.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		hotel2.setBounds(608, 184, 300, 24);
		hotel2.setForeground(Color.white);
		panel_1.add(hotel2);
		
		JLabel hotel3 = new JLabel("");
		hotel3.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		hotel3.setBounds(608, 237, 300, 24);
		hotel3.setForeground(Color.white);
		panel_1.add(hotel3);
		
		JLabel near = new JLabel("");
		near.setFont(new Font("Code New Roman", Font.BOLD, 30));
		near.setBounds(608, 298, 262, 54);
		near.setForeground(Color.white);
		panel_1.add(near);
		
		JLabel near1 = new JLabel("");
		near1.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		near1.setBounds(608, 375, 300, 24);
		near1.setForeground(Color.white);
		panel_1.add(near1);
		
		JLabel near2 = new JLabel("");
		near2.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		near2.setBounds(608, 416, 300, 24);
		near2.setForeground(Color.white);
		panel_1.add(near2);
		
		JLabel near3 = new JLabel("");
		near3.setFont(new Font("Code New Roman", Font.PLAIN, 22));
		near3.setBounds(608, 456, 300, 24);
		near3.setForeground(Color.white);
		panel_1.add(near3);
		
		JLabel status = new JLabel("");
		status.setFont(new Font("Code New Roman", Font.PLAIN, 24));
		status.setBounds(193, 149, 646, 78);
		status.setForeground(Color.white);
		panel_1.add(status);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				String city_get = city.getText();
				city_get = city_get.toLowerCase();
				String db_place1 = null;
				String db_place2 = null;
				String db_place3 = null;
				String db_food1 = null;
				String db_food2 = null;
				String db_food3 = null;
				String db_hotel1 = null;
				String db_hotel2 = null;
				String db_hotel3 = null;
				String db_near1 = null;
				String db_near2 = null;
				String db_near3 = null;
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
					Statement stmt = conn.createStatement();
					String que = "SELECT * FROM tourist";
					ResultSet rs = stmt.executeQuery(que);
					
					while(rs.next()) {
						String db_city = rs.getNString("city");
						if(city_get.equals(db_city)){
							db_place1 = rs.getString("place1");
							db_place2 = rs.getString("place2");
							db_place3 = rs.getString("place3");
							db_food1 = rs.getString("food1");
							db_food2 = rs.getString("food2");
							db_food3 = rs.getString("food3");
							db_hotel1 = rs.getString("hotel1");
							db_hotel2 = rs.getString("hotel2");
							db_hotel3 = rs.getString("hotel3");
							db_near1 = rs.getString("near1");
							db_near2 = rs.getString("near2");
							db_near3 = rs.getString("near3");
							flag = true;
							break;
						}
					}
					
					if(flag) {
						status.setText("");
						place.setText("PLACE: ");
						place1.setText("1."+ db_place1);
						place2.setText("2."+db_place2);
						place3.setText("3."+db_place3);
						food.setText("FOOD: ");
						food1.setText("1."+db_food1);
						food2.setText("2."+db_food2);
						food3.setText("3."+db_food3);
						hotel.setText("HOTEL: ");
						hotel1.setText("1."+db_hotel1);
						hotel2.setText("2."+db_hotel2);
						hotel3.setText("3."+db_hotel3);
						near.setText("NEAR BY CITIES:");
						near1.setText("1."+db_near1);
						near2.setText("2."+db_near2);
						near3.setText("3."+db_near3);
					}else {
						place.setText("");
						place1.setText("");
						place2.setText("");
						place3.setText("");
						food.setText("");
						food1.setText("");
						food2.setText("");
						food3.setText("");
						hotel.setText("");
						hotel1.setText("");
						hotel2.setText("");
						hotel3.setText("");
						near.setText("");
						near1.setText("");
						near2.setText("");
						near3.setText("");
						status.setText("SORRY!! No Such City Found in DataBase");
					}
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Code New Roman", Font.PLAIN, 10));
		btnNewButton.setBounds(404, 110, 85, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Suggestion.class.getResource("/images/beach.png")));
		lblNewLabel_2.setBounds(103, 10, 120, 111);
		panel.add(lblNewLabel_2);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(51, 51, 204));
		panel_2.setBounds(638, 0, 293, 131);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel book_label = new JLabel("BOOK YOUR TOUR");
		book_label.setFont(new Font("Komika Axis", Font.PLAIN, 19));
		book_label.setBounds(34, 26, 214, 33);
		book_label.setForeground(Color.white);
		panel_2.add(book_label);
		
		JButton Click = new JButton("Click Here");
		Click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				close();
				booking b = new booking();
				b.setVisible(true);
			}
		});
		Click.setBounds(143, 74, 120, 21);
		panel_2.add(Click);
		
		
		
		
	}
}
