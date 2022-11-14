import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class EventHandlingFramePanel extends JPanel {
    EventHandlingFramePanel() {
        setBackground(Color.ORANGE);
        JButton button = new JButton("button");
        add(button);
    }
}

public class EventHandlingFrame extends JFrame{
    EventHandlingFrame() {
        setTitle("Event Handling Practice!");
        setSize(500, 500);

        add(new EventHandlingFramePanel());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new EventHandlingFrame();
    }
}
