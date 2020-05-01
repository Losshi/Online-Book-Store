package home;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import home.Cart.MyConnection;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Userorder extends JFrame {
	

	private JPanel contentPane;
	public static String user;
	private JTable table;

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
					Userorder frame = new Userorder();
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
	public Userorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setForeground(new Color(255, 0, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(230, 11, 330, 35);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
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
		back.setBounds(679, 11, 89, 23);
		contentPane.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setForeground(new Color(153, 0, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(26, 71, 141, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(153, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(26, 110, 141, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("YOUR ORDERS");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(396, 68, 195, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(26, 165, 162, 216);
		Image i=new ImageIcon(this.getClass().getResource("/orders.png")).getImage();
		Image ii=i.getScaledInstance(lblimg.getWidth(),lblimg.getHeight() ,Image.SCALE_SMOOTH);
		lblimg.setIcon(new ImageIcon(ii));
		contentPane.add(lblimg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 121, 537, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					lblNewLabel_2.setText(user);
					DefaultTableModel dtm=new DefaultTableModel();
					dtm.addColumn("ORDER ID");
					dtm.addColumn("ORDER COST");
					dtm.addColumn("TITLE");
					dtm.addColumn("QUANTITY");
					dtm.addColumn("PRICE");
					dtm.addColumn("DATE");
					String sql="select address.orderid,ordercost,title,quantity,price,date from orderdb join address on orderdb.orderid=address.orderid where address.username=?";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, user);
					ResultSet rss=ps.executeQuery();
					while(rss.next()) {
						dtm.addRow(new Object[] {
								rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6)
						});
					}
					rss.close();
					ps.close();
					table.setModel(dtm);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(100);
					table.getColumnModel().getColumn(1).setPreferredWidth(90);
					table.getColumnModel().getColumn(2).setPreferredWidth(150);
					table.getColumnModel().getColumn(3).setPreferredWidth(70);
					table.getColumnModel().getColumn(4).setPreferredWidth(70);
    				table.getColumnModel().getColumn(5).setPreferredWidth(70);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
	}
}
