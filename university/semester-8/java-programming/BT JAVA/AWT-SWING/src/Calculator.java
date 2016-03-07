import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Calculator extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField display,tf;
	double value = 0,memory=0;
	String operator="=";
	boolean start=true;
	public Calculator(){
		setTitle("Calculator");
		setBounds(200,200,380,300);
		setLayout(new BorderLayout(10,10));
		//Tao Menu
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu edit = new Menu("Edit");
		edit.add(new MenuItem("Copy Ctrl+C"));
		edit.add(new MenuItem("Paste Ctrl+ V"));
		mb.add(edit);
		Menu view = new Menu("View");
		view.add(new MenuItem("Standard"));
		view.add(new MenuItem("Scientific"));
		mb.add(view);
		Menu help = new Menu("Help");
		help.add(new MenuItem("Help Topic"));
		help.add(new MenuItem("About Calculator"));
		mb.add(help);
		
		//Tao giao dien
		display = new JTextField("0");
		display.setEditable(false);
		add(display,"North");
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout(10,15));
		tf=new JTextField(""); tf.setEditable(false);
		p1.add(tf,"North");
		JPanel p11 = new JPanel();
		p11.setLayout(new GridLayout(4,1,5,5));
		String button1[] = {"MC", "MR", "MS", "M+"};
		for(int i=0; i<4; i++){
			JButton b1 = new JButton(button1[i]);
			p11.add(b1);
			b1.addActionListener(this);
		}
		p1.add(p11,"Center");
		add(p1,"West");
		
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout(10,10));
		JPanel p21=new JPanel();
		p21.setLayout(new GridLayout(1,3,5,5));
		String button2[] = {"Backspace", "CE", "C"};
		for(int i=0; i<=2; i++){
			JButton b2 = new JButton(button2[i]);
			p21.add(b2);
			b2.addActionListener(this);
		}
		p2.add(p21,"North");
		JPanel p22=new JPanel();
		p22.setLayout(new GridLayout(4,5,5,5));
		String button3[] = {"7", "8", "9", "/", "sqrt",
						  "4", "5", "6", "*", "%",
						  "1", "2", "3", "-", "1/x",
						  "0", "+/-", ".", "+", "="};
		for(int i=0; i<20; i++){
			JButton b3 = new JButton(button3[i]);
			p22.add(b3);
			b3.addActionListener(this);
		}
		p2.add(p22,"Center");
		add(p2,"Center");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		
	}
	public void actionPerformed(ActionEvent m) {
		String s = m.getActionCommand();
		if('0'<=s.charAt(0)&&s.charAt(0)<='9'&&!s.equals("1/x")||s.equals(".")){
			if(start) display.setText(s);
			else display.setText(display.getText()+s);
			start=false;
		}
		else {
			if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("=")){
				double x = Double.parseDouble(display.getText());
				calculate(x);
				operator=s;
				start=true;
			}
			else if(s.equals("%")||s.equals("sqrt")||s.equals("1/x")){
				operator=s;
				double x = Double.parseDouble(display.getText());
				value = x;
				calculate(x);
				start=true;
			}
			else if(s.equals("+/-")){
				value = Double.parseDouble(display.getText());
				value*=(-1);
				display.setText(Double.toString(value));
			}
			else if(s.equals("Backspace")&&start==false){
				display.setText(display.getText().substring(0, display.getText().length()-1));
				if(display.getText().equals("")) {
					display.setText("0");
					start=true;
				}
			}
			else if(s.equals("C")){
				display.setText("0");
				value=0;
				operator="=";
				start=true;
			}
			else if(s.equals("CE")) display.setText("0");
			else if(s.equals("MC")||s.equals("MR")||s.equals("MS")||s.equals("M+")) Memory(s);
		}
		
	}
	public void calculate(double n){
		if(operator.equals("+")) value+=n;
		else if(operator.equals("-")) value-=n;
		else if(operator.equals("*")) value*=n;
		else if(operator.equals("/")) value/=n;
		else if(operator.equals("=")) value=n;
		else if(operator.equals("%")) value/=100;
		else if(operator.equals("sqrt")) value = Math.sqrt(value);
		else if(operator.equals("1/x")) value = 1.0/value;
		display.setText(""+value);
	}
	public void Memory(String y){
		if(y.equals("MS")){
			tf.setText("M");
			memory = Double.parseDouble(display.getText());
		}
		else if(y.equals("MC")){
			tf.setText("");
			memory=0;
			display.setText("0");
		}
		else if(y.equals("MR")) display.setText(""+memory);
		else if(y.equals("M+")) {
			 memory+=Double.parseDouble(display.getText());
			 if(tf.getText()=="") tf.setText("M");
		}
	}
	public static void main(String[] args){
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
	
}