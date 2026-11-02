import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankingSystem extends JFrame implements ActionListener {

    private final String accountNumber = "ACC-2024-884920";
    private final String accountHolderName = "Pushkar Raj";
    private double currentBalance = 15000.00;

    private JLabel lblAccNoVal, lblHolderVal, lblBalanceVal;
    private JTextField txtAmount;
    private JButton btnDeposit, btnWithdraw, btnCheckBalance, btnReset;
    private JTextArea txtTransactionLog;
    private JLabel lblStatusMessage;

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public BankingSystem() {
        setTitle("Apex Trust Bank - Banking & Transaction Management");
        setSize(780, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        headerPanel.setBackground(new Color(11, 60, 93));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("🏦 APEX TRUST BANK", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JLabel subLabel = new JLabel("Secure Desktop Banking & Transaction Portal", JLabel.CENTER);
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subLabel.setForeground(new Color(209, 230, 245));

        headerPanel.add(titleLabel);
        headerPanel.add(subLabel);
        add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel accDetailsPanel = new JPanel(new GridBagLayout());
        accDetailsPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                " Account Information ",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(11, 60, 93)
        ));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font valFont = new Font("Segoe UI", Font.BOLD, 14);

        gbc.gridx = 0; gbc.gridy = 0;
        accDetailsPanel.add(new JLabel("Account Number:"), gbc);
        gbc.gridx = 1;
        lblAccNoVal = new JLabel(accountNumber);
        lblAccNoVal.setFont(valFont);
        accDetailsPanel.add(lblAccNoVal, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        accDetailsPanel.add(new JLabel("Account Holder:"), gbc);
        gbc.gridx = 1;
        lblHolderVal = new JLabel(accountHolderName);
        lblHolderVal.setFont(valFont);
        accDetailsPanel.add(lblHolderVal, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        accDetailsPanel.add(new JLabel("Current Balance:"), gbc);
        gbc.gridx = 1;
        lblBalanceVal = new JLabel(String.format("$%,.2f", currentBalance));
        lblBalanceVal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblBalanceVal.setForeground(new Color(39, 174, 96));
        accDetailsPanel.add(lblBalanceVal, gbc);

        leftPanel.add(accDetailsPanel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

        JPanel transPanel = new JPanel(new GridBagLayout());
        transPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                " Transaction Console ",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(11, 60, 93)
        ));

        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblAmount = new JLabel("Transaction Amount ($):");
        lblAmount.setFont(new Font("Segoe UI", Font.BOLD, 13));
        transPanel.add(lblAmount, gbc);

        gbc.gridx = 1;
        txtAmount = new JTextField(12);
        txtAmount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        transPanel.add(txtAmount, gbc);

        leftPanel.add(transPanel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

        JPanel btnGrid = new JPanel(new GridLayout(2, 2, 10, 10));

        btnDeposit = createActionButton("Deposit (+)", new Color(39, 174, 96));
        btnWithdraw = createActionButton("Withdraw (-)", new Color(230, 126, 34));
        btnCheckBalance = createActionButton("Check Balance", new Color(41, 128, 185));
        btnReset = createActionButton("Reset Transaction", new Color(127, 140, 141));

        btnGrid.add(btnDeposit);
        btnGrid.add(btnWithdraw);
        btnGrid.add(btnCheckBalance);
        btnGrid.add(btnReset);
        leftPanel.add(btnGrid);

        leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

        lblStatusMessage = new JLabel("Select an operation above to proceed.", JLabel.CENTER);
        lblStatusMessage.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblStatusMessage.setForeground(Color.GRAY);
        lblStatusMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(lblStatusMessage);

        centerPanel.add(leftPanel);

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                " Passbook / Transaction History ",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(11, 60, 93)
        ));

        txtTransactionLog = new JTextArea();
        txtTransactionLog.setEditable(false);
        txtTransactionLog.setFont(new Font("Consolas", Font.PLAIN, 12));
        txtTransactionLog.setBackground(new Color(248, 249, 250));
        txtTransactionLog.setMargin(new Insets(10, 10, 10, 10));

        logTransaction("Account initialized with opening balance: $" + String.format("%.2f", currentBalance));

        JScrollPane scrollPane = new JScrollPane(txtTransactionLog);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        centerPanel.add(rightPanel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        JLabel footerLabel = new JLabel("Connected to Core Banking Gateway | Status: Operational");
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(120, 120, 120));
        bottomBar.add(footerLabel);
        add(bottomBar, BorderLayout.SOUTH);
    }

    private JButton createActionButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(140, 42));
        btn.addActionListener(this);
        return btn;
    }

    private void updateBalanceDisplay() {
        lblBalanceVal.setText(String.format("$%,.2f", currentBalance));
    }

    private void logTransaction(String message) {
        String timestamp = LocalDateTime.now().format(timeFormatter);
        txtTransactionLog.append("[" + timestamp + "] " + message + "\n");
        txtTransactionLog.setCaretPosition(txtTransactionLog.getDocument().getLength());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnReset) {
            txtAmount.setText("");
            lblStatusMessage.setText("Transaction inputs reset. Ready for next transaction.");
            lblStatusMessage.setForeground(Color.GRAY);
            txtAmount.requestFocus();
            return;
        }

        if (source == btnCheckBalance) {
            String msg = String.format("Current Available Balance: $%,.2f", currentBalance);
            lblStatusMessage.setText(msg);
            lblStatusMessage.setForeground(new Color(41, 128, 185));
            JOptionPane.showMessageDialog(this,
                    "Account Holder: " + accountHolderName + "\n" +
                    "Account Number: " + accountNumber + "\n" +
                    msg,
                    "Balance Enquiry", JOptionPane.INFORMATION_MESSAGE);
            logTransaction("Balance enquiry checked. Balance: $" + String.format("%.2f", currentBalance));
            return;
        }

        String amtStr = txtAmount.getText().trim();
        if (amtStr.isEmpty()) {
            lblStatusMessage.setText("Error: Please enter a transaction amount!");
            lblStatusMessage.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter an amount in the transaction amount field.", "Missing Amount", JOptionPane.WARNING_MESSAGE);
            txtAmount.requestFocus();
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amtStr);
            if (amount <= 0) {
                lblStatusMessage.setText("Error: Amount must be greater than zero!");
                lblStatusMessage.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Transaction amount must be strictly greater than $0.00.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            lblStatusMessage.setText("Error: Invalid numeric amount!");
            lblStatusMessage.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for the transaction amount.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (source == btnDeposit) {
            currentBalance += amount;
            updateBalanceDisplay();
            txtAmount.setText("");

            String msg = String.format("Successfully deposited $%,.2f. Updated Balance: $%,.2f", amount, currentBalance);
            lblStatusMessage.setText(msg);
            lblStatusMessage.setForeground(new Color(39, 174, 96));
            logTransaction(String.format("DEPOSIT: +$%,.2f | New Balance: $%,.2f", amount, currentBalance));

            JOptionPane.showMessageDialog(this, msg, "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == btnWithdraw) {
            if (amount > currentBalance) {
                String errMsg = String.format("Insufficient funds! Requested: $%,.2f, Available: $%,.2f", amount, currentBalance);
                lblStatusMessage.setText(errMsg);
                lblStatusMessage.setForeground(Color.RED);
                logTransaction(String.format("FAILED WITHDRAWAL ATTEMPT: $%,.2f (Insufficient Funds)", amount));

                JOptionPane.showMessageDialog(this, errMsg, "Transaction Declined", JOptionPane.ERROR_MESSAGE);
            } else {
                currentBalance -= amount;
                updateBalanceDisplay();
                txtAmount.setText("");

                String msg = String.format("Successfully withdrew $%,.2f. Updated Balance: $%,.2f", amount, currentBalance);
                lblStatusMessage.setText(msg);
                lblStatusMessage.setForeground(new Color(39, 174, 96));
                logTransaction(String.format("WITHDRAWAL: -$%,.2f | New Balance: $%,.2f", amount, currentBalance));

                JOptionPane.showMessageDialog(this, msg, "Withdrawal Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new BankingSystem().setVisible(true);
        });
    }
}
