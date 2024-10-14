import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    
    JLabel qno;
    JTextArea question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    JButton next, submit;
    int count = 0; // Track the current question index
    int score = 0; // Track the user's score

    // Sample questions and answers
    String[][] questions = new String[10][5];
    String[] answers = new String[10]; // Store correct answers in a separate array

    public Quiz() {

        // Initialize the questions and answers
        initializeQuestions();

        // Set the frame size and background color
        setSize(400, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        // Question Number Label
        qno = new JLabel();
        qno.setBounds(20, 20, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setForeground(Color.WHITE);
        add(qno);

        // Initialize the question JTextArea
        question = new JTextArea();
        question.setBounds(20, 60, 350, 60);
        question.setFont(new Font("Tahoma", Font.PLAIN, 18));
        question.setForeground(Color.WHITE);
        question.setBackground(new Color(30, 30, 30));
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setOpaque(false);
        question.setEditable(false);
        add(question);

        // Options Radio Buttons
        opt1 = new JRadioButton();
        opt1.setBounds(20, 130, 350, 30);
        opt1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        opt1.setForeground(Color.WHITE);
        opt1.setBackground(new Color(30, 30, 30));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(20, 160, 350, 30);
        opt2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        opt2.setForeground(Color.WHITE);
        opt2.setBackground(new Color(30, 30, 30));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(20, 190, 350, 30);
        opt3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        opt3.setForeground(Color.WHITE);
        opt3.setBackground(new Color(30, 30, 30));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(20, 220, 350, 30);
        opt4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        opt4.setForeground(Color.WHITE);
        opt4.setBackground(new Color(30, 30, 30));
        add(opt4);

        // Button Group for Options
        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        // Set action commands for each option
        opt1.setActionCommand(questions[0][1]);
        opt2.setActionCommand(questions[0][2]);
        opt3.setActionCommand(questions[0][3]);
        opt4.setActionCommand(questions[0][4]);

        // Next Button
        next = new JButton("Next");
        next.setBounds(20, 280, 100, 40);
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.addActionListener(this);
        add(next);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(130, 280, 100, 40);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.addActionListener(this);
        add(submit);

        // Start the quiz
        showQuestion(count);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method to initialize the questions and answers
    private void initializeQuestions() {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        // Correct answers
        answers[0] = "JDB";
        answers[1] = "int";
        answers[2] = "java.util package";
        answers[3] = "Marker Interface";
        answers[4] = "Heap memory";
        answers[5] = "Remote interface";
        answers[6] = "import";
        answers[7] = "Java Archive";
        answers[8] = "java.lang.StringBuilder";
        answers[9] = "Bytecode is executed by JVM";
    }

    // Method to display the current question
    private void showQuestion(int index) {
        qno.setText("Q" + (index + 1));
        question.setText(questions[index][0]);
        opt1.setText(questions[index][1]);
        opt2.setText(questions[index][2]);
        opt3.setText(questions[index][3]);
        opt4.setText(questions[index][4]);

        // Update action commands for options
        opt1.setActionCommand(questions[index][1]);
        opt2.setActionCommand(questions[index][2]);
        opt3.setActionCommand(questions[index][3]);
        opt4.setActionCommand(questions[index][4]);
        
        options.clearSelection(); // Clear the previous selection
    }

    // Method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            // Check if an option is selected
            if (options.getSelection() != null) {
                String selectedAnswer = options.getSelection().getActionCommand(); // Get the selected answer
                if (selectedAnswer.equals(answers[count])) {
                    score++; // Increase score if the answer is correct
                }
                count++; // Move to the next question
                if (count < questions.length) {
                    showQuestion(count); // Show the next question
                } else {
                    JOptionPane.showMessageDialog(this, "Quiz completed! Your score: " + score);
                    System.exit(0); // End the quiz
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an option."); // Prompt user to select an option
            }
        } else if (e.getSource() == submit) {
            // Show the final score on submit
            JOptionPane.showMessageDialog(this, "Dear score: " + score);
            System.exit(0); // End the quiz
        }
    }

    public static void main(String[] args) {
        new Quiz(); // Start the quiz application
    }
}
