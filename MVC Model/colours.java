import java.awt.*;
import javax.swing.*;

public class colours {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Colors");
        JLabel label = new JLabel("Hello Java");
        label.setForeground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.add(label);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );
        frame.setVisible(true);
    }
}


import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.RED);

        g.fillOval(100, 50, 100, 100);
    }
}

public class colours {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Painting");

        frame.add(new MyPanel());

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);
    }
}
