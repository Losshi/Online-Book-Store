package home;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Mobile extends JFrame {

	private JPanel contentPane;
	public static int otp;
	public static String mno,user;
    public static int item,quan,cost,dis,dcost,oid;


	/**
	 * Launch the application.
	 */
	void set(String u,int c,int q,int co,int di,int dc,int id,int o,String m) {

	    	user=u;
	    	item=c;
	    	quan=q;
	    	cost=co;
	    	dis=di;
	    	dcost=dc;
	    	oid=id;
		    otp=o;
		    mno=m;
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
					Mobile frame = new Mobile();
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
	public Mobile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mobile Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(new Color(255, 204, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 25, 215, 34);
		contentPane.add(lblNewLabel);
		
		JLabel mbl = new JLabel("");
		mbl.setHorizontalAlignment(SwingConstants.CENTER);
		mbl.setForeground(new Color(255, 255, 255));
		mbl.setBounds(110, 79, 215, 34);
		contentPane.add(mbl);
		
		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lbl.setForeground(new Color(255, 204, 255));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(110, 164, 215, 34);
		contentPane.add(lbl);
		
		JLabel lblotp = new JLabel("");
		lblotp.setHorizontalAlignment(SwingConstants.CENTER);
		lblotp.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblotp.setForeground(new Color(255, 255, 0));
		lblotp.setBounds(140, 221, 156, 51);
		contentPane.add(lblotp);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				mbl.setText(mno);
				lbl.setText("Your OTP is");
				lblotp.setText(Integer.toString(otp));
				try {
				String txt=JOptionPane.showInputDialog(null, "Enter the OTP send to your Mobile number...");
				if(otp==Integer.parseInt(txt)) {
				    dispose();
					JOptionPane.showMessageDialog(null, "OTP verified! Payment successful :)");
					String sql1="select title,quantity from orderdb where username=? and orderid=?";
					PreparedStatement ps1=MyConnection.getConnection().prepareStatement(sql1);
					ps1.setString(1, user);
					ps1.setInt(2, oid);
					ResultSet rs=ps1.executeQuery();
					while(rs.next()) {
						int nw=rs.getInt(2);
						String s1="select quantity from books where title=?";
						PreparedStatement p=MyConnection.getConnection().prepareStatement(s1);
						p.setString(1, rs.getString(1));
						ResultSet re=p.executeQuery();
						re.next();
						int old=re.getInt(1);
						int c=old-nw;
						String query="update books set quantity=? where title=?";
						PreparedStatement pps=MyConnection.getConnection().prepareStatement(query);
						pps.setInt(1, c);
						pps.setString(2,rs.getString(1));
						pps.execute();
					}
					
					JOptionPane.showMessageDialog(null, "YOUR ORDER IS CONFIRMED :) [Order ID - "+oid+"] THANK YOU BUY AGAIN !");
					Cardpay cc=new Cardpay();
					cc.dispose();
					Userorder uo=new Userorder();
					uo.set(user);
					uo.setVisible(true);
				}
				else {
					dispose();
					JOptionPane.showMessageDialog(null, "Incorrect OTP :(");
				}
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
	}

}
