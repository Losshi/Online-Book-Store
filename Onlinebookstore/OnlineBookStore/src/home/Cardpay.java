package home;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.Payment.MyConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cardpay extends JFrame {

	private JPanel contentPane;
	public static String user;
    public static int item,quan,cost,dis,dcost,oid;
    private JTextField tno;
    private JTextField tname;
    private JTextField tbank;
    private JTextField mnth;
    private JTextField year;
    private JTextField ccv;
    private JTextField amount;
    private JTextField tmob;
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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cardpay frame = new Cardpay();
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
	public Cardpay() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 444);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BANK PORTAL");
		lblNewLabel.setForeground(new Color(204, 0, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(172, 11, 295, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 70, 198, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Card Holder Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(50, 112, 198, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bank Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(50, 155, 198, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Expiry Month & Year");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(50, 187, 198, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CCV Number (3-digit)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(50, 233, 198, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Payment Amount");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(50, 271, 198, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(50, 311, 198, 21);
		contentPane.add(lblNewLabel_7);
		
		tno = new JTextField();
		tno.setBackground(new Color(204, 255, 255));
		tno.setBounds(287, 73, 227, 20);
		contentPane.add(tno);
		tno.setColumns(10);
		
		tname = new JTextField();
		tname.setBackground(new Color(204, 255, 255));
		tname.setBounds(287, 115, 227, 20);
		contentPane.add(tname);
		tname.setColumns(10);
		
		tbank = new JTextField();
		tbank.setBackground(new Color(204, 255, 255));
		tbank.setBounds(287, 158, 227, 20);
		contentPane.add(tbank);
		tbank.setColumns(10);
		
		mnth = new JTextField();
		mnth.setBackground(new Color(204, 255, 255));
		mnth.setBounds(287, 197, 86, 20);
		contentPane.add(mnth);
		mnth.setColumns(10);
		
		year = new JTextField();
		year.setBackground(new Color(204, 255, 255));
		year.setBounds(417, 197, 97, 20);
		contentPane.add(year);
		year.setColumns(10);
		
		ccv = new JTextField();
		ccv.setBackground(new Color(204, 255, 255));
		ccv.setBounds(287, 236, 227, 20);
		contentPane.add(ccv);
		ccv.setColumns(10);
		
		amount = new JTextField();
		amount.setBackground(new Color(204, 255, 255));
		amount.setBounds(287, 274, 227, 20);
		contentPane.add(amount);
		amount.setColumns(10);
		
		tmob = new JTextField();
		tmob.setBackground(new Color(204, 255, 255));
		tmob.setBounds(287, 314, 227, 20);
		contentPane.add(tmob);
		tmob.setColumns(10);
		
		JButton btnpay = new JButton("PROCEED TO PAY");
		btnpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String t1=tno.getText();
					String t2=tname.getText();
					String t3=tbank.getText();
					String t4=mnth.getText();
					String t5=year.getText();
					String t6=ccv.getText();
					String t7=tmob.getText();
					
					if(t1.equals(""))
						JOptionPane.showMessageDialog(null, "Enter card number!");
					else if(t2.equals(""))
						JOptionPane.showMessageDialog(null, "Enter card holder name!");
					else if(t3.equals(""))
						JOptionPane.showMessageDialog(null, "Enter bank name!");
					else if(t4.equals(""))
						JOptionPane.showMessageDialog(null, "Enter expiry month!");
					else if(t5.equals(""))
						JOptionPane.showMessageDialog(null, "Enter expiry year!");
					else if(t6.equals(""))
						JOptionPane.showMessageDialog(null, "Enter CCV number!");
					else if(t7.equals(""))
						JOptionPane.showMessageDialog(null, "Enter mobile number!");
					else if(t1.length()!=16)
						JOptionPane.showMessageDialog(null, "Invalid card number!");
					else if(t5.length()!=4)
						JOptionPane.showMessageDialog(null, "Invalid expiry year!");
					else if(t6.length()!=3)
						JOptionPane.showMessageDialog(null, "Invalid CCV number!");
					else if(t7.length()!=10)
						JOptionPane.showMessageDialog(null, "Invalid mobile number!");
					else if(Integer.parseInt(t4)>12||Integer.parseInt(t4)<1)
						JOptionPane.showMessageDialog(null, "Invalid expiry month!");
					else if(Integer.parseInt(t5)<2020)
						JOptionPane.showMessageDialog(null, "Card not accepted!");
					else {
						String sql="select * from bankdb where cno=? and cname=? and bank=? and mon=? and year=? and ccv=? and mobile=?";
						PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
						ps.setString(1,t1);
						ps.setString(2, t2);
						ps.setString(3, t3);
						ps.setInt(4, Integer.parseInt(t4));
						ps.setInt(5, Integer.parseInt(t5));
						ps.setInt(6, Integer.parseInt(t6));
						ps.setString(7,t7);
						ResultSet s=ps.executeQuery();
						if(s.next()) {
							Random r=new Random();
							int otp=r.nextInt(999999);
							Mobile m=new Mobile();
							m.set(user,item,quan,cost,dis,dcost,oid,otp,t7);
							m.setVisible(true);
	
							
						}
						else
							JOptionPane.showConfirmDialog(null, "Wrong details!");
					}
					
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnpay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpay.setForeground(new Color(51, 0, 102));
		btnpay.setBounds(112, 354, 181, 28);
		contentPane.add(btnpay);
		
		JButton btncanpay = new JButton("CANCEL PAYMENT");
		btncanpay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btncanpay.setForeground(new Color(51, 0, 102));
		btncanpay.setBounds(324, 352, 181, 28);
		contentPane.add(btncanpay);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				amount.setText(Integer.toString(dcost));
			}
		});
	}

}
