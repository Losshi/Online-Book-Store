package home;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 51));
		panel.setBounds(0, 0, 298, 375);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 300, 300);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		Image img=new ImageIcon(this.getClass().getResource("/bg201.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TODAY A READER ..");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 323, 185, 24);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("TOMORROW A LEADER..");
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		lblNewLabel_3.setBounds(40, 342, 207, 24);
		panel.add(lblNewLabel_3);

		Button button = new Button("REGISTER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Register r=new Register();
					r.setVisible(true);
				}
				catch(Exception em) {
					System.out.println(em);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241,57,83));
		button.setBounds(330, 93, 230, 48);
		contentPane.add(button);

		Button button_1 = new Button("LOGIN AS ADMIN");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Adminlogin al=new Adminlogin();
					al.setVisible(true);
				}
				catch(Exception em) {
					System.out.println(em);
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(241, 57, 83));
		button_1.setBounds(330, 168, 230, 48);
		contentPane.add(button_1);

		Button button_2 = new Button("LOGIN AS USER");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Userlogin ul=new Userlogin();
					ul.setVisible(true);
				}
				catch(Exception em) {
					System.out.println(em);
				}
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(241, 57, 83));
		button_2.setBounds(330, 247, 230, 48);
		contentPane.add(button_2);

		JLabel lblNewLabel_2 = new JLabel("WELCOME TO ONLINE BOOK STORE");
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 13));
		lblNewLabel_2.setBounds(319, 22, 310, 48);
		contentPane.add(lblNewLabel_2);
	}

}
