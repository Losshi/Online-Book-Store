package home;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JTextField tfmob;
	private JTextField tfemid;
	private JPasswordField tfpwd;

	/**
	 * Launch the application.
	 */
	public static class MyConnection {
	    public static  Connection getConnection(){
	     
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Onlinebookstore?useTimezone=true&serverTimezone=UTC","root","");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	       
	        return con;
	    }
	   
	}    
	
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

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 478);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 11, 325, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome!!! Register your details and enjoy reading :)");
		lblNewLabel_1.setForeground(new Color(102, 0, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(94, 77, 466, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username             :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(51, 145, 120, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile number     :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(51, 194, 120, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email ID               :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(51, 246, 120, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password             :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(51, 299, 120, 14);
		contentPane.add(lblNewLabel_5);
		
		tfuser = new JTextField();
		tfuser.setBounds(181, 143, 203, 20);
		contentPane.add(tfuser);
		tfuser.setColumns(10);
		
		tfmob = new JTextField();
		tfmob.setBounds(181, 192, 203, 20);
		contentPane.add(tfmob);
		tfmob.setColumns(10);
		
		tfemid = new JTextField();
		tfemid.setBounds(181, 244, 203, 20);
		contentPane.add(tfemid);
		tfemid.setColumns(10);
		
		tfpwd = new JPasswordField();
		tfpwd.setBounds(181, 297, 203, 20);
		contentPane.add(tfpwd);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = tfuser.getText();
				  String phno = tfmob.getText();
				       String password = String.valueOf(tfpwd.getPassword());
				        String mail = tfemid.getText();
				       
				       if(uname.equals(""))
				       {
				           JOptionPane.showMessageDialog(null, "Add A Username");
				       }
				       else if(mail.equals(""))
				       { JOptionPane.showMessageDialog(null, "Add A Email id");
				       }
				       else if(mail.indexOf('@')==-1 || mail.contains(".com")==false)
				       { JOptionPane.showMessageDialog(null, "Incorrect Emailid");
				       }
				       
				       else if(phno.equals(""))
				       { JOptionPane.showMessageDialog(null, "Add A Phone number");
				       }
				       else if(((phno.length()) < 9) || ((phno.length()) > 11) ) {
				        JOptionPane.showMessageDialog(null, "Incorrect Phone no.");
				       }
				       else if(password.equals(""))
				       {
				           JOptionPane.showMessageDialog(null, "Add A Password");
				       }
				     
				       else {
				       
				       PreparedStatement ps;
				     
				       String query = "INSERT INTO `userdb` VALUES (?,?,?,?)";
				       
				       try {
				           ps = MyConnection.getConnection().prepareStatement(query);
				           ps.setString(1, uname);
				           ps.setString(2, phno);
				           ps.setString(3, mail);
				           ps.setString(4, password);
				           
				           if(ps.executeUpdate() > 0)
				           {
				               JOptionPane.showMessageDialog(null, "SUCCESSFULLY REGISTERED");
				               dispose();
				               Home hm=new Home();
				               hm.setVisible(true);
				           }
				           
				       } catch(Exception p){ System.out.println(p);
				       }
				       }
				}
				});
		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnNewButton.setBounds(94, 353, 216, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(409, 132, 228, 266);
		Image img=new ImageIcon(this.getClass().getResource("/regbook.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel_6);
		
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
		btnNewButton_1.setBounds(548, 21, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
