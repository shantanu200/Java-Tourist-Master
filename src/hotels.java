

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class hotels extends JFrame {

	private JPanel contentPane;

	public   String h1 = null;
	public   String h2 = null;
	public   String h3 = null;
	public int p1;
	public int p2;
	public int p3;
	public int s_days;
	public String name;
	public String des;
	public String contact;
	public String adate;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotels frame = new hotels();
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
	public void gethotels(String a,String b,String c,int x,int y,int z,int days,String gname,String city,String con,String date){
		h1 = a;
		h2 = b;
		h3 = c;
		p1 = x;
		p2 = y;
		p3 = z;
        s_days = days;
        name = gname;
        des = city;
        contact = con;
        adate = date;
        
	}
	
	public hotels() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox c_hotel1 = new JCheckBox("New check box");
		c_hotel1.setFont(new Font("Code New Roman", Font.PLAIN, 20));
		c_hotel1.setBackground(new Color(204, 204, 102));
		c_hotel1.setBounds(191, 76, 509, 21);
		
		
		
		JCheckBox c_hotel2 = new JCheckBox("New check box");
		c_hotel2.setFont(new Font("Code New Roman", Font.PLAIN, 20));
		c_hotel2.setBackground(new Color(204, 204, 102));
		c_hotel2.setBounds(191, 128, 509, 21);
		
		
		
		JCheckBox c_hotel3 = new JCheckBox("New check box");
		c_hotel3.setFont(new Font("Code New Roman", Font.PLAIN, 20));
		c_hotel3.setBackground(new Color(204, 204, 102));
		c_hotel3.setBounds(191, 180, 509, 21);
		
		
		
		JButton btnNewButton = new JButton("Show Hotel");
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					c_hotel1.setText(h1+" "+"("+p1+"Rs per night)");
					contentPane.add(c_hotel1);
					
					c_hotel2.setText(h2+" "+"("+p2+"Rs per night)");
					contentPane.add(c_hotel2);
					
					c_hotel3.setText(h3+" "+"("+p3+"Rs per night)");
					contentPane.add(c_hotel3);
					
				
					//JOptionPane.showMessageDialog(btnNewButton, "You have to pay: "+price);
					
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(268, 20, 165, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Book Hotel");
		btnNewButton_1.setBackground(new Color(153, 255, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int price = 0;
					String hotel = null;
					if(c_hotel1.isSelected()) {
						price += (p1*s_days);
						hotel = h1;
					}
					
					if(c_hotel2.isSelected()) {
						price += (p2*s_days);
						hotel = h2;
					}
					
					if(c_hotel3.isSelected()) {
						price += (p3*s_days);
						hotel = h3;
					}
					
					String msg = "Name: "+name+"\n";
					       msg += "Destination: "+des+"\n";
					       msg += "Contact No: "+contact+"\n";
					       msg += "Hotel: "+hotel+"\n";
					       msg += "Arriving Date: "+adate+"\n";
					       msg += "Staying Days: "+s_days+"\n";
					       msg += "Total Price: "+price+"\n";
					
					JOptionPane.showMessageDialog(btnNewButton,msg);
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
					Statement stmt = conn.createStatement();
					String que = "INSERT INTO booking"+"(name,destination,hotel,price,contact,a_date,days)"+"VALUES("+"'"+name+"',"+"'"+des+"',"+"'"+hotel+"',"+"'"+price+"',"+"'"+contact+"',"+"'"+adate+"',"+"'"+s_days+"'"+")";
					int i = stmt.executeUpdate(que);
					
					if(i==1) {
						JOptionPane.showMessageDialog(btnNewButton,"Thank You For Booking");
					}
					
				}catch(Exception E1) {
					E1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(526, 261, 137, 21);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
		
		
	}
}
