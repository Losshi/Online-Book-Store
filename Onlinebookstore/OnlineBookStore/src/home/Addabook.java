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
import java.io.*;


public class Addabook extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;

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
					Addabook frame = new Addabook();
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
	public Addabook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setFont(new Font("Centaur", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(197, 11, 325, 55);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please enter the details of the book..");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(51, 55, 466, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Bookid");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(51, 121, 120, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" Title");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(51, 156, 120, 21);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Author");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(51, 192, 120, 21);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Genre");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(51, 234, 120, 20);
		contentPane.add(lblNewLabel_5);

		t1 = new JTextField();
		t1.setBounds(181, 121, 203, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setBounds(181, 157, 203, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		t3 = new JTextField();
		t3.setBounds(181, 193, 203, 20);
		contentPane.add(t3);
		t3.setColumns(10);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

		String bid = t1.getText();
		String tit = t2.getText();
		    String aut = t3.getText();
		    String gen = t4.getText();
		    String qty = t5.getText();
		    String pri = t6.getText();
		    String rat = t7.getText();  
		    String i1=t8.getText();
		    i1 = i1.replace("\\","\\\\");
		   
		   
		       if(bid.equals(""))
		       {
		           JOptionPane.showMessageDialog(null, "Add A Bookid");
		       }
		       else if(tit.equals(""))
		       { JOptionPane.showMessageDialog(null, "Add A title");
		       }
		       else if(aut.equals(""))
		       { JOptionPane.showMessageDialog(null, "Add A Author");
		       }
		       else if(gen.equals(""))
		       {
		           JOptionPane.showMessageDialog(null, "Add A Genre");
		       }
		       else if(qty.equals(""))
		       { JOptionPane.showMessageDialog(null, "Add Quantity");
		       }
		       else if(pri.equals(""))
		       { JOptionPane.showMessageDialog(null, "Add Price");
		       }
		       else if(rat.equals(""))
		       {
		           JOptionPane.showMessageDialog(null, "Add Rating out of 5");
		       }
		       else if(i1.equals(""))
		       {
		           JOptionPane.showMessageDialog(null, "Add image of the book");
		       }
		       else {
		       
		       PreparedStatement ps;
		     
		   String query = "insert into books(bookid,title,author,genre,quantity,price,rating,image) values('"+bid+"','"+tit+"','"+aut+"','"+gen+"','"+qty+"','"+pri+"','"+rat+"','"+i1+"')";
		       
		       try {
		           ps = MyConnection.getConnection().prepareStatement(query);
		           
		           if(ps.executeUpdate() > 0)
		           {
		               JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED");
		               dispose();
		               Adminpage adp=new Adminpage();
		               adp.setVisible(true);
		           }
		           
		       } catch(Exception p){ System.out.println(p);
		       }
		       }
		}
		});

		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnNewButton.setBounds(116, 416, 216, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblQuantity.setBounds(51, 276, 120, 20);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPrice.setBounds(51, 324, 120, 20);
		contentPane.add(lblPrice);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblRating.setBounds(51, 368, 120, 20);
		contentPane.add(lblRating);
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(181, 238, 203, 20);
		contentPane.add(t4);
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(181, 280, 203, 20);
		contentPane.add(t5);
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(181, 328, 203, 20);
		contentPane.add(t6);
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(181, 372, 203, 20);
		contentPane.add(t7);
		JLabel lblAddImage = new JLabel("Attach an image of the book");
		lblAddImage.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblAddImage.setBounds(425, 77, 280, 34);
		contentPane.add(lblAddImage);
		t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(420, 156, 285, 26);
		contentPane.add(t8);
		JLabel lblimage = new JLabel("");

		lblimage.setIcon(null);
		lblimage.setBounds(425, 201, 159, 229);
		contentPane.add(lblimage);

		JButton btnAddImage = new JButton("Attach ");
		btnAddImage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JFileChooser chooser=new JFileChooser();
		   chooser.showOpenDialog(null);
		   File f=chooser.getSelectedFile();
		   String filename=f.getAbsolutePath();
		   t8.setText(filename);
		   Image getAbsolutePath = null;
		   
		   ImageIcon icon = new ImageIcon(filename);
		   Image image=icon.getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
		lblimage.setIcon(icon);

		}
		});
		btnAddImage.setForeground(new Color(0, 51, 153));
		btnAddImage.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		btnAddImage.setBackground(new Color(255, 255, 204));
		btnAddImage.setBounds(607, 192, 98, 34);
		contentPane.add(btnAddImage);
		JLabel lblNewLabel_6 = new JLabel("Image loc :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(425, 120, 120, 19);
		contentPane.add(lblNewLabel_6);

	}

}
