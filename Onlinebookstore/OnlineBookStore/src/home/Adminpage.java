package home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminpage frame = new Adminpage();
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
	public Adminpage() {
		
setBackground(new Color(0, 0, 0));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 990, 735);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 0, 0));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("ONLINE BOOK STORE");
lblNewLabel.setBounds(201, 10, 553, 31);
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setForeground(new Color(204, 255, 255));
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("ADMINISTRATOR PAGE");
lblNewLabel_1.setBounds(265, 43, 391, 23);
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setForeground(new Color(255, 255, 51));
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Welcome Admin :) You can control any of these activities !");
lblNewLabel_2.setBounds(45, 87, 721, 23);
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_2.setForeground(new Color(255, 255, 255));
contentPane.add(lblNewLabel_2);

JLabel lblimgvb = new JLabel("");
lblimgvb.setBounds(57, 131, 225, 183);
Image img=new ImageIcon(this.getClass().getResource("/viewbook.jpg")).getImage();
Image u=img.getScaledInstance(lblimgvb.getWidth(),lblimgvb.getHeight() ,Image.SCALE_SMOOTH);
lblimgvb.setIcon(new ImageIcon(u));
contentPane.add(lblimgvb);

JLabel lblimgab = new JLabel("");
lblimgab.setBounds(711, 143, 225, 183);
Image img2=new ImageIcon(this.getClass().getResource("/addbook.jpg")).getImage();
Image v=img2.getScaledInstance(lblimgab.getWidth(),lblimgab.getHeight() ,Image.SCALE_SMOOTH);
lblimgab.setIcon(new ImageIcon(v));
contentPane.add(lblimgab);

JLabel lblimgdb = new JLabel("");
lblimgdb.setBounds(375, 143, 225, 183);
Image img3=new ImageIcon(this.getClass().getResource("/delbook.jpg")).getImage();
Image w=img3.getScaledInstance(lblimgdb.getWidth(),lblimgdb.getHeight() ,Image.SCALE_SMOOTH);
lblimgdb.setIcon(new ImageIcon(w));
contentPane.add(lblimgdb);

JLabel lblimgvu = new JLabel("");
lblimgvu.setBounds(45, 418, 225, 183);
Image img4=new ImageIcon(this.getClass().getResource("/viewusers.png")).getImage();
Image x=img4.getScaledInstance(lblimgvu.getWidth(),lblimgvu.getHeight() ,Image.SCALE_SMOOTH);
lblimgvu.setIcon(new ImageIcon(x));
contentPane.add(lblimgvu);

JLabel lblimgvo = new JLabel("");
lblimgvo.setBounds(375, 418, 225, 183);
Image img5=new ImageIcon(this.getClass().getResource("/v1.jpg")).getImage();
Image y=img5.getScaledInstance(lblimgvo.getWidth(),lblimgvo.getHeight() ,Image.SCALE_SMOOTH);
lblimgvo.setIcon(new ImageIcon(y));
contentPane.add(lblimgvo);

JLabel lblimges = new JLabel("");
lblimges.setBounds(711, 418, 225, 183);
Image img6=new ImageIcon(this.getClass().getResource("/edits.jpg")).getImage();
Image z=img6.getScaledInstance(lblimges.getWidth(),lblimges.getHeight() ,Image.SCALE_SMOOTH);
lblimges.setIcon(new ImageIcon(z));
contentPane.add(lblimges);

JButton btnvb = new JButton("View Books");
btnvb.setBounds(78, 336, 167, 31);
btnvb.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try{
dispose();
Adviewbook adv=new Adviewbook();
adv.setVisible(true);
}
catch(Exception e1) {
System.out.print(e1);
}}
});
btnvb.setFont(new Font("Tahoma", Font.BOLD, 17));
contentPane.add(btnvb);

JButton btndb = new JButton("Delete a Book");
btndb.setBounds(408, 336, 167, 31);
btndb.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			dispose();
			Addelbook adb=new Addelbook();
			adb.setVisible(true);
		}
		catch(Exception ee) {
			System.out.print(ee);
		}
	}
});
btndb.setFont(new Font("Tahoma", Font.BOLD, 17));
contentPane.add(btndb);

JButton btnab = new JButton("Add a Book");
btnab.setBounds(741, 336, 167, 31);
btnab.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	dispose();
Addabook adb=new Addabook();
adb.setVisible(true);
}
});
btnab.setFont(new Font("Tahoma", Font.BOLD, 17));
contentPane.add(btnab);

JButton btnvu = new JButton("View Users");
btnvu.setBounds(78, 618, 167, 31);
btnvu.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
dispose();
Adviewusers avu=new Adviewusers();
avu.setVisible(true);
}
catch(Exception ee) {
System.out.print(ee);
}
}
});
btnvu.setFont(new Font("Tahoma", Font.BOLD, 17));
contentPane.add(btnvu);


JButton btnvo = new JButton("View Orders");
btnvo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
Advieworders ado=new Advieworders();
ado.setVisible(true);
}
});
btnvo.setBounds(408, 618, 167, 31);
btnvo.setFont(new Font("Tahoma", Font.BOLD, 17));
contentPane.add(btnvo);

JButton btnes = new JButton("Edit Stock");
btnes.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
Editstock eds=new Editstock();
eds.setVisible(true);

}
});
btnes.setBounds(741, 618, 167, 31);
btnes.setFont(new Font("Tahoma", Font.BOLD, 17));
contentPane.add(btnes);

JButton btnNewButton = new JButton("Logout");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			dispose();
			Adminlogin al=new Adminlogin();
			al.setVisible(true);
		}
		catch(Exception ee) {
			System.out.print(ee);
		}

	}
});
btnNewButton.setBounds(875, 10, 89, 23);
contentPane.add(btnNewButton);
	}
}
