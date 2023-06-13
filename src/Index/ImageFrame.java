package Index;

import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {
    public ImageFrame() {
        JPanel panel = new JPanel();

        // Đặt màu nền cho JPanel để phân biệt với JFrame
        panel.setBackground(Color.YELLOW);

        // Đặt layout của JPanel thành GridBagLayout
        panel.setLayout(new GridBagLayout());

        // Tạo một GridBagConstraints để định vị trí và căn chỉnh của JPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Cột thứ nhất
        gbc.gridy = 0; // Hàng thứ nhất
        gbc.fill = GridBagConstraints.BOTH; // Điền cả chiều ngang và chiều dọc
        gbc.insets = new Insets(10, 10, 10, 10); // Đặt lề top, left, bottom, right

        // Thêm JPanel vào GridBagConstraints
        add(panel, gbc);

        // Cấu hình các thuộc tính của JFrame
        setTitle("GridLayout with Insets Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị JFrame ở giữa màn hình
    }

    public static void main(String[] args) {
        ImageFrame frame = new ImageFrame();
        frame.setVisible(true);
    }
}