import java.awt.*;
import java.awt.event.*;
public class pheptoan extends Frame implements ActionListener {
	Label lb,lb1,lb2,lb3;
	TextField ta,tb,tkq;
	Button cong,tru,nhan,chia,reset,exit;
	Panel p1,p2,p3,p4;
	private static final long serialVersionUID = 1L;
	public void gui(){
		//Tao giao dien
		setBounds(200,200,500,300);
		setLayout(new GridLayout(4,1));
		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p2=new Panel();
		p2.setLayout(new GridLayout(3,2));
		p3=new Panel();
		p3.setLayout(new FlowLayout());
		p4=new Panel();
		p4.setLayout(new FlowLayout());
		lb = new Label("Minh hoa cac phep toan");
		lb1 = new Label("Nhap a");
		lb2 = new Label("Nhap b");
		lb3 = new Label("Ket qua");
		ta = new TextField(20);
		tb = new TextField(20);
		tkq = new TextField(20);
		cong = new Button("Cong");
		tru = new Button("Tru");
		nhan = new Button("Nhan");
		chia = new Button("Chia");
		reset = new Button("Reset");
		exit = new Button("Exit");
		p1.add(lb);
		p2.add(lb1); p2.add(ta);
		p2.add(lb2); p2.add(tb);
		p2.add(lb3); p2.add(tkq);
		p3.add(cong); p3.add(tru); p3.add(nhan); p3.add(chia);
		p4.add(exit); p4.add(reset);
		add(p1); add(p2); add(p3); add(p4);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//Nhan dien cac thanh phan tao su kien
		ta.addActionListener(this);
		tb.addActionListener(this);
		tkq.addActionListener(this);
		cong.addActionListener(this);
		tru.addActionListener(this);
		nhan.addActionListener(this);
		chia.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
	}
	public pheptoan(String title){
		super(title);
		gui();
	}
	public static void main(String[] args) {
		new pheptoan("MINH HOA CAC PHEP TOAN");
	}

	public void actionPerformed(ActionEvent m) {
		try{
			float a = Float.parseFloat(ta.getText());
			float b = Float.parseFloat(tb.getText());
			if(m.getSource()==cong)
				tkq.setText(Float.toString(a+b));
			if(m.getSource()==tru)
				tkq.setText(Float.toString(a-b));
			if(m.getSource()==nhan)
				tkq.setText(Float.toString(a*b));
			if(m.getSource()==chia)
				if(b==0) tkq.setText("Phep chia khong hop le");
				else tkq.setText(Float.toString(a/b));
		}
		catch(Exception e){tkq.setText("Du lieu khong dung");}
		if(m.getSource()==reset){
			ta.setText("");
			tb.setText("");
			tkq.setText("");
		}	
		if(m.getSource()==exit)
			System.exit(0);
	}

}
