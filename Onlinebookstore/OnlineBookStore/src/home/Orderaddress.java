package home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Orderaddress extends JFrame {

	private JPanel contentPane;
    public static String user;
    public static int item,quan,cost,dis,dcost,oid;
    private JTextField doorno;
    private JTextField add1;
    private JTextField add2;
    private JTextField place;
    private JTextField state;
    private JTextField pin;
    private JTextField cont;
    
    void setu(String u,int c,int q,int co,int di,int dc,int id) {
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
					Orderaddress frame = new Orderaddress();
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
	public Orderaddress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 490);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setForeground(new Color(153, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 11, 345, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DELIVERY ADDRESS");
		lblNewLabel_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 57, 201, 27);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(430, 56, 1, 384);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("ORDER SUMMARY");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel_2.setForeground(new Color(255, 51, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(462, 56, 264, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Books      :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(449, 135, 162, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Quantity   :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(449, 177, 162, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Actual Cost       :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(449, 219, 162, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Discount           :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(447, 255, 164, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lbli = new JLabel("");
		lbli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbli.setForeground(new Color(153, 0, 102));
		lbli.setBounds(621, 135, 91, 21);
		
		contentPane.add(lbli);
		
		JLabel lblq = new JLabel("");
		lblq.setForeground(new Color(153, 0, 102));
		lblq.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblq.setBounds(621, 178, 91, 20);
		
		contentPane.add(lblq);
		
		JLabel lblcost = new JLabel("");
		lblcost.setForeground(new Color(153, 0, 102));
		lblcost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblcost.setBounds(621, 220, 91, 20);
		
		contentPane.add(lblcost);
		
		JLabel lbld = new JLabel("");
		lbld.setForeground(new Color(153, 0, 102));
		lbld.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbld.setBounds(621, 256, 85, 20);
		
		contentPane.add(lbld);
		
		JLabel lblNewLabel_7 = new JLabel("TOTAL COST :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_7.setBounds(449, 287, 162, 34);
		contentPane.add(lblNewLabel_7);
		
		JLabel lbldcost = new JLabel("");
		lbldcost.setForeground(new Color(153, 0, 102));
		lbldcost.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbldcost.setBounds(621, 287, 105, 34);
				contentPane.add(lbldcost);
		
		JLabel freedel = new JLabel("");
		freedel.setBounds(480, 332, 232, 108);
		Image i=new ImageIcon(this.getClass().getResource("/freede.jpg")).getImage();
		Image ii=i.getScaledInstance(freedel.getWidth(),freedel.getHeight() ,Image.SCALE_SMOOTH);
		freedel.setIcon(new ImageIcon(ii));
		contentPane.add(freedel);
		
		JLabel lblNewLabel_8 = new JLabel("Door Number");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(20, 95, 125, 21);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address line 1");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(20, 136, 125, 21);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Address line 2");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(20, 178, 125, 21);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Place");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(20, 220, 125, 21);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("State");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_12.setBounds(20, 263, 125, 21);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Pin Code");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_13.setBounds(20, 306, 125, 21);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Contact Number");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_14.setBounds(20, 348, 125, 21);
		contentPane.add(lblNewLabel_14);
		
		doorno = new JTextField();
		doorno.setBounds(178, 95, 214, 20);
		contentPane.add(doorno);
		doorno.setColumns(10);
		
		add1 = new JTextField();
		add1.setBounds(178, 138, 214, 20);
		contentPane.add(add1);
		add1.setColumns(10);
		
		add2 = new JTextField();
		add2.setBounds(178, 180, 214, 20);
		contentPane.add(add2);
		add2.setColumns(10);
		
		place = new JTextField();
		place.setBounds(178, 222, 214, 20);
		contentPane.add(place);
		place.setColumns(10);
		
		state = new JTextField();
		state.setBounds(178, 265, 214, 20);
		contentPane.add(state);
		state.setColumns(10);
		
		pin = new JTextField();
		pin.setBounds(178, 308, 214, 20);
		contentPane.add(pin);
		pin.setColumns(10);
		
		cont = new JTextField();
		cont.setBounds(178, 350, 214, 20);
		contentPane.add(cont);
		cont.setColumns(10);
		
		JButton btnsubmit = new JButton("SUBMIT");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String t2=doorno.getText();
					String t3=add1.getText();
					String t4=add2.getText();
					String t5=place.getText();
					String t6=state.getText();
					String t7=pin.getText();
					String t8=cont.getText();
					if(t2.equals(""))
						JOptionPane.showMessageDialog(null, "Enter door number!");
					else if(t3.equals(""))
						JOptionPane.showMessageDialog(null, "Enter address line 1!");
					else if(t4.equals(""))
						JOptionPane.showMessageDialog(null, "Enter address line 2!");
					else if(t5.equals(""))
						JOptionPane.showMessageDialog(null, "Enter place!");
					else if(t6.equals(""))
						JOptionPane.showMessageDialog(null, "Enter state!");
					else if(t7.equals(""))
						JOptionPane.showMessageDialog(null, "Enter pincode!");
					else if(t8.equals(""))
						JOptionPane.showMessageDialog(null, "Enter contact number!");
					else if(t7.length()<6||t7.length()>6)
						JOptionPane.showMessageDialog(null, "Invalid Pincode!");
					else if(t8.length()<10||t8.length()>10)
						JOptionPane.showMessageDialog(null, "Invalid contact number!");
					else {
					String sql="insert into address values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setInt(1, oid);
					ps.setInt(2, dcost);
					ps.setString(3, user);
					ps.setString(4, doorno.getText());
					ps.setString(5, add1.getText());
					ps.setString(6, add2.getText());
					ps.setString(7, place.getText());
					ps.setString(8, state.getText());
					ps.setString(9,pin.getText());
					ps.setString(10, cont.getText());
					if(ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null,"Address added successfully :)");
						dispose();
						Payment p=new Payment();
						p.set(user,item,quan,cost,dis,dcost,oid);
						p.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"Can't add address!");
					}
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
				
			}
		});
		btnsubmit.setBackground(new Color(255, 255, 255));
		btnsubmit.setForeground(new Color(204, 51, 102));
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnsubmit.setBounds(33, 393, 152, 34);
		contentPane.add(btnsubmit);
		
		JLabel lblNewLabel_15 = new JLabel("Order ID          :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_15.setBounds(449, 95, 162, 21);
		contentPane.add(lblNewLabel_15);
		
		JLabel lbloid = new JLabel("");
		lbloid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbloid.setForeground(new Color(153, 0, 102));
		lbloid.setBounds(621, 95, 91, 21);
		contentPane.add(lbloid);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Cart c=new Cart();
					c.set(user);
					c.setVisible(true);
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(654, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btncancel = new JButton("CANCEL ORDER");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="delete from orderdb where orderid=?";
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(sql);
					ps.setInt(1, oid);
					if(ps.executeUpdate()>0) {
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
		btncancel.setBackground(new Color(255, 255, 255));
		btncancel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btncancel.setForeground(new Color(204, 51, 102));
		btncancel.setBounds(203, 393, 189, 32);
		contentPane.add(btncancel);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbli.setText(Integer.toString(item));
				lblq.setText(Integer.toString(quan));
				lblcost.setText(Integer.toString(cost));
				lbld.setText(Integer.toString(dis));
				lbldcost.setText(Integer.toString(dcost));
				lbloid.setText(Integer.toString(oid));

			}
		});
	}
}
