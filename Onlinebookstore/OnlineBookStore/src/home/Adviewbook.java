package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Adviewbook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adviewbook frame = new Adviewbook();
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
	public Adviewbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(224, 11, 342, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("LIST OF BOOKS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(234, 52, 306, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblimg = new JLabel("");
		lblimg.setBounds(25, 134, 210, 217);
		Image img6=new ImageIcon(this.getClass().getResource("/edits.jpg")).getImage();
		Image z=img6.getScaledInstance(lblimg.getWidth(),lblimg.getHeight() ,Image.SCALE_SMOOTH);
		lblimg.setIcon(new ImageIcon(z));
		contentPane.add(lblimg, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 95, 511, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Onlinebookstore?useTimezone=true&serverTimezone=UTC","root","");
			DefaultTableModel dtm=new DefaultTableModel();
			dtm.addColumn("BOOKID");
			dtm.addColumn("TITLE");
			dtm.addColumn("AUTHOR");
			dtm.addColumn("GENRE");
			dtm.addColumn("QUANTITY");
			dtm.addColumn("PRICE");
			dtm.addColumn("RATING");
			String sql="select * from books";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rss=ps.executeQuery();
			while(rss.next()) {
				dtm.addRow(new Object[] {rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6),rss.getString(7)});
			}
			rss.close();
			ps.close();
			table.setModel(dtm);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(162);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(62);
			table.getColumnModel().getColumn(5).setPreferredWidth(52);
			table.getColumnModel().getColumn(6).setPreferredWidth(52);

			}
			catch(Exception ee) {
				System.out.print(ee);
			}
		
		JButton btnNewButton = new JButton("Go to admin page");
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
		btnNewButton.setBounds(287, 427, 205, 23);
		contentPane.add(btnNewButton);
	}

}
