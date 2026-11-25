import javax.swing.*;

// public class swing {
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("My first GUI");
//         frame.setSize(400, 300);
//         frame.setDefaultCloseOperation(
//             JFrame.EXIT_ON_CLOSE
//         );
//         frame.setVisible(true);
//     }
// }
public class swing {
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Form");

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Enter your name:");

        JTextField text = new JTextField(15);

        JButton button = new JButton("Submit");

        panel.add(label);
        panel.add(text);
        panel.add(button);

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

public class swing {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GridLayout");

        frame.setLayout(new GridLayout(2, 3));

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));

        frame.setSize(400, 200);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);
    }
}
