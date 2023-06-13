package Index;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class Login extends JFrame {
	ImageIcon imgbg = new ImageIcon("C:/Users/ACER/eclipse-workspace/BookSky/src/Index/img/Find Your Flight.png");
	JLabel bg = new JLabel(new ImageIcon("C:/Users/ACER/eclipse-workspace/BookSky/src/Index/img/Find Your Flight.png"));
	
	JFrame f = new JFrame("ĐĂNG NHẬP");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel subp1 = new JPanel();
	JPanel subp2 = new JPanel();
	JPanel subp3 = new JPanel();
	JPanel subp4 = new JPanel();

	JLabel lbsigh = new JLabel("ĐĂNG NHẬP");
	JLabel lbname = new JLabel("Tên đăng nhập");
	JTextField tfname = new JTextField();
	JLabel lbpass = new JLabel("Mật khẩu");
	JTextField tfpass = new JTextField();
	
	JButton btsigh = new JButton("Đăng nhập");
	
    Color transColor = new Color(255, 255, 255, 0); //màu trong suốt
    
	public Login() {
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
		f.getContentPane().add(bg);
		bg.setLayout(new GridLayout(2,2));

		f.getContentPane().add(bg);
		bg.setLayout(new GridLayout(2,2));
		bg.add(p3);	
		bg.add(p4);		
		bg.add(p1);	
		bg.add(p2);
		
		p1.setBackground(transColor);
//		p1.add(lbl);		
		
		p2.setPreferredSize(new Dimension(600,300)); //thay doi size
		p2.setBackground(transColor);
		p2.setLayout(new GridLayout(6, 0));
		
		p3.setBackground(transColor);
		p4.setBackground(transColor);
		
		p2.add(subp1);
		p2.add(subp2);
		p2.add(subp3);
		p2.add(subp4);
		
		subp1.add(lbsigh);
		subp1.setBackground(Color.WHITE);
		lbsigh.setFont(new Font("Arial", Font.BOLD, 25));
		
		subp2.setBackground(Color.WHITE);
		subp2.add(lbname);
		subp2.add(tfname);
		tfname.setPreferredSize(new Dimension(250,25));
		
		subp3.setBackground(Color.WHITE);
		subp3.add(lbpass);
		subp3.add(tfpass);
		tfpass.setPreferredSize(new Dimension(250,25));
		
		subp4.setBackground(Color.WHITE);
		subp4.add(btsigh);
		btsigh.setBackground(new Color(51, 102, 204));
		btsigh.setForeground(new Color(255, 255, 255));
		btsigh.setFont(new Font("Arial",Font.BOLD, 18));
		

		btsigh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/customer?useSSL=false";
				String user = "root";
				String password = "123456789";
				try {Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				String sql = "SELECT * FROM ta_use_user\n" + "WHERE T_LOGIN = ? AND T_PASS = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, tfname.getText());
				ps.setString(2, tfpass.getText());

				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, new ShowFlight());
				}
				else {
					JOptionPane.showMessageDialog(null, "Đăng nhập không thành công!");
				}
				conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		f.setSize(1400,800);
		f.getContentPane().setLayout(new GridLayout(1,0));
		f.setLocation(80,0);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}
}
