//import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MoreComponentPanel extends JPanel{
	private JLabel label;
	MoreComponentPanel(){
		label = new JLabel("Sejong");
		add(label);
	}
	String getMyText() {
		return label.getText();
	}
	void setMyText(String str) {
		label.setText(str);		
	}	
	
}


class MyDialog extends JDialog {
	private JTextField tf;
	MyDialog(MoreComponentPractice frame){
		super(frame, "My Dialog", true);
		
		setSize(300,100);
//		setTitle("My Dialog");
		this.setLayout(new FlowLayout());
		tf = new JTextField(10);
		add(tf);
		
		setMyText(frame.panel.getMyText());
		
		JButton okay = new JButton("okay");
		JButton cancel = new JButton("cancel");
		
		okay.addActionListener((e)->{
			frame.panel.setMyText(getMyText());
			setVisible(false);
		});
		cancel.addActionListener((e)->{
			setVisible(false);
		});
		add(okay);
		add(cancel);
		
		setVisible(true);
	}
	String getMyText() {
		return tf.getText();
	}
	void setMyText(String str) {
		tf.setText(str);		
	}
}

public class MoreComponentPractice extends JFrame 
                                   implements ActionListener{
	
	MoreComponentPanel panel;
	MoreComponentPractice(){
		setSize(300,300);
		setTitle("More Component");
		
		setMenu();	
		panel =new MoreComponentPanel(); 
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	void setMenu() {
		JMenuBar mb = new JMenuBar();
		
		String [] str = {"Open1", "Open2", "Save", "Color",
				         "", "Close"};		
		JMenu fileMenu = new JMenu("File");	
		for(int i = 0; i<str.length; i++) {
			if(str[i].equals("")) {
				fileMenu.addSeparator();
			}
			else{
				JMenuItem it = new JMenuItem(str[i]);
				it.addActionListener(this);
				fileMenu.add(it);
			}
		}
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(new JMenuItem("copy"));
		editMenu.add(new JMenuItem("paste"));
		editMenu.add(new JMenuItem("cut"));
				
		mb.add(fileMenu);
		mb.add(editMenu);
		
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new MoreComponentPractice();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Open1":
			
			//MyDialog dlg = new MyDialog(this);
			
			break;
		case "Open2":
			String str = JOptionPane.showInputDialog("Input Text");
			if(str != null)
				panel.setMyText(str);
			
			break;			
		case "Save":
			//System.out.println("Save!");
			
			JFileChooser fileDlg = new JFileChooser();
			int result1 = fileDlg.showOpenDialog(this);
			if(result1 == JFileChooser.APPROVE_OPTION) {
				//fileDlg.show(false);
				//File file = fileDlg.getSelectedFile();
			}
			break;
			
		case "Color":
			
			// Color color = JColorChooser.showDialog(this, "select Color", 
			// 		Color.yellow);

			
			break;
			
		case "Close":
			int result = JOptionPane.showConfirmDialog
				(this, "안녕하세요", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION)
				System.exit(0);
			break;
		default: break;
		}
		
	}

}