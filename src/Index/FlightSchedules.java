package Index;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FlightSchedules extends JFrame {
	ImageIcon imgbg = new ImageIcon("C:/Users/ACER/eclipse-workspace/BookSky/src/Index/img/Find Your Flight.png");
	JLabel bg = new JLabel(imgbg);
	
	JFrame f = new JFrame("Lịch Bay");
	
	public FlightSchedules() {
		f.add(bg);
		bg.setLayout(new FlowLayout());
		
		f.setSize(1400,800);
		f.setLayout(new GridLayout(1,0));
		f.setLocation(80,0);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new FlightSchedules();
	}

}
