package home;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Advieworders extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Advieworders frame = new Advieworders();
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
	public Advieworders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(263, 41, 496, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("LIST OF ORDERS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(367, 75, 306, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblimg = new JLabel("");
		lblimg.setBounds(0, -13, 328, 350);
		Image img2=new ImageIcon(this.getClass().getResource("/order.jpg")).getImage();
		Image x=img2.getScaledInstance(lblimg.getWidth(),lblimg.getHeight() ,Image.SCALE_SMOOTH);
		lblimg.setIcon(new ImageIcon(x));
		contentPane.add(lblimg);
		

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(183, 329, 144, 200);
		Image img1=new ImageIcon(this.getClass().getResource("/truck.jpg")).getImage();
		Image z=img1.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight() ,Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(z));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 329, 191, 200);
		Image img=new ImageIcon(this.getClass().getResource("/order2.jpg")).getImage();
		Image y=img.getScaledInstance(lblNewLabel_3.getWidth(),lblNewLabel_3.getHeight() ,Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(y));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		dispose();
		Adminpage adp=new Adminpage();
		adp.setVisible(true);
		}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(819, 61, 124, 36);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(355, 131, 673, 367);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookstore?useTimezone=true&serverTimezone=UTC","root","");
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.addColumn("ORDERID");
		dtm.addColumn("USERNAME");
		dtm.addColumn("TITLE");
		dtm.addColumn("AUTHOR");
		dtm.addColumn("GENRE");
		dtm.addColumn("QUANTITY");
		dtm.addColumn("PRICE");
		dtm.addColumn("DATE");

		String sql="select orderid,username,title,author,genre,quantity,price,date from orderdb";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rss=ps.executeQuery();
		while(rss.next()) {
		dtm.addRow(new Object[] {rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6),rss.getString(7),rss.getString(8)});
		}
		rss.close();
		ps.close();
		table.setModel(dtm);
		table.setAutoResizeMode(0);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(142);
		table.getColumnModel().getColumn(1).setPreferredWidth(142);
		table.getColumnModel().getColumn(2).setPreferredWidth(142);
		}
		catch(Exception ee) {
		System.out.print(ee);
		}
	}

}
