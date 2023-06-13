package Index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Point;

public class ShowFlight extends JFrame {
	ImageIcon imgbg = new ImageIcon("C:/Users/ACER/eclipse-workspace/BookSky/src/Index/img/Find Your Flight.png");
	JLabel bg = new JLabel(imgbg);
	
	JFrame f = new JFrame("ĐẶT VÉ MÁY BAY");
//	JLabel lbl = new JLabel("BOOK YOUR FLIGHT TODAY",  SwingConstants.CENTER);
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel subp1 = new JPanel();
	JPanel subp2 = new JPanel();
	JPanel subp3 = new JPanel();
	JPanel subp4 = new JPanel();
	JPanel subp5 = new JPanel();
	JPanel subp6 = new JPanel();
	JPanel subp7 = new JPanel();
	JPanel pcbo = new JPanel();
	JPanel prdo = new JPanel();
	JPanel ptf1 = new JPanel();
	JPanel ptf2 = new JPanel();
	JPanel pbt = new JPanel();
	
	JRadioButton rdotrip = new JRadioButton("Roundtrip");
    JRadioButton rdoway = new JRadioButton("One way");
    JRadioButton rdocity = new JRadioButton("Multi-City");
    ButtonGroup genderGroup = new ButtonGroup();
    JLabel lblfrom = new JLabel("Flying From");
    JLabel lblto = new JLabel("Flying To");
    JLabel lblde = new JLabel("Departing");
    JLabel lblre = new JLabel("Returning");
    JLabel lblad = new JLabel("Adults");
    JLabel lblchil = new JLabel("Children");
    JLabel lbltv = new JLabel("Travel class");
    
    JTextField tfde = new JTextField();
    JTextField tfre = new JTextField();
    JTextField tfad = new JTextField("1");
    JTextField tfchil = new JTextField("0");
    JTextField tftv = new JTextField("Economy class");
    
    String[] from = {"Anywhere","An Giang", "Bà Rịa-Vũng Tàu","Bắc Giang","Bắc Kạn","Bạc Liêu",
			"Bắc Ninh","Bến Tre","Bình Định","Bình Dương","Bình Phước","Bình Thuận","Cà Mau",
			"Cần Thơ","Cao Bằng","Đà Nẵng","Đắk Lắk","Đắk Nông","Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai",
			"Hà Giang","Hà Nam","Hà Nội","Hà Tĩnh","Hải Dương","Hải Phòng","Hậu Giang","Hòa Bình","Hưng Yên","Khánh Hòa",
			"Kiên Giang","Kon Tum","Lai Châu","Lâm Đồng","Lạng Sơn","Lào Cai","Long An","Nam Định","Nghệ An","Ninh Bình",
			"Ninh Thuận","Phú Thọ","Phú Yên","Quảng Bình","Quảng Nam","Quảng Ngãi","Quảng Ninh","Quảng Trị","Sóc Trăng","Sơn La",
			"Tây Ninh","Thái Bình","Thái Nguyên","Thanh Hóa","Thừa Thiên Huế","Tiền Giang","TP Hồ Chí Minh","Trà Vinh","Tuyên Quang",
			"Vĩnh Long","Vĩnh Phúc","Yên Bái"};
    String[] to = {"Any city","An Giang", "Bà Rịa-Vũng Tàu","Bắc Giang","Bắc Kạn","Bạc Liêu",
			"Bắc Ninh","Bến Tre","Bình Định","Bình Dương","Bình Phước","Bình Thuận","Cà Mau",
			"Cần Thơ","Cao Bằng","Đà Nẵng","Đắk Lắk","Đắk Nông","Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai",
			"Hà Giang","Hà Nam","Hà Nội","Hà Tĩnh","Hải Dương","Hải Phòng","Hậu Giang","Hòa Bình","Hưng Yên","Khánh Hòa",
			"Kiên Giang","Kon Tum","Lai Châu","Lâm Đồng","Lạng Sơn","Lào Cai","Long An","Nam Định","Nghệ An","Ninh Bình",
			"Ninh Thuận","Phú Thọ","Phú Yên","Quảng Bình","Quảng Nam","Quảng Ngãi","Quảng Ninh","Quảng Trị","Sóc Trăng","Sơn La",
			"Tây Ninh","Thái Bình","Thái Nguyên","Thanh Hóa","Thừa Thiên Huế","Tiền Giang","TP Hồ Chí Minh","Trà Vinh","Tuyên Quang",
			"Vĩnh Long","Vĩnh Phúc","Yên Bái"};
    JComboBox cbofrom = new JComboBox(from);
    JComboBox cboto = new JComboBox(to);
    
    JButton btfly = new JButton("SHOW FLIGHTS");
    
    Color transColor = new Color(255, 255, 255, 0); //màu trong suốt
    
	public ShowFlight() {
		f.add(bg);
		bg.setLayout(new GridLayout(2,2));
		bg.add(p3);	
		bg.add(p4);		
		bg.add(p1);	
		bg.add(p2);
		
//		lbl.setForeground(Color.BLUE);
//		lbl.setFont(new Font("Arial",Font.BOLD, 25));
				
		p1.setBackground(transColor);
//		p1.add(lbl);		
		
		p2.setPreferredSize(new Dimension(600,300)); //thay doi size
		p2.setBackground(transColor);
		
		p3.setBackground(transColor);
		p4.setBackground(transColor);
		
		p2.add(prdo);		
		p2.add(pcbo);
		p2.add(ptf1);
		p2.add(ptf2);
		p2.add(pbt);
		
		prdo.setBackground(Color.WHITE);
		pbt.setBackground(Color.WHITE);	
		subp1.setBackground(Color.WHITE);
		subp2.setBackground(Color.WHITE);
		subp3.setBackground(Color.WHITE);
		subp4.setBackground(Color.WHITE);
		subp5.setBackground(Color.WHITE);
		subp6.setBackground(Color.WHITE);
		subp7.setBackground(Color.WHITE);
		
		
		p2.setLayout(new GridLayout(9,1));		
		pcbo.setLayout(new GridLayout(1,4));
		ptf1.setLayout(new GridLayout(1,1));
		ptf2.setLayout(new GridLayout(1,1));
		
		
		prdo.add(rdotrip);
		genderGroup.add(rdotrip);
		prdo.add(rdoway);
		genderGroup.add(rdoway);	
		prdo.add(rdocity);
		genderGroup.add(rdocity);
		
		rdotrip.setBackground(Color.WHITE);
		rdoway.setBackground(Color.WHITE);
		rdocity.setBackground(Color.WHITE);
		
		//panel chính thể hiện dưới dạng GridLayout	
		//tạo sub-panel chứa label để căn giữa label dựa trên FlowLayout của sub-panel
		subp1.add(lblfrom);
		pcbo.add(subp1);		
		pcbo.add(cbofrom);
		cbofrom.setBackground(Color.WHITE);
		
		subp2.add(lblto);
		pcbo.add(subp2);
		pcbo.add(cboto);
		cboto.setBackground(Color.WHITE);
		
		subp3.add(lblde);		
		ptf1.add(subp3);
		ptf1.add(tfde);
		tfde.setPreferredSize(new Dimension(100,20));
		
		subp4.add(lblre);
		ptf1.add(subp4);
		ptf1.add(tfre);
		tfre.setPreferredSize(new Dimension(100,20));
		
		subp5.add(lblad);
		ptf2.add(subp5);
		ptf2.add(tfad);
		tfad.setPreferredSize(new Dimension(100,5));
		
		subp6.add(lblchil);
		ptf2.add(subp6);
		ptf2.add(tfchil);
		tfchil.setPreferredSize(new Dimension(100,5));
		
		subp7.add(lbltv);
		ptf2.add(subp7);
		ptf2.add(tftv);
		tftv.setPreferredSize(new Dimension(100,5));
		
		pbt.add(btfly);
		btfly.setBackground(new Color(51, 102, 204));
		btfly.setForeground(new Color(255, 255, 255));
		btfly.setFont(new Font("Arial",Font.BOLD, 18));
		
		f.setSize(1400,800);
		f.setLayout(new GridLayout(1,0));
		f.setLocation(80,0);
		f.setVisible(true);
		
		
	}
	public static void main(String[] args) {	
		new ShowFlight();
	}
}
