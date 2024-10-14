```markdown
# Java Quiz Application

## Overview
This is a simple quiz application built using **Java Swing**. The application presents a series of multiple-choice questions and allows users to select their answers, proceed to the next question, and submit their final score. The application consists of a **Quiz** and **Rules** screen, along with a set of predefined questions and answers.

## Features
- **Dark theme** for the entire application interface.
- Multiple-choice questions with four options.
- Track and display the user's **score** at the end of the quiz.
- **Submit** the quiz at any point to see the final score.
- **User-friendly rules** page with a fun, interactive description of the quiz rules.

## How to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/Normie69K/Quizzz.git
   cd Quizzz
   ```

2. Compile the Java source files:
   ```bash
   javac Quiz.java Rules.java login.java
   ```

3. Run the application:
   ```bash
   java login
   ```

## Screens

### 1. Login Screen:
- Users enter their name and password.
- After successful login, the quiz rules are displayed.

### 2. Quiz Screen:
- Displays the current question number.
- Shows a multiple-choice question with four options.
- **Next** button to move to the next question.
- **Submit** button to finish the quiz and display the final score.

### 3. Rules Screen:
- Displays a set of fun rules before starting the quiz.
- User can go back or start the quiz from here.

## Code Structure

### Classes:
- **Login**:Handles the login process and redirects to the quiz or rules screen.
- **Quiz**: The main class responsible for displaying the questions, handling button actions, and tracking the user's progress and score.
- **Rules**: A separate window that explains the rules of the quiz in a humorous tone before the quiz begins.

### Methods:
- `initializeQuestions()`: Initializes the questions and answers for the quiz.
- `showQuestion(int index)`: Displays the current question and updates the options.
- `actionPerformed(ActionEvent e)`: Handles button actions like moving to the next question and submitting the quiz.

## Technologies Used
- **Java Swing**: For the graphical user interface (GUI).
- **JButton**, **JLabel**, **JRadioButton**, and **JTextArea**: Used for creating interactive elements.
- **ButtonGroup**: Groups the multiple-choice options.
- **JOptionPane**: To display messages like the final score or prompts.

## Future Enhancements
- **Timer**: Add a timer for each question.
- **Dynamic Question Loading**: Load questions from an external file or database.
- **Scoreboard**: Track and display the high scores of users.
  
## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Authors
- **Karan Singh** - Initial work on the project.
```

You can modify the `git clone` URL and other details as needed. Let me know if you'd like to add more sections or have any specific details to include!
