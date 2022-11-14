import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


class MyActionListener implements ActionListener {

    JPanel panel = null;
    EventHandlingFramePanel eventPanel = null;
    MyActionListener(JPanel p) {
        panel = p;
    }
    boolean toggle = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton but = (JButton) e.getSource();
        System.out.println("Action Performed!");
        if (toggle != true) {
            but.setText("Haha!");
        }
        else {
            but.setText("Hoho!");
        }
        toggle = !toggle;
        Color c = new Color((int)(Math.random() * 255),
                            (int)(Math.random() * 255),
                            (int)(Math.random() * 255));
        panel.setBackground(c);

        String str = eventPanel.text.getText();
        eventPanel.but2.setText(str);
    }
}

class MyButton extends JButton implements ActionListener {

    MyButton(String str) {
        super(str);
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("button2!!");
    }
    
}

class EventHandlingFramePanel extends JPanel implements ActionListener, MouseListener{

    class MyActionListener2 implements ActionListener { // inner class

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            but3.setText(text.getText());
        }
        
    }

    JButton but1, but2, but3, but4;
    JTextField text;
    EventHandlingFramePanel() {
        setBackground(Color.ORANGE);
        but1 = new JButton("button");
        MyActionListener a = new MyActionListener(this);
        but1.addActionListener(a);
        
        but2 = new MyButton("but2");
        but2.addActionListener(a);

        but3 = new JButton("but3");
        but3.addActionListener(this);
        
        but4 = new JButton("but4");
        but4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                but4.setText(text.getText());    
            }
            
        });

        JButton but5 = new JButton("but5");
        but5.addActionListener((e)-> {
            but5.setText(text.getText());    
        });

        text = new JTextField("...........");

        text.addActionListener((e)-> {
            but1.setText(text.getText());
            but2.setText(text.getText());
            but3.setText(text.getText());
            but4.setText(text.getText());
            but5.setText(text.getText());
        });
        add(but1);
        add(but2);
        add(but3);
        add(but4);
        add(but5);
        add(text);

        this.addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == but3) {
            but3.setText(text.getText());
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("?????");   
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
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
