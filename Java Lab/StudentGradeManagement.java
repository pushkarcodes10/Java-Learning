import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeManagement extends JFrame implements ActionListener {

    private JTextField txtRollNo, txtName, txtDepartment;
    private JTextField txtSub1, txtSub2, txtSub3, txtSub4, txtSub5;
    private JButton btnCalculate, btnReset;
    private JTextArea txtReportArea;

    private final String[] SUBJECT_NAMES = {
        "Mathematics", 
        "Physics", 
        "Computer Science", 
        "Data Structures", 
        "English"
    };

    public StudentGradeManagement() {
        setTitle("Student Marks Calculation and Grade Management System");
        setSize(850, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 3, 3));
        headerPanel.setBackground(new Color(24, 44, 97));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("🎓 Student Marks & Grade Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);

        JLabel subTitleLabel = new JLabel("Academic Performance Calculator & Report Generator", JLabel.CENTER);
        subTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subTitleLabel.setForeground(new Color(223, 230, 233));

        headerPanel.add(titleLabel);
        headerPanel.add(subTitleLabel);
        add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JPanel studentInfoPanel = new JPanel(new GridBagLayout());
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                " 1. Student Details ",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(24, 44, 97)
        ));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        gbc.gridx = 0; gbc.gridy = 0;
        studentInfoPanel.add(new JLabel("Roll Number:"), gbc);
        gbc.gridx = 1;
        txtRollNo = new JTextField(12);
        txtRollNo.setFont(fieldFont);
        studentInfoPanel.add(txtRollNo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        studentInfoPanel.add(new JLabel("Student Name:"), gbc);
        gbc.gridx = 1;
        txtName = new JTextField(12);
        txtName.setFont(fieldFont);
        studentInfoPanel.add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        studentInfoPanel.add(new JLabel("Department:"), gbc);
        gbc.gridx = 1;
        txtDepartment = new JTextField(12);
        txtDepartment.setFont(fieldFont);
        studentInfoPanel.add(txtDepartment, gbc);

        formPanel.add(studentInfoPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel marksPanel = new JPanel(new GridBagLayout());
        marksPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                " 2. Subject Marks (0 - 100) ",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(24, 44, 97)
        ));

        JTextField[] markFields = {
            txtSub1 = new JTextField(8),
            txtSub2 = new JTextField(8),
            txtSub3 = new JTextField(8),
            txtSub4 = new JTextField(8),
            txtSub5 = new JTextField(8)
        };

        for (int i = 0; i < 5; i++) {
            gbc.gridx = 0; gbc.gridy = i;
            JLabel subLabel = new JLabel("Subject " + (i + 1) + " (" + SUBJECT_NAMES[i] + "):");
            subLabel.setFont(labelFont);
            marksPanel.add(subLabel, gbc);

            gbc.gridx = 1;
            markFields[i].setFont(fieldFont);
            marksPanel.add(markFields[i], gbc);
        }

        formPanel.add(marksPanel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnCalculate = new JButton("Calculate Result");
        btnCalculate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCalculate.setBackground(new Color(39, 174, 96));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFocusPainted(false);
        btnCalculate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalculate.addActionListener(this);

        btnReset = new JButton("Reset Form");
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnReset.setBackground(new Color(231, 76, 60));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);

        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnReset);
        formPanel.add(buttonPanel);

        centerPanel.add(formPanel);

        JPanel reportCardPanel = new JPanel(new BorderLayout(5, 5));
        reportCardPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                " 3. Generated Academic Report Card ",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(24, 44, 97)
        ));

        txtReportArea = new JTextArea();
        txtReportArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtReportArea.setEditable(false);
        txtReportArea.setBackground(new Color(250, 250, 252));
        txtReportArea.setMargin(new Insets(10, 10, 10, 10));
        setInitialReportTemplate();

        JScrollPane scrollPane = new JScrollPane(txtReportArea);
        reportCardPanel.add(scrollPane, BorderLayout.CENTER);

        centerPanel.add(reportCardPanel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        JLabel statusLabel = new JLabel("Ready. Enter student info and marks between 0 and 100.");
        statusLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        statusLabel.setForeground(Color.GRAY);
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void setInitialReportTemplate() {
        txtReportArea.setText(
            "====================================================\n" +
            "             STUDENT ACADEMIC REPORT               \n" +
            "====================================================\n\n" +
            "  Please enter student details and marks on the left,\n" +
            "  then click 'Calculate Result' to generate the report.\n\n" +
            "  Grading Scale:\n" +
            "   - Percentage >= 90% : Grade A+ (Outstanding)\n" +
            "   - Percentage >= 80% : Grade A  (Excellent)\n" +
            "   - Percentage >= 70% : Grade B  (Very Good)\n" +
            "   - Percentage >= 60% : Grade C  (Good)\n" +
            "   - Percentage >= 50% : Grade D  (Average)\n" +
            "   - Percentage >= 40% : Grade E  (Pass)\n" +
            "   - Percentage <  40% : Grade F  (Fail)\n\n" +
            "===================================================="
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReset) {
            txtRollNo.setText("");
            txtName.setText("");
            txtDepartment.setText("");
            txtSub1.setText("");
            txtSub2.setText("");
            txtSub3.setText("");
            txtSub4.setText("");
            txtSub5.setText("");
            setInitialReportTemplate();
            txtRollNo.requestFocus();
            return;
        }

        if (e.getSource() == btnCalculate) {
            String rollNo = txtRollNo.getText().trim();
            String name = txtName.getText().trim();
            String dept = txtDepartment.getText().trim();

            if (rollNo.isEmpty() || name.isEmpty() || dept.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in all student details (Roll No, Name, and Department)!",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JTextField[] markFields = {txtSub1, txtSub2, txtSub3, txtSub4, txtSub5};
            double[] marks = new double[5];

            for (int i = 0; i < 5; i++) {
                String markText = markFields[i].getText().trim();
                if (markText.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Please enter marks for Subject " + (i + 1) + " (" + SUBJECT_NAMES[i] + ").",
                            "Missing Marks", JOptionPane.WARNING_MESSAGE);
                    markFields[i].requestFocus();
                    return;
                }

                try {
                    double val = Double.parseDouble(markText);
                    if (val < 0 || val > 100) {
                        JOptionPane.showMessageDialog(this,
                                "Invalid marks for " + SUBJECT_NAMES[i] + " (" + val + ")!\nMarks must be between 0 and 100.",
                                "Score Range Error", JOptionPane.ERROR_MESSAGE);
                        markFields[i].requestFocus();
                        return;
                    }
                    marks[i] = val;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid numeric value for " + SUBJECT_NAMES[i] + "!\nPlease enter a valid number.",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    markFields[i].requestFocus();
                    return;
                }
            }

            double totalMarks = 0;
            boolean hasFailedSubject = false;
            for (double mark : marks) {
                totalMarks += mark;
                if (mark < 40) {
                    hasFailedSubject = true;
                }
            }

            double percentage = (totalMarks / 500.0) * 100.0;

            String grade;
            String remarks;
            if (percentage >= 90) {
                grade = "A+";
                remarks = "Outstanding";
            } else if (percentage >= 80) {
                grade = "A";
                remarks = "Excellent";
            } else if (percentage >= 70) {
                grade = "B";
                remarks = "Very Good";
            } else if (percentage >= 60) {
                grade = "C";
                remarks = "Good";
            } else if (percentage >= 50) {
                grade = "D";
                remarks = "Average";
            } else if (percentage >= 40) {
                grade = "E";
                remarks = "Pass";
            } else {
                grade = "F";
                remarks = "Fail";
            }

            String finalResult = (hasFailedSubject || percentage < 40) ? "FAIL" : "PASS";

            StringBuilder sb = new StringBuilder();
            sb.append("====================================================\n");
            sb.append("             OFFICIAL STUDENT GRADE REPORT          \n");
            sb.append("====================================================\n");
            sb.append(String.format(" Roll Number : %-20s\n", rollNo));
            sb.append(String.format(" Name        : %-20s\n", name));
            sb.append(String.format(" Department  : %-20s\n", dept));
            sb.append("----------------------------------------------------\n");
            sb.append(String.format(" %-22s %-12s %-10s\n", "Subject Name", "Max Marks", "Marks Obtained"));
            sb.append("----------------------------------------------------\n");

            for (int i = 0; i < 5; i++) {
                sb.append(String.format(" %-22s %-12d %-10.2f\n", SUBJECT_NAMES[i], 100, marks[i]));
            }

            sb.append("----------------------------------------------------\n");
            sb.append(String.format(" Total Marks Scored : %.2f / 500.00\n", totalMarks));
            sb.append(String.format(" Overall Percentage : %.2f %%\n", percentage));
            sb.append(String.format(" Assigned Grade     : %s (%s)\n", grade, remarks));
            sb.append(String.format(" Final Status       : %s\n", finalResult));
            sb.append("====================================================\n");
            if (hasFailedSubject) {
                sb.append(" Note: Scored below 40 in one or more individual subject(s).\n");
            }
            sb.append(" Report generated successfully.\n");

            txtReportArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new StudentGradeManagement().setVisible(true);
        });
    }
}
