package home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class Adminlogin extends JFrame {

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
					Adminlogin frame = new Adminlogin();
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
	public Adminlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 411);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setForeground(new Color(51, 0, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(155, 11, 337, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN LOGIN PAGE");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(209, 62, 226, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(31, 109, 225, 225);
		Image img=new ImageIcon(this.getClass().getResource("/adminlogin.jpg")).getImage();
		lblimage.setIcon(new ImageIcon(img));
		contentPane.add(lblimage);
		
		JLabel lblmsg = new JLabel("");
		lblmsg.setForeground(new Color(153, 0, 102));
		lblmsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblmsg.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblmsg.setBounds(327, 109, 278, 26);
		contentPane.add(lblmsg);
		
		JLabel lblNewLabel_2 = new JLabel("Admin name   :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(327, 146, 128, 20);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(327, 177, 251, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password       :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(327, 214, 128, 26);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(327, 251, 251, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Onlinebookstore?useTimezone=true&serverTimezone=UTC", "root", "");
					String sql="select * from admindb where aname=? and apwd=?";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText().toString());
					ResultSet rs=pst.executeQuery();
					int c=0;
					while(rs.next()) 
						c++;
					if(c==0)
						lblmsg.setText("Incorrect! Try again!");
					else {
						lblmsg.setText("WELCOME ADMIN :)");
						dispose();
						Adminpage ap=new Adminpage();
						ap.setVisible(true);
					}
					pst.close();
					rs.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setBackground(new Color(51, 255, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(204, 0, 102));
		btnNewButton.setBounds(403, 304, 111, 45);
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
		btnNewButton_1.setBounds(537, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
