package home;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import home.Userpage.MyConnection;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
public class Cart extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String user;
	public int c,cost,qu,dcost,d;

	/**
	 * Launch the application.
	 */
	void set(String u) {
		user=u;
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
					Cart frame = new Cart();
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

	public Cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 499);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(348, 11, 347, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Userpage cp=new Userpage();
					cp.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(735, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Your Shopping CART");
		lblNewLabel_1.setForeground(new Color(0, 102, 102));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(417, 81, 213, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbldisc = new JLabel("");
		lbldisc.setBounds(10, 11, 199, 193);
		Image i=new ImageIcon(this.getClass().getResource("/megadis.jpg")).getImage();
		Image ii=i.getScaledInstance(lbldisc.getWidth(),lbldisc.getHeight() ,Image.SCALE_SMOOTH);
		lbldisc.setIcon(new ImageIcon(ii));
		contentPane.add(lbldisc);
		
		JButton btnadd = new JButton("Add an Item");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Userpage cp=new Userpage();
					cp.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnadd.setForeground(new Color(0, 51, 102));
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnadd.setBackground(new Color(255, 255, 153));
		btnadd.setBounds(10, 215, 199, 30);
		contentPane.add(btnadd);
		
		JButton btndel = new JButton("Delete an Item");
		btndel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					String s=JOptionPane.showInputDialog(null, "Enter book name to be deleted :");
					String sql="delete from cart where title=? and username=?";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, s);
					ps.setString(2, user);
					if(ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "Deleted from cart successfully!");
						dispose();
						Cart cp=new Cart();
						cp.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Such a book is not in the cart!");

			}
				catch(Exception ee) {
					ee.printStackTrace();
				}
		}});
		btndel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndel.setForeground(new Color(0, 51, 102));
		btndel.setBackground(new Color(255, 255, 153));
		btndel.setBounds(10, 256, 199, 30);
		contentPane.add(btndel);
		
		JLabel lblimg2 = new JLabel("");
		lblimg2.setBounds(231, 11, 107, 71);
		Image i1=new ImageIcon(this.getClass().getResource("/dis.jpg")).getImage();
		Image ii1=i1.getScaledInstance(lblimg2.getWidth(),lblimg2.getHeight() ,Image.SCALE_SMOOTH);
		lblimg2.setIcon(new ImageIcon(ii1));
		contentPane.add(lblimg2);
		
		JLabel lblNewLabel_2 = new JLabel("Total Books      :");
		lblNewLabel_2.setForeground(new Color(204, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(254, 381, 162, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Quantity :");
		lblNewLabel_3.setForeground(new Color(204, 0, 102));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(254, 422, 162, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblit = new JLabel("");
		lblit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblit.setHorizontalAlignment(SwingConstants.CENTER);
		lblit.setBounds(425, 381, 46, 28);
		contentPane.add(lblit);
		
		JLabel lblq = new JLabel("");
		lblq.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblq.setHorizontalAlignment(SwingConstants.CENTER);
		lblq.setBounds(425, 422, 46, 27);
		contentPane.add(lblq);
		
		JLabel lblNewLabel_4 = new JLabel("TOTAL COST :");
		lblNewLabel_4.setForeground(new Color(102, 0, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(520, 395, 179, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblcost = new JLabel("");
		lblcost.setForeground(new Color(255, 0, 51));
		lblcost.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblcost.setBounds(709, 395, 102, 40);
		contentPane.add(lblcost);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 122, 580, 241);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnorder = new JButton("ORDER & PAY");
		btnorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	    Random r=new Random();
                	    int id=r.nextInt(10000);
    					long millis=System.currentTimeMillis();
    					java.sql.Date date=new java.sql.Date(millis);
    					String sql="select * from cart where username=? ";
    					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
    					ps.setString(1, user);
    					ResultSet rs=ps.executeQuery();
    					
    					while(rs.next()) {

    						String query="insert into orderdb values(?,?,?,?,?,?,?,?)";
    						PreparedStatement ps1=MyConnection.getConnection().prepareStatement(query);
    						ps1.setInt(1, id);
    						ps1.setString(2, rs.getString(7));
    						ps1.setString(3, rs.getString(1));
    						ps1.setString(4, rs.getString(2));
    						ps1.setString(5, rs.getString(3));
    						ps1.setString(6, rs.getString(4));
    						ps1.setString(7, rs.getString(5));
    						ps1.setDate(8, date);
    					    ps1.execute();
    					    
    					}
    					dcost=0;d=0;
    					if(cost>=10000) {
    						d=(int)(cost*0.50);
    						dcost=cost-d;
    					}
    					else if(cost>=5000) {
    						d=(int)(cost*0.25);
    						dcost=cost-d;
    					}
    					else if(cost>=2000) {
    						d=(int)(cost*0.10);
    						dcost=cost-d;;
    					}
    					else
    						dcost=cost;
					dispose();
					Orderaddress oa=new Orderaddress();
					oa.setu(user,c,qu,cost,d,dcost,id);
					oa.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnorder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnorder.setForeground(new Color(255, 255, 255));
		btnorder.setBackground(new Color(0, 0, 0));
		btnorder.setBounds(10, 409, 199, 40);
		contentPane.add(btnorder);
		
		JTextArea txtrHi = new JTextArea();
		txtrHi.setText("Rs. 2000 above - 10% off\r\nRs. 5000 above - 25% off\r\nRs.10000 above - 50% off");
		txtrHi.setRows(3);
		txtrHi.setBounds(10, 331, 199, 67);
		contentPane.add(txtrHi);
		
		JLabel lblNewLabel_5 = new JLabel("DISCOUNTS");
		lblNewLabel_5.setForeground(new Color(255, 102, 0));
		lblNewLabel_5.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(37, 300, 151, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome  ");
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(395, 52, 116, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(new Color(0, 0, 102));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(516, 52, 129, 30);
		contentPane.add(lblNewLabel_7);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
               try {
            	   lblNewLabel_7.setText(user);
					DefaultTableModel dtm=new DefaultTableModel();
					dtm.addColumn("TITLE");
					dtm.addColumn("AUTHOR");
					dtm.addColumn("GENRE");
					dtm.addColumn("QUANTITY");
					dtm.addColumn("PRICE");
					dtm.addColumn("RATING");
					String sql="select * FROM cart where username=?";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, user);
					ResultSet rss=ps.executeQuery();
				    c=0;cost=0;qu=0;
					while(rss.next()) {
						c++;
						dtm.addRow(new Object[] {rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6)});
						qu=qu+Integer.parseInt(rss.getString(4));
						cost=cost+(Integer.parseInt(rss.getString(4))*Integer.parseInt(rss.getString(5)));
						
					}
					
					lblit.setText(Integer.toString(c));
					lblq.setText(Integer.toString(qu));
					lblcost.setText(Integer.toString(cost));
					rss.close();
					ps.close();
					table.setModel(dtm);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(180);
					table.getColumnModel().getColumn(1).setPreferredWidth(140);
					table.getColumnModel().getColumn(2).setPreferredWidth(100);
					table.getColumnModel().getColumn(3).setPreferredWidth(60);
					table.getColumnModel().getColumn(4).setPreferredWidth(50);
					table.getColumnModel().getColumn(5).setPreferredWidth(60);
				}
				catch(Exception ee) {
						System.out.print(ee);
				}
			}
		});
		
		
	}
	}



	


