package home;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adviewusers extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adviewusers frame = new Adviewusers();
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
	public Adviewusers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(151, 11, 496, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LIST OF USERS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(254, 53, 306, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(10, 155, 288, 175);
		Image img=new ImageIcon(this.getClass().getResource("/enduser.jpg")).getImage();
		lblimg.setIcon(new ImageIcon(img));
		contentPane.add(lblimg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 131, 426, 247);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Onlinebookstore?useTimezone=true&serverTimezone=UTC","root","");
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.addColumn("USERNAME");
		dtm.addColumn("MOBILE NO");
		dtm.addColumn("EMAIL ID");
		String sql="select username,mobile,email from userdb";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rss=ps.executeQuery();
		while(rss.next()) {
			dtm.addRow(new Object[] {rss.getString(1),rss.getString(2),rss.getString(3)});
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
		
		JLabel lblNewLabel_2 = new JLabel("(Only for Admins)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(304, 87, 209, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Go to Admin Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Adminpage add=new Adminpage();
					add.setVisible(true);
				}
				catch(Exception ee) {
					System.out.print(ee);
				}
			}
		});
		btnNewButton.setBounds(304, 394, 168, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
