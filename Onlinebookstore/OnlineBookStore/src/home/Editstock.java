package home;

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
import java.awt.SystemColor;
import java.sql.*;
import javax.swing.*;

public class Editstock extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	
	public static class MyConnection {
	    public static  Connection getConnection(){
	     
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookstore?useTimezone=true&serverTimezone=UTC","root","");
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
					Editstock frame = new Editstock();
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
	public Editstock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 283);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER DETAILS TO EDIT QUANTITY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 442, 55);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("BOOKID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(51, 86, 120, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("QUANTITY");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(51, 129, 120, 14);
		contentPane.add(lblNewLabel_3);

		t1 = new JTextField();
		t1.setBounds(181, 86, 203, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setBounds(181, 128, 203, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

		String bid = t1.getText();
		  String qty = t2.getText();
		       
		       
		       if(bid.equals(""))
		       {
		           JOptionPane.showMessageDialog(null, "Add A bookid");
		       }
		       else if(qty.equals(""))
		       { JOptionPane.showMessageDialog(null, "Add quantity");
		       }
		       
		     
		       else {
		       
		       PreparedStatement ps;
		     
		       String query = "update books set quantity = ? where bookid = ?";
		       
		       try {
		           ps = MyConnection.getConnection().prepareStatement(query);
		         
		           ps.setString(1, qty);
		           ps.setString(2, bid);
		           
		           if(ps.executeUpdate() > 0)
		           {
		               JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED");
		               
		              dispose();
		              Adminpage ap=new Adminpage();
		              ap.setVisible(true);
		             
		           }
		           
		       } catch(Exception p){ System.out.println(p);
		       }
		       }
		}
		});

		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnNewButton.setBounds(44, 177, 139, 34);
		contentPane.add(btnNewButton);
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		dispose();
		        Adminpage adm=new Adminpage();
		        adm.setVisible(true);
		}
		});
		btnCancel.setForeground(new Color(0, 51, 153));
		btnCancel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnCancel.setBackground(new Color(255, 255, 204));
		btnCancel.setBounds(217, 177, 148, 34);
		contentPane.add(btnCancel);


	}

}
