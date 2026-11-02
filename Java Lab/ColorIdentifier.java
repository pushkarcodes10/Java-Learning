import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorIdentifier extends JFrame implements ActionListener {

    private JPanel colorDisplayPanel;
    private JLabel colorNameLabel;
    private JLabel instructionLabel;
    private JButton btnRed, btnBlue, btnGreen, btnOrange, btnYellow, btnReset;

    public ColorIdentifier() {
        setTitle("Color Identifier for Kids");
        setSize(650, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        headerPanel.setBackground(new Color(245, 247, 250));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));

        JLabel titleLabel = new JLabel("🎨 Kids Color Learning App 🎈", JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        titleLabel.setForeground(new Color(40, 50, 70));

        instructionLabel = new JLabel("Click on any color button below to see and identify the color!", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionLabel.setForeground(new Color(90, 100, 110));

        headerPanel.add(titleLabel);
        headerPanel.add(instructionLabel);
        add(headerPanel, BorderLayout.NORTH);

        colorDisplayPanel = new JPanel();
        colorDisplayPanel.setLayout(new GridBagLayout());
        colorDisplayPanel.setBackground(Color.WHITE);
        colorDisplayPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20),
                BorderFactory.createLineBorder(new Color(200, 200, 200), 3, true)
        ));

        colorNameLabel = new JLabel("Click a button to start!", JLabel.CENTER);
        colorNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        colorNameLabel.setForeground(Color.DARK_GRAY);
        colorDisplayPanel.add(colorNameLabel);

        add(colorDisplayPanel, BorderLayout.CENTER);

        JPanel buttonContainer = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 12));
        buttonPanel.setBackground(new Color(245, 247, 250));

        btnRed = createStyledButton("Red", new Color(220, 53, 69), Color.WHITE);
        btnBlue = createStyledButton("Blue", new Color(13, 110, 253), Color.WHITE);
        btnGreen = createStyledButton("Green", new Color(25, 135, 84), Color.WHITE);
        btnOrange = createStyledButton("Orange", new Color(253, 126, 20), Color.WHITE);
        btnYellow = createStyledButton("Yellow", new Color(255, 193, 7), Color.BLACK);

        btnReset = createStyledButton("Reset", new Color(108, 117, 125), Color.WHITE);

        btnRed.addActionListener(this);
        btnBlue.addActionListener(this);
        btnGreen.addActionListener(this);
        btnOrange.addActionListener(this);
        btnYellow.addActionListener(this);
        btnReset.addActionListener(this);

        buttonPanel.add(btnRed);
        buttonPanel.add(btnBlue);
        buttonPanel.add(btnGreen);
        buttonPanel.add(btnOrange);
        buttonPanel.add(btnYellow);
        buttonPanel.add(btnReset);

        buttonContainer.add(buttonPanel, BorderLayout.CENTER);
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 10));
        add(buttonContainer, BorderLayout.SOUTH);
    }

    private JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(100, 48));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnRed) {
            colorDisplayPanel.setBackground(new Color(235, 60, 60));
            colorNameLabel.setText("❤️ THIS IS RED ❤️");
            colorNameLabel.setForeground(Color.WHITE);
            instructionLabel.setText("Red is the color of ripe strawberries and fire trucks!");
        } else if (source == btnBlue) {
            colorDisplayPanel.setBackground(new Color(45, 125, 245));
            colorNameLabel.setText("💙 THIS IS BLUE 💙");
            colorNameLabel.setForeground(Color.WHITE);
            instructionLabel.setText("Blue is the color of the sky and the deep ocean!");
        } else if (source == btnGreen) {
            colorDisplayPanel.setBackground(new Color(46, 175, 80));
            colorNameLabel.setText("💚 THIS IS GREEN 💚");
            colorNameLabel.setForeground(Color.WHITE);
            instructionLabel.setText("Green is the color of grass, leaves, and trees!");
        } else if (source == btnOrange) {
            colorDisplayPanel.setBackground(new Color(255, 140, 25));
            colorNameLabel.setText("🧡 THIS IS ORANGE 🧡");
            colorNameLabel.setForeground(Color.WHITE);
            instructionLabel.setText("Orange is the color of oranges, carrots, and sunsets!");
        } else if (source == btnYellow) {
            colorDisplayPanel.setBackground(new Color(255, 220, 40));
            colorNameLabel.setText("💛 THIS IS YELLOW 💛");
            colorNameLabel.setForeground(new Color(50, 40, 0));
            instructionLabel.setText("Yellow is the color of sunshine, lemons, and bananas!");
        } else if (source == btnReset) {
            colorDisplayPanel.setBackground(Color.WHITE);
            colorNameLabel.setText("Click a button to start!");
            colorNameLabel.setForeground(Color.DARK_GRAY);
            instructionLabel.setText("Click on any color button below to see and identify the color!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new ColorIdentifier().setVisible(true);
        });
    }
}
