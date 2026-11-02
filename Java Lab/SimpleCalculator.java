import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JLabel lblNum1, lblNum2, lblResultTitle, lblResultValue, lblStatus;
    private JTextField txtNum1, txtNum2;
    private JButton btnAdd, btnSubtract, btnMultiply, btnDivide, btnModulus, btnClear;

    public SimpleCalculator() {
        setTitle("Simple Arithmetic Calculator");
        setSize(460, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(41, 128, 185));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        JLabel titleLabel = new JLabel("Simple Arithmetic Calculator", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 15, 25));
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
        lblResultTitle = new JLabel("Result:");
        lblResultTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mainPanel.add(lblResultTitle, gbc);

        gbc.gridx = 1;
        lblResultValue = new JLabel("-");
        lblResultValue.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblResultValue.setForeground(new Color(39, 174, 96));
        mainPanel.add(lblResultValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        lblStatus = new JLabel("Enter two numbers and select an operation", JLabel.CENTER);
        lblStatus.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblStatus.setForeground(Color.GRAY);
        mainPanel.add(lblStatus, gbc);

        add(mainPanel, BorderLayout.CENTER);

        JPanel bottomContainer = new JPanel(new GridLayout(2, 1, 10, 10));
        bottomContainer.setBorder(BorderFactory.createEmptyBorder(0, 25, 20, 25));

        JPanel opsPanel = new JPanel(new GridLayout(1, 5, 10, 0));
        btnAdd = createButton("+", "Add");
        btnSubtract = createButton("-", "Subtract");
        btnMultiply = createButton("×", "Multiply");
        btnDivide = createButton("÷", "Divide");
        btnModulus = createButton("%", "Modulus");

        opsPanel.add(btnAdd);
        opsPanel.add(btnSubtract);
        opsPanel.add(btnMultiply);
        opsPanel.add(btnDivide);
        opsPanel.add(btnModulus);

        btnClear = new JButton("Clear / Reset");
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnClear.setBackground(new Color(231, 76, 60));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusPainted(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.addActionListener(this);

        bottomContainer.add(opsPanel);
        bottomContainer.add(btnClear);
        add(bottomContainer, BorderLayout.SOUTH);
    }

    private JButton createButton(String symbol, String toolTip) {
        JButton btn = new JButton(symbol);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btn.setToolTipText(toolTip);
        btn.setBackground(new Color(236, 240, 241));
        btn.setForeground(new Color(44, 62, 80));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnClear) {
            txtNum1.setText("");
            txtNum2.setText("");
            lblResultValue.setText("-");
            lblResultValue.setForeground(new Color(39, 174, 96));
            lblStatus.setText("Cleared. Enter numbers and choose an operation.");
            lblStatus.setForeground(Color.GRAY);
            txtNum1.requestFocus();
            return;
        }

        String str1 = txtNum1.getText().trim();
        String str2 = txtNum2.getText().trim();

        if (str1.isEmpty() || str2.isEmpty()) {
            lblStatus.setText("Error: Please enter both numbers!");
            lblStatus.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter both numbers before calculating.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double num1, num2;
        try {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);
        } catch (NumberFormatException ex) {
            lblStatus.setText("Error: Invalid numeric input!");
            lblStatus.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double result = 0;
        String operationName = "";

        if (source == btnAdd) {
            result = num1 + num2;
            operationName = "Addition";
        } else if (source == btnSubtract) {
            result = num1 - num2;
            operationName = "Subtraction";
        } else if (source == btnMultiply) {
            result = num1 * num2;
            operationName = "Multiplication";
        } else if (source == btnDivide) {
            if (num2 == 0) {
                lblStatus.setText("Error: Cannot divide by zero!");
                lblStatus.setForeground(Color.RED);
                lblResultValue.setText("Undefined (÷ 0)");
                lblResultValue.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Division by zero is undefined.", "Math Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            result = num1 / num2;
            operationName = "Division";
        } else if (source == btnModulus) {
            if (num2 == 0) {
                lblStatus.setText("Error: Cannot calculate modulus with zero divisor!");
                lblStatus.setForeground(Color.RED);
                lblResultValue.setText("Undefined (% 0)");
                lblResultValue.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Modulus by zero is undefined.", "Math Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            result = num1 % num2;
            operationName = "Modulus";
        }

        String formattedResult = (result == (long) result) ? String.format("%d", (long) result) : String.format("%.4f", result);
        lblResultValue.setText(formattedResult);
        lblResultValue.setForeground(new Color(39, 174, 96));
        lblStatus.setText(operationName + " successful!");
        lblStatus.setForeground(new Color(40, 116, 166));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new SimpleCalculator().setVisible(true);
        });
    }
}
