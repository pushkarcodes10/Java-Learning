import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberInfo extends JFrame implements ActionListener {

    private JTextField txtNumber;
    private JLabel lblSignResult;
    private JLabel lblParityResult;
    private JLabel lblPrimeResult;
    private JLabel lblPalindromeResult;
    private JLabel lblStatus;
    private JButton btnCheck, btnClear;

    public NumberInfo() {
        setTitle("Number Information Analyzer");
        setSize(520, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(22, 160, 133));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        JLabel titleLabel = new JLabel("Number Information Analyzer", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblPrompt = new JLabel("Enter an Integer:");
        lblPrompt.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtNumber = new JTextField(12);
        txtNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        inputPanel.add(lblPrompt);
        inputPanel.add(txtNumber);
        centerPanel.add(inputPanel);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnCheck = new JButton("Analyze Number");
        btnCheck.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCheck.setBackground(new Color(22, 160, 133));
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFocusPainted(false);
        btnCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCheck.addActionListener(this);

        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnClear.setBackground(new Color(127, 140, 141));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusPainted(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.addActionListener(this);

        btnPanel.add(btnCheck);
        btnPanel.add(btnClear);
        centerPanel.add(btnPanel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel resultsPanel = new JPanel(new GridLayout(4, 2, 10, 12));
        resultsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                        " Analysis Results ",
                        0, 0,
                        new Font("Segoe UI", Font.BOLD, 14),
                        new Color(44, 62, 80)
                ),
                BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));

        Font propFont = new Font("Segoe UI", Font.BOLD, 14);
        Font valFont = new Font("Segoe UI", Font.PLAIN, 15);

        JLabel lblSignTitle = new JLabel("Sign:");
        lblSignTitle.setFont(propFont);
        lblSignResult = new JLabel("-");
        lblSignResult.setFont(valFont);
        resultsPanel.add(lblSignTitle);
        resultsPanel.add(lblSignResult);

        JLabel lblParityTitle = new JLabel("Parity:");
        lblParityTitle.setFont(propFont);
        lblParityResult = new JLabel("-");
        lblParityResult.setFont(valFont);
        resultsPanel.add(lblParityTitle);
        resultsPanel.add(lblParityResult);

        JLabel lblPrimeTitle = new JLabel("Prime Check:");
        lblPrimeTitle.setFont(propFont);
        lblPrimeResult = new JLabel("-");
        lblPrimeResult.setFont(valFont);
        resultsPanel.add(lblPrimeTitle);
        resultsPanel.add(lblPrimeResult);

        JLabel lblPalTitle = new JLabel("Palindrome Check:");
        lblPalTitle.setFont(propFont);
        lblPalindromeResult = new JLabel("-");
        lblPalindromeResult.setFont(valFont);
        resultsPanel.add(lblPalTitle);
        resultsPanel.add(lblPalindromeResult);

        centerPanel.add(resultsPanel);

        lblStatus = new JLabel("Enter a number and click 'Analyze Number'", JLabel.CENTER);
        lblStatus.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblStatus.setForeground(Color.GRAY);
        lblStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblStatus.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        centerPanel.add(lblStatus);

        add(centerPanel, BorderLayout.CENTER);
    }

    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    private boolean isPalindrome(long n) {
        long original = Math.abs(n);
        long temp = original;
        long reversed = 0;
        while (temp > 0) {
            reversed = (reversed * 10) + (temp % 10);
            temp /= 10;
        }
        return original == reversed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClear) {
            txtNumber.setText("");
            lblSignResult.setText("-");
            lblParityResult.setText("-");
            lblPrimeResult.setText("-");
            lblPalindromeResult.setText("-");
            lblStatus.setText("Cleared. Enter a number and click 'Analyze Number'");
            lblStatus.setForeground(Color.GRAY);
            txtNumber.requestFocus();
            return;
        }

        if (e.getSource() == btnCheck) {
            String input = txtNumber.getText().trim();
            if (input.isEmpty()) {
                lblStatus.setText("Error: Please enter a number!");
                lblStatus.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Please enter an integer value.", "Input Required", JOptionPane.WARNING_MESSAGE);
                return;
            }

            long num;
            try {
                num = Long.parseLong(input);
            } catch (NumberFormatException ex) {
                lblStatus.setText("Error: Invalid integer entered!");
                lblStatus.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Please enter a valid integer within range.", "Format Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (num > 0) {
                lblSignResult.setText("Positive (+)");
                lblSignResult.setForeground(new Color(39, 174, 96));
            } else if (num < 0) {
                lblSignResult.setText("Negative (-)");
                lblSignResult.setForeground(new Color(231, 76, 60));
            } else {
                lblSignResult.setText("Zero (Neutral)");
                lblSignResult.setForeground(Color.DARK_GRAY);
            }

            if (num % 2 == 0) {
                lblParityResult.setText("Even Number");
                lblParityResult.setForeground(new Color(41, 128, 185));
            } else {
                lblParityResult.setText("Odd Number");
                lblParityResult.setForeground(new Color(142, 68, 173));
            }

            if (num <= 1) {
                lblPrimeResult.setText("Not Prime (Prime numbers must be > 1)");
                lblPrimeResult.setForeground(Color.GRAY);
            } else if (isPrime(num)) {
                lblPrimeResult.setText("Yes, Prime Number");
                lblPrimeResult.setForeground(new Color(39, 174, 96));
            } else {
                lblPrimeResult.setText("No, Composite (Not Prime)");
                lblPrimeResult.setForeground(new Color(230, 126, 34));
            }

            if (isPalindrome(num)) {
                lblPalindromeResult.setText("Yes, Palindrome Number");
                lblPalindromeResult.setForeground(new Color(39, 174, 96));
            } else {
                lblPalindromeResult.setText("No, Not Palindrome");
                lblPalindromeResult.setForeground(new Color(192, 57, 43));
            }

            lblStatus.setText("Analysis completed for number: " + num);
            lblStatus.setForeground(new Color(22, 160, 133));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new NumberInfo().setVisible(true);
        });
    }
}
