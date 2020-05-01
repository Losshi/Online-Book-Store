package home;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.Register.MyConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Userpage extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	public static String u;
	

	/**
	 * Launch the application.
	 */
	void setUser(String s0) {
		u=s0;
	}
	
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
					Userpage frame = new Userpage();
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
	
	public Userpage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(222, 11, 347, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Search By :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(29, 35, 101, 23);
		contentPane.add(lblNewLabel_2);
		
		txt = new JTextField();
		txt.setBounds(29, 59, 229, 19);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JLabel lbltop = new JLabel("Some Top-rated books");
		lbltop.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lbltop.setBounds(29, 89, 203, 29);
		contentPane.add(lbltop);
		
		JLabel imgl1 = new JLabel("");
		imgl1.setBounds(39, 134, 120, 171);
		Image i1=new ImageIcon(this.getClass().getResource("/105.jpg")).getImage();
		Image ii1=i1.getScaledInstance(imgl1.getWidth(),imgl1.getHeight() ,Image.SCALE_SMOOTH);
		imgl1.setIcon(new ImageIcon(ii1));
		contentPane.add(imgl1);
		
		JLabel imgl2 = new JLabel("");
		imgl2.setBounds(215, 134, 120, 171);
		Image i2=new ImageIcon(this.getClass().getResource("/109.jpg")).getImage();
		Image ii2=i2.getScaledInstance(imgl2.getWidth(),imgl2.getHeight() ,Image.SCALE_SMOOTH);
		imgl2.setIcon(new ImageIcon(ii2));
		contentPane.add(imgl2);
		
		JLabel imgl3 = new JLabel("");
		imgl3.setBounds(378, 134, 120, 171);
		Image i3=new ImageIcon(this.getClass().getResource("/112.jpg")).getImage();
		Image ii3=i3.getScaledInstance(imgl3.getWidth(),imgl3.getHeight() ,Image.SCALE_SMOOTH);
		imgl3.setIcon(new ImageIcon(ii3));
		contentPane.add(imgl3);
		
		JLabel imgl4 = new JLabel("");
		imgl4.setBounds(551, 134, 120, 171);
		Image i4=new ImageIcon(this.getClass().getResource("/119.jpg")).getImage();
		Image ii4=i4.getScaledInstance(imgl4.getWidth(),imgl4.getHeight() ,Image.SCALE_SMOOTH);
		imgl4.setIcon(new ImageIcon(ii4));
		contentPane.add(imgl4);
		
		JLabel imgl5 = new JLabel("");
		imgl5.setBounds(716, 132, 120, 171);
		Image i5=new ImageIcon(this.getClass().getResource("/103.jpg")).getImage();
		Image ii5=i5.getScaledInstance(imgl5.getWidth(),imgl5.getHeight() ,Image.SCALE_SMOOTH);
		imgl5.setIcon(new ImageIcon(ii5));
		contentPane.add(imgl5);
		
		JLabel bn1 = new JLabel("Charlie and the chocolate factory");
		bn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String s=JOptionPane.showInputDialog(null, "Enter quantity you need :");
					int q=Integer.parseInt(s);
					String sql="select title,author,genre,quantity,price,rating from books where title=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, bn1.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						if(rs.getInt(4)<q)
							JOptionPane.showMessageDialog(null, "Not enough quantity is available :(");
						else {
						String query="insert into cart values(?,?,?,?,?,?,?)";
						PreparedStatement ps1=MyConnection.getConnection().prepareStatement(query);
						ps1.setString(1, rs.getString(1));
						ps1.setString(2, rs.getString(2));
						ps1.setString(3, rs.getString(3));
						ps1.setInt(4,q);
						ps1.setString(5, rs.getString(5));
						ps1.setString(6, rs.getString(6));
						ps1.setString(7, u);
					    ps1.execute();
					    JOptionPane.showMessageDialog(null, "Added to Cart successfully :)");
					}
					}
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		bn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		bn1.setHorizontalAlignment(SwingConstants.CENTER);
		bn1.setBounds(0, 327, 190, 19);
		contentPane.add(bn1);
		
		JLabel bn2 = new JLabel("The Davinci Code");
		bn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String s=JOptionPane.showInputDialog(null, "Enter quantity you need :");
					int q=Integer.parseInt(s);
					String sql="select title,author,genre,quantity,price,rating from books where title=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, bn2.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						if(rs.getInt(4)<q)
							JOptionPane.showMessageDialog(null, "Not enough quantity is available :(");
						else {
						String query="insert into cart values(?,?,?,?,?,?,?)";
						PreparedStatement ps1=MyConnection.getConnection().prepareStatement(query);
						ps1.setString(1, rs.getString(1));
						ps1.setString(2, rs.getString(2));
						ps1.setString(3, rs.getString(3));
						ps1.setInt(4,q);
						ps1.setString(5, rs.getString(5));
						ps1.setString(6, rs.getString(6));
						ps1.setString(7, u);
					    ps1.execute();
					    JOptionPane.showMessageDialog(null, "Added to Cart successfully :)");
					}
					}
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		bn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		bn2.setHorizontalAlignment(SwingConstants.CENTER);
		bn2.setBounds(190, 327, 161, 19);
		contentPane.add(bn2);
		
		JLabel bn3 = new JLabel("Lord of the rings");
		bn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String s=JOptionPane.showInputDialog(null, "Enter quantity you need :");
					int q=Integer.parseInt(s);
					String sql="select title,author,genre,quantity,price,rating from books where title=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, bn3.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						if(rs.getInt(4)<q)
							JOptionPane.showMessageDialog(null, "Not enough quantity is available :(");
						else {
						String query="insert into cart values(?,?,?,?,?,?,?)";
						PreparedStatement ps1=MyConnection.getConnection().prepareStatement(query);
						ps1.setString(1, rs.getString(1));
						ps1.setString(2, rs.getString(2));
						ps1.setString(3, rs.getString(3));
						ps1.setInt(4,q);
						ps1.setString(5, rs.getString(5));
						ps1.setString(6, rs.getString(6));
						ps1.setString(7, u);
					    ps1.execute();
					    JOptionPane.showMessageDialog(null, "Added to Cart successfully :)");
					}
					}
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		bn3.setFont(new Font("Tahoma", Font.BOLD, 11));
		bn3.setHorizontalAlignment(SwingConstants.CENTER);
		bn3.setBounds(358, 327, 161, 19);
		contentPane.add(bn3);
		
		JLabel bn4 = new JLabel("I too had a love story");
		bn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String s=JOptionPane.showInputDialog(null, "Enter quantity you need :");
					int q=Integer.parseInt(s);
					String sql="select title,author,genre,quantity,price,rating from books where title=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, bn4.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						if(rs.getInt(4)<q)
							JOptionPane.showMessageDialog(null, "Not enough quantity is available :(");
						else {
						String query="insert into cart values(?,?,?,?,?,?,?)";
						PreparedStatement ps1=MyConnection.getConnection().prepareStatement(query);
						ps1.setString(1, rs.getString(1));
						ps1.setString(2, rs.getString(2));
						ps1.setString(3, rs.getString(3));
						ps1.setInt(4,q);
						ps1.setString(5, rs.getString(5));
						ps1.setString(6, rs.getString(6));
						ps1.setString(7, u);
					    ps1.execute();
					    JOptionPane.showMessageDialog(null, "Added to Cart successfully :)");
					}
					}
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		bn4.setFont(new Font("Tahoma", Font.BOLD, 11));
		bn4.setHorizontalAlignment(SwingConstants.CENTER);
		bn4.setBounds(534, 326, 161, 19);
		contentPane.add(bn4);
		
		JLabel bn5 = new JLabel("Steve Jobs");
		bn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String s=JOptionPane.showInputDialog(null, "Enter quantity you need :");
					int q=Integer.parseInt(s);
					String sql="select title,author,genre,quantity,price,rating from books where title=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, bn5.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						if(rs.getInt(4)<q)
							JOptionPane.showMessageDialog(null, "Not enough quantity is available :(");
						else {
						String query="insert into cart values(?,?,?,?,?,?,?)";
						PreparedStatement ps1=MyConnection.getConnection().prepareStatement(query);
						ps1.setString(1, rs.getString(1));
						ps1.setString(2, rs.getString(2));
						ps1.setString(3, rs.getString(3));
						ps1.setInt(4,q);
						ps1.setString(5, rs.getString(5));
						ps1.setString(6, rs.getString(6));
						ps1.setString(7, u);
					    ps1.execute();
					    JOptionPane.showMessageDialog(null, "Added to Cart successfully :)");
					}
					}
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		bn5.setFont(new Font("Tahoma", Font.BOLD, 11));
		bn5.setHorizontalAlignment(SwingConstants.CENTER);
		bn5.setBounds(705, 326, 161, 19);
		contentPane.add(bn5);
		
		JLabel c2 = new JLabel("375");
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		c2.setFont(new Font("Tahoma", Font.BOLD, 18));
		c2.setBounds(248, 412, 46, 29);
		contentPane.add(c2);
		
		JLabel c3 = new JLabel("419");
		c3.setFont(new Font("Tahoma", Font.BOLD, 18));
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		c3.setBounds(413, 412, 46, 29);
		contentPane.add(c3);
		
		JLabel c1 = new JLabel("250");
		c1.setFont(new Font("Tahoma", Font.BOLD, 18));
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		c1.setBounds(74, 412, 46, 29);
		contentPane.add(c1);
		
		JLabel c4 = new JLabel("199");
		c4.setHorizontalAlignment(SwingConstants.CENTER);
		c4.setFont(new Font("Tahoma", Font.BOLD, 18));
		c4.setBounds(589, 412, 46, 29);
		contentPane.add(c4);
		
		JLabel c5 = new JLabel("299");
		c5.setHorizontalAlignment(SwingConstants.CENTER);
		c5.setFont(new Font("Tahoma", Font.BOLD, 18));
		c5.setBounds(761, 412, 46, 29);
		contentPane.add(c5);
		
		JLabel rat1 = new JLabel("4.1");
		rat1.setForeground(new Color(255, 51, 204));
		rat1.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		rat1.setHorizontalAlignment(SwingConstants.CENTER);
		rat1.setBounds(74, 452, 46, 21);
		contentPane.add(rat1);
		
		JLabel rat2 = new JLabel("3.9");
		rat2.setForeground(new Color(255, 51, 204));
		rat2.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		rat2.setHorizontalAlignment(SwingConstants.CENTER);
		rat2.setBounds(248, 455, 46, 14);
		contentPane.add(rat2);
		
		JLabel rat3 = new JLabel("4.2");
		rat3.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		rat3.setForeground(new Color(255, 51, 204));
		rat3.setHorizontalAlignment(SwingConstants.CENTER);
		rat3.setBounds(413, 455, 46, 14);
		contentPane.add(rat3);
		
		JLabel rat4 = new JLabel("3.9");
		rat4.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		rat4.setForeground(new Color(255, 51, 204));
		rat4.setHorizontalAlignment(SwingConstants.CENTER);
		rat4.setBounds(589, 455, 46, 14);
		contentPane.add(rat4);
		
		JLabel rat5 = new JLabel("3.9");
		rat5.setHorizontalAlignment(SwingConstants.CENTER);
		rat5.setForeground(new Color(255, 51, 204));
		rat5.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		rat5.setBounds(761, 455, 46, 14);
		contentPane.add(rat5);
		
		JLabel a1 = new JLabel("Roald Dahl");
		a1.setForeground(new Color(51, 102, 102));
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setFont(new Font("Tahoma", Font.BOLD, 11));
		a1.setBounds(29, 357, 141, 14);
		contentPane.add(a1);
		
		JLabel a2 = new JLabel("Dan Brown");
		a2.setHorizontalAlignment(SwingConstants.CENTER);
		a2.setForeground(new Color(51, 102, 102));
		a2.setFont(new Font("Tahoma", Font.BOLD, 11));
		a2.setBounds(199, 357, 152, 14);
		contentPane.add(a2);
		
		JLabel a3 = new JLabel("JRR Tolkien");
		a3.setHorizontalAlignment(SwingConstants.CENTER);
		a3.setForeground(new Color(51, 102, 102));
		a3.setFont(new Font("Tahoma", Font.BOLD, 11));
		a3.setBounds(368, 357, 151, 14);
		contentPane.add(a3);
		
		JLabel a4 = new JLabel("Ravinder Singh");
		a4.setHorizontalAlignment(SwingConstants.CENTER);
		a4.setForeground(new Color(51, 102, 102));
		a4.setFont(new Font("Tahoma", Font.BOLD, 11));
		a4.setBounds(544, 357, 141, 14);
		contentPane.add(a4);
		
		JLabel a5 = new JLabel("Walter Issacson");
		a5.setHorizontalAlignment(SwingConstants.CENTER);
		a5.setForeground(new Color(51, 102, 102));
		a5.setFont(new Font("Tahoma", Font.BOLD, 11));
		a5.setBounds(715, 357, 134, 14);
		contentPane.add(a5);
		
		JLabel gen1 = new JLabel("Children");
		gen1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		gen1.setHorizontalAlignment(SwingConstants.CENTER);
		gen1.setForeground(new Color(153, 0, 153));
		gen1.setBounds(54, 387, 79, 14);
		contentPane.add(gen1);
		
		JLabel gen2 = new JLabel("Thriller");
		gen2.setForeground(new Color(153, 0, 153));
		gen2.setHorizontalAlignment(SwingConstants.CENTER);
		gen2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		gen2.setBounds(233, 387, 73, 14);
		contentPane.add(gen2);
		
		JLabel gen3 = new JLabel("Fantasy");
		gen3.setForeground(new Color(153, 0, 153));
		gen3.setHorizontalAlignment(SwingConstants.CENTER);
		gen3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		gen3.setBounds(396, 387, 73, 14);
		contentPane.add(gen3);
		
		JLabel gen4 = new JLabel("Fiction");
		gen4.setHorizontalAlignment(SwingConstants.CENTER);
		gen4.setForeground(new Color(153, 0, 153));
		gen4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		gen4.setBounds(570, 387, 89, 14);
		contentPane.add(gen4);
		
		JLabel gen5 = new JLabel("Biography");
		gen5.setForeground(new Color(153, 0, 153));
		gen5.setHorizontalAlignment(SwingConstants.CENTER);
		gen5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		gen5.setBounds(742, 387, 81, 14);
		contentPane.add(gen5);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Userlogin ul=new Userlogin();
					ul.setVisible(true);
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		btnNewButton.setBounds(748, 8, 101, 23);
		contentPane.add(btnNewButton);
		
		JButton btngenre = new JButton("By Genre");
		btngenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql1="select title,author,price,rating,image from books where genre=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql1);
					ps.setString(1, txt.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						if(rs.absolute(1)) {
						byte[] img1=rs.getBytes("image");
						ImageIcon imag1=new ImageIcon(img1);
						Image im1=imag1.getImage();
						ImageIcon pic1=new ImageIcon(im1.getScaledInstance(imgl1.getWidth(), imgl1.getHeight(), Image.SCALE_SMOOTH));
						imgl1.setIcon(pic1);
						bn1.setText(rs.getString("title"));
						a1.setText(rs.getString("author"));
						gen1.setText(txt.getText());
					    c1.setText(rs.getString("price"));
					    rat1.setText(rs.getString("rating")); 
					    }
						if(rs.absolute(2)) {
							byte[] img2=rs.getBytes("image");
							ImageIcon imag2=new ImageIcon(img2);
							Image im2=imag2.getImage();
							ImageIcon pic2=new ImageIcon(im2.getScaledInstance(imgl2.getWidth(), imgl2.getHeight(), Image.SCALE_SMOOTH));
							imgl2.setIcon(pic2);
							bn2.setText(rs.getString("title"));
							a2.setText(rs.getString("author"));
							gen2.setText(txt.getText());
						    c2.setText(rs.getString("price"));
						    rat2.setText(rs.getString("rating")); 
						    }
				        if(rs.absolute(3)) {
							byte[] img3=rs.getBytes("image");
							ImageIcon imag3=new ImageIcon(img3);
							Image im3=imag3.getImage();
							ImageIcon pic3=new ImageIcon(im3.getScaledInstance(imgl3.getWidth(), imgl3.getHeight(), Image.SCALE_SMOOTH));
							imgl3.setIcon(pic3);
							bn3.setText(rs.getString("title"));
							a3.setText(rs.getString("author"));
							gen3.setText(txt.getText());
						    c3.setText(rs.getString("price"));
						    rat3.setText(rs.getString("rating")); 
						    }
					
					lbltop.setText(" ");
					bn4.setText(" ");
					bn5.setText(" ");
					a4.setText(" ");
					a5.setText(" ");
					gen4.setText(" ");
					gen5.setText(" ");
					c4.setText(" ");
					c5.setText(" ");
					rat4.setText(" ");
					rat5.setText(" ");
					imgl4.setVisible(false);
					imgl5.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Genre!");
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btngenre.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		btngenre.setForeground(new Color(102, 0, 102));
		btngenre.setBackground(new Color(204, 255, 153));
		btngenre.setBounds(279, 59, 101, 29);
		contentPane.add(btngenre);
		
		JButton btnbname = new JButton("By Bookname");
		btnbname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
										
					String sql1="select author,genre,price,rating,image from books where title=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql1);
					ps.setString(1, txt.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()==true) {
						byte[] img=rs.getBytes("image");
						ImageIcon imag=new ImageIcon(img);
						Image im=imag.getImage();
						ImageIcon pic=new ImageIcon(im.getScaledInstance(imgl1.getWidth(), imgl1.getHeight(), Image.SCALE_SMOOTH));
						imgl1.setIcon(pic);
						bn1.setText(txt.getText());
						a1.setText(rs.getString("author"));
						gen1.setText(rs.getString("genre"));
					    c1.setText(rs.getString("price"));
					    rat1.setText(rs.getString("rating"));
					lbltop.setText(" ");
					bn2.setText(" ");
					bn3.setText(" ");
					bn4.setText(" ");
					bn5.setText(" ");
					a2.setText(" ");
					a3.setText(" ");
					a4.setText(" ");
					a5.setText(" ");
					gen2.setText(" ");
					gen3.setText(" ");
					gen4.setText(" ");
					gen5.setText(" ");
					c2.setText(" ");
					c3.setText(" ");
					c4.setText(" ");
					c5.setText(" ");
					rat2.setText(" ");
					rat3.setText(" ");
					rat4.setText(" ");
					rat5.setText(" ");
					imgl2.setVisible(false);
					imgl3.setVisible(false);
					imgl4.setVisible(false);
					imgl5.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Bookname!");
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnbname.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		btnbname.setBackground(new Color(204, 255, 153));
		btnbname.setForeground(new Color(102, 0, 102));
		btnbname.setBounds(396, 59, 134, 29);
		contentPane.add(btnbname);
		
		JButton btnaname = new JButton("By Authorname");
		btnaname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String sql1="select title,genre,price,rating,image from books where author=? ";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql1);
					ps.setString(1, txt.getText());
					ResultSet rs=ps.executeQuery();
					if(rs.next()==true) {
						byte[] img=rs.getBytes("image");
						ImageIcon imag=new ImageIcon(img);
						Image im=imag.getImage();
						ImageIcon pic=new ImageIcon(im.getScaledInstance(imgl1.getWidth(), imgl1.getHeight(), Image.SCALE_SMOOTH));
						imgl1.setIcon(pic);
						bn1.setText(rs.getString("title"));
						a1.setText(txt.getText());
						gen1.setText(rs.getString("genre"));
					    c1.setText(rs.getString("price"));
					    rat1.setText(rs.getString("rating"));
					lbltop.setText(" ");
					bn2.setText(" ");
					bn3.setText(" ");
					bn4.setText(" ");
					bn5.setText(" ");
					a2.setText(" ");
					a3.setText(" ");
					a4.setText(" ");
					a5.setText(" ");
					gen2.setText(" ");
					gen3.setText(" ");
					gen4.setText(" ");
					gen5.setText(" ");
					c2.setText(" ");
					c3.setText(" ");
					c4.setText(" ");
					c5.setText(" ");
					rat2.setText(" ");
					rat3.setText(" ");
					rat4.setText(" ");
					rat5.setText(" ");
					imgl2.setVisible(false);
					imgl3.setVisible(false);
					imgl4.setVisible(false);
					imgl5.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Incorrect Authorname!");
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnaname.setForeground(new Color(102, 0, 102));
		btnaname.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		btnaname.setBackground(new Color(204, 255, 153));
		btnaname.setBounds(544, 59, 141, 29);
		contentPane.add(btnaname);
		
		JButton btncart = new JButton("");
		btncart.setForeground(new Color(255, 255, 255));
		btncart.setBackground(new Color(0, 0, 0));
		btncart.setBounds(727, 42, 54, 50);
		Image i=new ImageIcon(this.getClass().getResource("/carticon.jpg")).getImage();
		Image ii=i.getScaledInstance(btncart.getWidth(),btncart.getHeight() ,Image.SCALE_SMOOTH);
		btncart.setIcon(new ImageIcon(ii));
		btncart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					dispose();
					Cart cp=new Cart();
					cp.set(u);
					cp.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		contentPane.add(btncart);
		
		JLabel lblNewLabel_3 = new JLabel("*Click on Book name to add to your Cart*");
		lblNewLabel_3.setForeground(new Color(255, 0, 51));
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(511, 99, 325, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton btnor = new JButton("");
		btnor.setForeground(new Color(255, 255, 255));
		btnor.setBackground(new Color(0, 0, 0));
		btnor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Userorder uo=new Userorder();
					uo.set(u);
					uo.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}

			}
		});
		btnor.setBounds(796, 42, 54, 50);
		Image j=new ImageIcon(this.getClass().getResource("/orders.png")).getImage();
		Image jj=j.getScaledInstance(btnor.getWidth(),btnor.getHeight() ,Image.SCALE_SMOOTH);
		btnor.setIcon(new ImageIcon(jj));
		contentPane.add(btnor);
		
		
		
		
	}
}
