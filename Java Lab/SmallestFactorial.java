import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class SmallestFactorial extends JFrame implements ActionListener {

    private JLabel lblNum1, lblNum2, lblNum3;
    private JTextField txtNum1, txtNum2, txtNum3;
    private JLabel lblSmallestTitle, lblSmallestValue;
    private JLabel lblFactorialTitle, lblFactorialValue;
    private JLabel lblStatus;
    private JButton btnCalculate, btnClear;

    public SmallestFactorial() {
        setTitle("Factorial of Smallest Among 3 Numbers");
        setSize(520, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(142, 68, 173));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        JLabel titleLabel = new JLabel("Factorial of Smallest Number", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 15, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 15);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

        gbc.gridx = 0;
        gbc.gridy = 0;
        lblNum1 = new JLabel("First Number:");
        lblNum1.setFont(labelFont);
        mainPanel.add(lblNum1, gbc);

        gbc.gridx = 1;
        txtNum1 = new JTextField(15);
        txtNum1.setFont(fieldFont);
        mainPanel.add(txtNum1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        lblNum2 = new JLabel("Second Number:");
        lblNum2.setFont(labelFont);
        mainPanel.add(lblNum2, gbc);

        gbc.gridx = 1;
        txtNum2 = new JTextField(15);
        txtNum2.setFont(fieldFont);
        mainPanel.add(txtNum2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        lblNum3 = new JLabel("Third Number:");
        lblNum3.setFont(labelFont);
        mainPanel.add(lblNum3, gbc);

        gbc.gridx = 1;
        txtNum3 = new JTextField(15);
        txtNum3.setFont(fieldFont);
        mainPanel.add(txtNum3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JSeparator sep = new JSeparator();
        mainPanel.add(sep, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        lblSmallestTitle = new JLabel("Smallest Number:");
        lblSmallestTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
        mainPanel.add(lblSmallestTitle, gbc);

        gbc.gridx = 1;
        lblSmallestValue = new JLabel("-");
        lblSmallestValue.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblSmallestValue.setForeground(new Color(41, 128, 185));
        mainPanel.add(lblSmallestValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        lblFactorialTitle = new JLabel("Factorial Result:");
        lblFactorialTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
        mainPanel.add(lblFactorialTitle, gbc);

        gbc.gridx = 1;
        lblFactorialValue = new JLabel("-");
        lblFactorialValue.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblFactorialValue.setForeground(new Color(39, 174, 96));
        mainPanel.add(lblFactorialValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        lblStatus = new JLabel("Enter 3 integers and click Calculate", JLabel.CENTER);
        lblStatus.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblStatus.setForeground(Color.GRAY);
        mainPanel.add(lblStatus, gbc);

        add(mainPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 15, 20));

        btnCalculate = new JButton("Calculate Factorial");
        btnCalculate.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCalculate.setBackground(new Color(142, 68, 173));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setPreferredSize(new Dimension(190, 42));
        btnCalculate.setFocusPainted(false);
        btnCalculate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalculate.addActionListener(this);

        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnClear.setBackground(new Color(149, 165, 166));
        btnClear.setForeground(Color.WHITE);
        btnClear.setPreferredSize(new Dimension(120, 42));
        btnClear.setFocusPainted(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.addActionListener(this);

        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnClear);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private BigInteger computeFactorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClear) {
            txtNum1.setText("");
            txtNum2.setText("");
            txtNum3.setText("");
            lblSmallestValue.setText("-");
            lblFactorialValue.setText("-");
            lblFactorialValue.setForeground(new Color(39, 174, 96));
            lblStatus.setText("Cleared. Enter 3 integers and click Calculate.");
            lblStatus.setForeground(Color.GRAY);
            txtNum1.requestFocus();
            return;
        }

        if (e.getSource() == btnCalculate) {
            String s1 = txtNum1.getText().trim();
            String s2 = txtNum2.getText().trim();
            String s3 = txtNum3.getText().trim();

            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                lblStatus.setText("Error: Please fill in all 3 numbers!");
                lblStatus.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Please enter all three numbers.", "Input Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int n1, n2, n3;
            try {
                n1 = Integer.parseInt(s1);
                n2 = Integer.parseInt(s2);
                n3 = Integer.parseInt(s3);
            } catch (NumberFormatException ex) {
                lblStatus.setText("Error: Inputs must be valid integers!");
                lblStatus.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Please enter valid whole numbers (integers).", "Format Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int smallest = Math.min(n1, Math.min(n2, n3));
            lblSmallestValue.setText(String.valueOf(smallest));

            if (smallest < 0) {
                lblFactorialValue.setText("Undefined (negative number)");
                lblFactorialValue.setForeground(Color.RED);
                lblStatus.setText("Factorial is only defined for non-negative integers (n ≥ 0).");
                lblStatus.setForeground(Color.RED);
            } else if (smallest > 500) {
                lblStatus.setText("Smallest number is too large for factorial display.");
                lblStatus.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "The smallest number (" + smallest + ") is too large to display factorial efficiently.", "Range Limit", JOptionPane.WARNING_MESSAGE);
            } else {
                BigInteger factResult = computeFactorial(smallest);
                String resultStr = factResult.toString();

                if (resultStr.length() > 25) {
                    lblFactorialValue.setText(resultStr.substring(0, 22) + "...");
                    lblFactorialValue.setToolTipText(resultStr);
                } else {
                    lblFactorialValue.setText(resultStr);
                    lblFactorialValue.setToolTipText(null);
                }

                lblFactorialValue.setForeground(new Color(39, 174, 96));
                lblStatus.setText("Calculated: " + smallest + "! successfully.");
                lblStatus.setForeground(new Color(39, 174, 96));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new SmallestFactorial().setVisible(true);
        });
    }
}
