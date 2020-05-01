package home;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.Orderaddress.MyConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	public static String user;
    public static int item,quan,cost,dis,dcost,oid;
	/**
	 * Launch the application.
	 */
	
	void set(String u,int c,int q,int co,int di,int dc,int id) {
    	user=u;
    	item=c;
    	quan=q;
    	cost=co;
    	dis=di;
    	dcost=dc;
    	oid=id;
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
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 404);
		contentPane = new JPanel();
				contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setForeground(new Color(0, 102, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 11, 298, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PAYMENT GATEWAY");
		lblNewLabel_1.setForeground(new Color(102, 0, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(113, 53, 248, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Order ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(93, 95, 137, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Books");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(93, 132, 137, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Quantity");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(93, 170, 137, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Order Cost");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(93, 212, 137, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lbloid = new JLabel("");
		lbloid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbloid.setForeground(new Color(255, 0, 102));
		lbloid.setBounds(240, 95, 121, 24);
		contentPane.add(lbloid);
		
		JLabel lblit = new JLabel("");
		lblit.setForeground(new Color(255, 0, 102));
		lblit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblit.setBounds(240, 132, 121, 24);
		contentPane.add(lblit);
		
		JLabel lblqu = new JLabel("");
		lblqu.setForeground(new Color(255, 0, 102));
		lblqu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblqu.setBounds(240, 170, 121, 31);
		contentPane.add(lblqu);
		
		JLabel lblc = new JLabel("");
		lblc.setForeground(new Color(255, 0, 102));
		lblc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblc.setBounds(240, 212, 143, 24);
		contentPane.add(lblc);
		
		JLabel lblNewLabel_6 = new JLabel("Choose your mode of payment...");
		lblNewLabel_6.setForeground(new Color(153, 0, 153));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(55, 247, 363, 31);
		contentPane.add(lblNewLabel_6);
		
		JButton btncod = new JButton("Cash on Delivery");
		btncod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="select title,quantity from orderdb where username=? and orderid=?";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setString(1, user);
					ps.setInt(2, oid);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						int nw=rs.getInt(2);
						String s1="select quantity from books where title=?";
						PreparedStatement p=MyConnection.getConnection().prepareStatement(s1);
						p.setString(1, rs.getString(1));
						ResultSet r=p.executeQuery();
						r.next();
						int old=r.getInt(1);
						int c=old-nw;
						String query="update books set quantity=? where title=?";
						PreparedStatement pps=MyConnection.getConnection().prepareStatement(query);
						pps.setInt(1, c);
						pps.setString(2,rs.getString(1));
						pps.execute();
					}
					JOptionPane.showMessageDialog(null, "YOUR ORDER IS CONFIRMED :) [Order ID - "+oid+"] THANK YOU BUY AGAIN !");
					dispose();
					Userorder uo=new Userorder();
					uo.set(user);
					uo.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btncod.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncod.setForeground(new Color(0, 102, 102));
		btncod.setBackground(new Color(255, 255, 255));
		btncod.setBounds(42, 289, 170, 31);
		contentPane.add(btncod);
		
		JButton btncard = new JButton("Credit/Debit card");
		btncard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Cardpay c=new Cardpay();
					c.set(user,item,quan,cost,dis,dcost,oid);
					c.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btncard.setForeground(new Color(0, 102, 102));
		btncard.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncard.setBackground(new Color(255, 255, 255));
		btncard.setBounds(240, 289, 170, 31);
		contentPane.add(btncard);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Orderaddress o=new Orderaddress();
					o.setu(user,item,quan,cost,dis,dcost,oid);
					o.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(394, 11, 71, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL ORDER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="delete from orderdb where orderid=?";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setInt(1, oid);
					String s="delete from address where orderid=?";
					PreparedStatement p=MyConnection.getConnection().prepareStatement(s);
					p.setInt(1, oid);
					if(ps.executeUpdate()>0 && p.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null,"Order cancelled!");
					dispose();
					Cart c=new Cart();
					c.set(user);
					c.setVisible(true);
					}
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(141, 331, 153, 23);
		contentPane.add(btnNewButton_1);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbloid.setText(Integer.toString(oid));
				lblit.setText(Integer.toString(item));
				lblqu.setText(Integer.toString(quan));
				lblc.setText(Integer.toString(dcost));
			}
		});

	}

}
