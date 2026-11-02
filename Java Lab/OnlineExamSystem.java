import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineExamSystem extends JFrame implements ActionListener {

    private final String examTitle = "Java Programming Certification Assessment";
    private final String studentName = "Pushkar Raj";
    private final String studentRollNo = "2024CS-101";
    private final String studentDepartment = "Computer Science & Engineering";

    private static class Question {
        String questionText;
        String[] options;
        int correctOptionIndex;

        Question(String q, String[] opts, int correctIdx) {
            this.questionText = q;
            this.options = opts;
            this.correctOptionIndex = correctIdx;
        }
    }

    private final Question[] questions = {
        new Question(
            "1. What is the entry point method for executing a standalone Java application?",
            new String[]{"public void start()", "public static void main(String[] args)", "public void run()", "public static void init()"},
            1
        ),
        new Question(
            "2. Which keyword is used in Java to achieve class inheritance?",
            new String[]{"implements", "inherits", "extends", "import"},
            2
        ),
        new Question(
            "3. Which Swing component is designed to accept a single line of editable user text?",
            new String[]{"JTextArea", "JLabel", "JTextField", "JPasswordField"},
            2
        ),
        new Question(
            "4. What is the default layout manager for a standard JFrame's content pane?",
            new String[]{"FlowLayout", "BorderLayout", "GridLayout", "GridBagLayout"},
            1
        ),
        new Question(
            "5. Which exception is thrown when attempting to access an invalid index in an array?",
            new String[]{"NullPointerException", "ArithmeticException", "ArrayIndexOutOfBoundsException", "IllegalArgumentException"},
            2
        )
    };

    private int currentIndex = 0;
    private final int[] userSelectedAnswers;
    private boolean isSubmitted = false;

    private JLabel lblExamHeader;
    private JLabel lblStudentInfo;
    private JLabel lblQuestionNumber;
    private JLabel lblQuestionText;
    private JRadioButton[] radioOptions;
    private ButtonGroup optionButtonGroup;
    private JButton btnPrev, btnNext, btnSubmit;
    private JLabel lblProgressStatus;

    public OnlineExamSystem() {
        userSelectedAnswers = new int[questions.length];
        for (int i = 0; i < userSelectedAnswers.length; i++) {
            userSelectedAnswers[i] = -1;
        }

        setTitle("Online Examination System - " + examTitle);
        setSize(780, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        headerPanel.setBackground(new Color(33, 47, 61));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));

        lblExamHeader = new JLabel("📝 " + examTitle, JLabel.CENTER);
        lblExamHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblExamHeader.setForeground(Color.WHITE);

        lblStudentInfo = new JLabel("Candidate: " + studentName + "  |  Roll No: " + studentRollNo + "  |  Dept: " + studentDepartment, JLabel.CENTER);
        lblStudentInfo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblStudentInfo.setForeground(new Color(213, 219, 219));

        headerPanel.add(lblExamHeader);
        headerPanel.add(lblStudentInfo);
        add(headerPanel, BorderLayout.NORTH);

        JPanel questionCard = new JPanel(new BorderLayout(10, 15));
        questionCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 30, 10, 30),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                        BorderFactory.createEmptyBorder(20, 25, 20, 25)
                )
        ));

        JPanel qTitlePanel = new JPanel(new BorderLayout(5, 5));
        lblQuestionNumber = new JLabel("Question 1 of " + questions.length);
        lblQuestionNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblQuestionNumber.setForeground(new Color(41, 128, 185));

        lblQuestionText = new JLabel(questions[0].questionText);
        lblQuestionText.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblQuestionText.setForeground(new Color(44, 62, 80));

        qTitlePanel.add(lblQuestionNumber, BorderLayout.NORTH);
        qTitlePanel.add(lblQuestionText, BorderLayout.CENTER);
        questionCard.add(qTitlePanel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 8, 12));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        radioOptions = new JRadioButton[4];
        optionButtonGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            radioOptions[i] = new JRadioButton();
            radioOptions[i].setFont(new Font("Segoe UI", Font.PLAIN, 15));
            radioOptions[i].setFocusPainted(false);
            radioOptions[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            radioOptions[i].addActionListener(this);
            optionButtonGroup.add(radioOptions[i]);
            optionsPanel.add(radioOptions[i]);
        }

        questionCard.add(optionsPanel, BorderLayout.CENTER);

        lblProgressStatus = new JLabel("Question 1 of 5 | Select an answer and click Next", JLabel.CENTER);
        lblProgressStatus.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblProgressStatus.setForeground(Color.GRAY);
        questionCard.add(lblProgressStatus, BorderLayout.SOUTH);

        add(questionCard, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        JPanel navButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 5));

        btnPrev = new JButton("◀ Previous");
        styleButton(btnPrev, new Color(52, 73, 94));
        btnPrev.setEnabled(false);

        btnNext = new JButton("Next ▶");
        styleButton(btnNext, new Color(41, 128, 185));

        btnSubmit = new JButton("Submit Examination ✔");
        styleButton(btnSubmit, new Color(39, 174, 96));

        navButtonPanel.add(btnPrev);
        navButtonPanel.add(btnNext);
        navButtonPanel.add(btnSubmit);

        bottomPanel.add(navButtonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadQuestion(0);
    }

    private void styleButton(JButton btn, Color bg) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(180, 42));
        btn.addActionListener(this);
    }

    private void saveCurrentSelection() {
        for (int i = 0; i < 4; i++) {
            if (radioOptions[i].isSelected()) {
                userSelectedAnswers[currentIndex] = i;
                return;
            }
        }
        userSelectedAnswers[currentIndex] = -1;
    }

    private void loadQuestion(int index) {
        currentIndex = index;
        Question q = questions[index];

        lblQuestionNumber.setText("Question " + (index + 1) + " of " + questions.length);
        lblQuestionText.setText("<html>" + q.questionText + "</html>");

        optionButtonGroup.clearSelection();

        for (int i = 0; i < 4; i++) {
            radioOptions[i].setText(q.options[i]);
            if (userSelectedAnswers[index] == i) {
                radioOptions[i].setSelected(true);
            }
        }

        btnPrev.setEnabled(index > 0);
        btnNext.setEnabled(index < questions.length - 1);

        int answeredCount = getAnsweredCount();
        lblProgressStatus.setText("Viewing Question " + (index + 1) + " of " + questions.length +
                "  |  Attempted: " + answeredCount + " of " + questions.length);
    }

    private int getAnsweredCount() {
        int count = 0;
        for (int ans : userSelectedAnswers) {
            if (ans != -1) count++;
        }
        return count;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (int i = 0; i < 4; i++) {
            if (source == radioOptions[i]) {
                userSelectedAnswers[currentIndex] = i;
                lblProgressStatus.setText("Viewing Question " + (currentIndex + 1) + " of " + questions.length +
                        "  |  Attempted: " + getAnsweredCount() + " of " + questions.length);
                return;
            }
        }

        if (source == btnPrev) {
            saveCurrentSelection();
            if (currentIndex > 0) {
                loadQuestion(currentIndex - 1);
            }
        } else if (source == btnNext) {
            saveCurrentSelection();
            if (currentIndex < questions.length - 1) {
                loadQuestion(currentIndex + 1);
            }
        } else if (source == btnSubmit) {
            saveCurrentSelection();
            int answered = getAnsweredCount();
            int unattempted = questions.length - answered;

            String confirmMsg = String.format(
                    "You have answered %d of %d questions.\n" +
                    "Unanswered questions: %d.\n\n" +
                    "Are you sure you want to submit the examination?",
                    answered, questions.length, unattempted);

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    confirmMsg,
                    "Confirm Examination Submission",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (choice == JOptionPane.YES_OPTION) {
                submitExam();
            }
        }
    }

    private void submitExam() {
        isSubmitted = true;

        int correctCount = 0;
        int incorrectCount = 0;
        int unattemptedCount = 0;

        for (int i = 0; i < questions.length; i++) {
            if (userSelectedAnswers[i] == -1) {
                unattemptedCount++;
            } else if (userSelectedAnswers[i] == questions[i].correctOptionIndex) {
                correctCount++;
            } else {
                incorrectCount++;
            }
        }

        int totalQuestions = questions.length;
        double percentage = ((double) correctCount / totalQuestions) * 100.0;
        String passStatus = (percentage >= 50.0) ? "PASSED" : "FAILED";

        for (JRadioButton rb : radioOptions) {
            rb.setEnabled(false);
        }
        btnPrev.setEnabled(false);
        btnNext.setEnabled(false);
        btnSubmit.setEnabled(false);

        String resultSummary = String.format(
                "=========================================\n" +
                "       EXAMINATION SCORE REPORT          \n" +
                "=========================================\n\n" +
                " Candidate Name     : %s\n" +
                " Roll Number        : %s\n" +
                " Department         : %s\n" +
                " Exam Title         : %s\n\n" +
                "-----------------------------------------\n" +
                " Total Questions    : %d\n" +
                " Correct Answers    : %d\n" +
                " Incorrect Answers  : %d\n" +
                " Unattempted        : %d\n" +
                "-----------------------------------------\n" +
                " Final Score        : %d / %d\n" +
                " Percentage         : %.2f %%\n" +
                " Result             : %s\n" +
                "=========================================\n",
                studentName, studentRollNo, studentDepartment, examTitle,
                totalQuestions, correctCount, incorrectCount, unattemptedCount,
                correctCount, totalQuestions, percentage, passStatus
        );

        JTextArea resultTextArea = new JTextArea(resultSummary);
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        resultTextArea.setBackground(new Color(245, 247, 250));

        JOptionPane.showMessageDialog(
                this,
                new JScrollPane(resultTextArea),
                "Examination Results",
                JOptionPane.INFORMATION_MESSAGE
        );

        lblProgressStatus.setText("Exam Submitted! Final Score: " + correctCount + "/" + totalQuestions + " (" + String.format("%.1f", percentage) + "%) - " + passStatus);
        lblProgressStatus.setForeground(new Color(39, 174, 96));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new OnlineExamSystem().setVisible(true);
        });
    }
}
