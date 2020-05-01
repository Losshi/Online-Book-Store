package home;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Userlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userlogin frame = new Userlogin();
					frame.setVisible(true);
					//frame.setUser(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Userlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(113, 11, 396, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER LOGIN");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(51, 0, 153));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setBounds(0, 60, 624, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(315, 117, 261, 193);
		Image img=new ImageIcon(this.getClass().getResource("/userlogin.jpg")).getImage();
		lblimg.setIcon(new ImageIcon(img));
		contentPane.add(lblimg);
		
		JLabel lblNewLabel_2 = new JLabel("Username   :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(26, 129, 172, 26);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(26, 166, 219, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password    :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(26, 209, 172, 26);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(26, 246, 219, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Onlinebookstore?useTimezone=true&serverTimezone=UTC", "root", "");
					String user=textField.getText();
					String pwd=passwordField.getText().toString();
					String sql1="select username,password from userdb where username=? and password=?";
					PreparedStatement ps1=conn.prepareStatement(sql1);
					ps1.setString(1, user);
					ps1.setString(2, pwd);
					ResultSet rs1=ps1.executeQuery();
					int c=0;
					while(rs1.next()) 
						c++;
					if(c==1) {
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL!!!");
						dispose();
						Userpage up=new Userpage();
						up.setUser(user);
						up.setVisible(true);
						
					}
					else {
						String sql2="select username,password from userdb where username=? or password=?";
						PreparedStatement ps2=conn.prepareStatement(sql2);
						ps2.setString(1, user);
						ps2.setString(2, pwd);
						ResultSet rs2=ps2.executeQuery();
                        if(rs2.next())
                        	JOptionPane.showMessageDialog(null, "INCORRECT Username or Password :(");
                        else {
						JOptionPane.showMessageDialog(null, "You're not a registered user! \nPlease register !!!");
						dispose();
						Register re=new Register();
						re.setVisible(true);
                        }
					}
					

				}
				catch(Exception en) {
					System.out.println(en);
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(255, 153, 255));
		btnNewButton.setBounds(78, 297, 108, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
			        Home u=new Home();
					u.setVisible(true);
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(525, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
