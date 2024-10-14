import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(30, 30, 30)); // Dark background
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Quizz");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        heading.setForeground(new Color(255, 165, 0)); // Orange color for the heading
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(Color.WHITE); // White text color
        rules.setText(
            "<html>" +
                "1. This is a quiz, not a comedy show—keep your punchlines for later!" + "<br><br>" +
                "2. No looking at your neighbor’s screen; they might be Googling the answers!" + "<br><br>" +
                "3. If you don't know the answer, just guess. It’s not like the quiz police are watching!" + "<br><br>" +
                "4. Feel free to cry if you get a question wrong, but no loud sobbing, please." + "<br><br>" +
                "5. If your brain goes blank, just smile and nod; it works in interviews too!" + "<br><br>" +
                "6. Remember, every answer counts—unless it’s an answer to a different quiz." + "<br><br>" +
                "7. This quiz is like a buffet; take what you can handle, but don’t overeat!" + "<br><br>" +
                "8. May your knowledge be deeper than your social media scroll! Good Luck!" + "<br><br>" +
            "<html>"
        );
        add(rules);

        // Center the buttons below the rules
        back = createStyledButton("Back", 250, 500);
        add(back);

        start = createStyledButton("Start", 400, 500);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added close operation
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        button.setBackground(new Color(255, 165, 0)); // Orange button
        button.setForeground(Color.BLACK); // Black text on button
        button.setFont(new Font("Afacad Flux", Font.BOLD, 16)); // Set font to Afacad Flux
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true)); // Rounded corners
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Mouse hover effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 140, 0)); // Darker orange on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 165, 0)); // Reset to original color
            }
        });

        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz();
        } else {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
