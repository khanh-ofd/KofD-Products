import java.awt.*;
import java.awt.event.*;
public class songto extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Label lb,lb1,lb2;
	TextField tn,tkq;
	Button tim,reset,exit;
	Panel p1,p2,p3;
	public void gui(){
		setBounds(200,200,500,300);
		setLayout(new GridLayout(3,1));
		p1=new Panel();
		p1.setLayout(new FlowLayout());
		p2=new Panel();
		p2.setLayout(new GridLayout(2,2));
		p3=new Panel();
		p3.setLayout(new FlowLayout());
		tn=new TextField(20);
		tkq=new TextField(20); tkq.setEditable(false);
		lb=new Label("Cac so nguyen to <=n");
		lb1=new Label("Nhap n");
		lb2=new Label("Ket qua");
		tim=new Button("Tim");
		reset=new Button("Reset");
		exit=new Button("Exit");
		p1.add(lb);
		p2.add(lb1); p2.add(tn);
		p2.add(lb2); p2.add(tkq);
		p3.add(tim); p3.add(reset); p3.add(exit);
		add(p1); add(p2); add(p3);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		
		//Nhan dien cac thanh phan tao su kien
		tn.addActionListener(this);
		tkq.addActionListener(this);
		tim.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
	}
	public static void main(String[] args) {
		new songto("TIM SO NGUYEN TO");
	}
	public songto(String title){
		super(title);
		gui();
	}

	public void actionPerformed(ActionEvent m) {
		try{
			if(m.getSource()==tim)
				for(int i=1;i<=Integer.parseInt(tn.getText());i++)
					if(ktsnt(i)==true) tkq.setText(tkq.getText()+" "+Integer.toString(i));
		}
		catch(Exception e){tkq.setText("du lieu nhap khong dung");}
		if(m.getSource()==reset){
			tn.setText("");
			tkq.setText("");
		}
		if(m.getSource()==exit) System.exit(0);
	}
	public boolean ktsnt(int n){
		int kt=0;
		for(int i=1; i<=n; i++) if(n%i==0) kt++;
		if(kt==2) return true;
		else return false;
	}

}
