import javax.swing.*;
import java.awt.*;

public class cardlayout {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CardLayout");

        CardLayout layout = new CardLayout();

        JPanel panel = new JPanel(layout);

        panel.add(new JLabel("Login Screen"), "login");

        panel.add(new JLabel("Dashboard"), "dashboard");

        layout.show(panel, "dashboard");

        frame.add(panel);

        frame.setSize(400, 200);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);
    }
}
