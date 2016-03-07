import java.awt.*;
import java.awt.event.*;
public class Fibonaxi extends Frame implements ActionListener {
	Label lb,lb1,lb2;
	TextField ta,tkq;
	Button ok,reset,exit;
	Panel p1,p2,p3;
	private static final long serialVersionUID = 1L;
	
	//Giao dien
	public void gui(){
		setBounds(200,200,500,300);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){ System.exit(0);}
		});
		setLayout(new GridLayout(3,1));
		p1=new Panel();
		p1.setLayout(new FlowLayout());
		p2=new Panel();
		p2.setLayout(new GridLayout(2,2));
		p3=new Panel();
		p3.setLayout(new FlowLayout());
		lb = new Label("Kiem tra so a thuoc day Fibonaxi");
		p1.add(lb);
		lb1 = new Label("Nhap a"); p2.add(lb1);
		ta = new TextField(20); p2.add(ta); ta.addActionListener(this);
		lb2 = new Label("Ket qua"); p2.add(lb2);
		tkq = new TextField(20); p2.add(tkq); tkq.addActionListener(this);
		ok = new Button("OK"); p3.add(ok); ok.addActionListener(this);
		reset = new Button("Reset"); p3.add(reset); reset.addActionListener(this);
		exit = new Button("Exit"); p3.add(exit); exit.addActionListener(this);
		add(p1); add(p2); add(p3);
	}
	public Fibonaxi(String title){
		super(title);
		gui();
	}
	public static void main(String[] args) {
		new Fibonaxi("Kiem tra so thuoc day Fibonaxi");
	}
	
	//Ham kiem tra so Fibonaxi
	public boolean ktfib(int K){
		int a=1,b=1,c=0;
		if(K==1) return true;
		else
			while(c<K){
				c=a+b;
				a=b;
				b=c;
			}
		if(c==K) return true;
		else return false;
	}
	
	//Xu li giao dien
	public void actionPerformed(ActionEvent m) {
		try{
			int f = Integer.parseInt(ta.getText());
			if(m.getSource()==ok)
				if(ktfib(f)==true) tkq.setText(Integer.toString(f)+" thuoc day Fibonaxi");
				else tkq.setText(Integer.toString(f)+" khong thuoc day Fibonaxi");
		} catch(Exception e){tkq.setText("Du lieu khong dung");}
		if(m.getSource()==reset){
			ta.setText("");
			tkq.setText("");
		}
		if(m.getSource()==exit) System.exit(0);
	}

}
