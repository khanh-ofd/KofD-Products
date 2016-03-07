import java.awt.*;
import java.awt.event.*;
public class DoiNen extends Frame implements ActionListener {
	Button green,red,blue,exit;
	private static final long serialVersionUID = 1L;
	public void gui(){
		setBounds(200,200,300,300);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		setLayout(new FlowLayout()); 	
		green = new Button("Green"); add(green); green.addActionListener(this);
		blue = new Button("Blue"); add(blue); blue.addActionListener(this);
		red = new Button("Red"); add(red); red.addActionListener(this);
		exit = new Button("Exit"); add(exit); exit.addActionListener(this);
	}
	public DoiNen(String title){
		super(title);
		gui();
	}
	public static void main(String[] args) {
		new DoiNen("Doi nen");
	}
	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==green) setBackground(Color.green);	
		if(m.getSource()==blue) setBackground(Color.blue);
		if(m.getSource()==red) setBackground(Color.red);
		if(m.getSource()==exit) System.exit(0);
	}

}
