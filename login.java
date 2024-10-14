import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class login extends JFrame implements ActionListener {

    JButton next;
    JTextField tfname;

    public login() {
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        Font customFont = loadFont("src/fonts/AfacadFlux-Regular.ttf", 40);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/assets/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 300, 150);
        add(image);

        // Label
        JLabel heading = new JLabel("Quizzz");
        heading.setBounds(350, 220, 300, 45);
        heading.setFont(customFont.deriveFont(Font.BOLD, 40));
        heading.setForeground(new Color(255, 165, 0));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Label
        JLabel name = new JLabel("Enter your name");
        name.setBounds(350, 300, 300, 20);
        name.setFont(customFont.deriveFont(Font.BOLD, 18));
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        add(name);

        // Textfield
        tfname = new JTextField();
        tfname.setBounds(350, 330, 300, 25);
        tfname.setFont(new Font("AfacadFlux-Light", Font.BOLD, 20));
        add(tfname);

        next = createStyledButton("Next", 440, 370);
        next.addActionListener(this); // Add action listener to the button
        add(next);

        setSize(1000, 600);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Font loadFont(String path, float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            return font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Serif", Font.PLAIN, (int) size);
        }
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 25);
        button.setBackground(new Color(255, 165, 0));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("AfacadFlux-Regular", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 140, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 165, 0));
            }
        });

        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name = tfname.getText();
            setVisible(false); // Hide current window
            new Rules(name); // Open the Rules page
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
