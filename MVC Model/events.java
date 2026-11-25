import javax.swing.*;
import java.awt.event.*;

public class events {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Handling");
        JButton button = new JButton("Click me");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked");
            }
        });

        frame.add(button);

        frame.setSize(300, 200);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);
    }    
}

public class events {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Events");
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");;
            }

            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
            }
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
            }
        });
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}