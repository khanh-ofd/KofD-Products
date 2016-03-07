import java.awt.*;
import java.awt.event.*;
public class ptbac1 extends Frame implements ActionListener  {
	private static final long serialVersionUID = 1L;
	Label lb,lb1,lb2,lb3;
	TextField ta,tb,kq;
	Button tinh,reset,thoat;
	Panel p,p1,p2,p3;
	public ptbac1(String title){
		super(title);
		GUI();
	}
	public void GUI(){
		//Tao giao dien
		setBounds(200,200,500,300);
		setLayout(new GridLayout(3,1));
		p1=new Panel();
		p1.setLayout(new FlowLayout());
		p2=new Panel();
		p2.setLayout(new GridLayout(3,2));
		p3=new Panel();
		p3.setLayout(new GridLayout(1,3));
		lb = new Label("Giai phuong trinh bac nhat");
		lb1 = new Label("Nhap a:");
		lb2 = new Label("Nhap b:");
		lb3 = new Label("Ket qua:");
		ta = new TextField(20);
		tb = new TextField(20);
		kq = new TextField(20);
		tinh = new Button("Tinh");
		reset = new Button("Reset");
		thoat = new Button("Thoat");
		p1.add(lb);
		p2.add(lb1); p2.add(ta);
		p2.add(lb2); p2.add(tb);
		p2.add(lb3); p2.add(kq);
		p3.add(tinh); p3.add(reset); p3.add(thoat);
		add(p1); add(p2); add(p3);
		
		//Nhan dien cac thanh phan tao su kien
		ta.addActionListener(this);
		tb.addActionListener(this);
		kq.addActionListener(this);
		tinh.addActionListener(this);
		reset.addActionListener(this);
		thoat.addActionListener(this);
		
		setVisible(true);
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        }); 
	}
	public static void main(String[] args) {
		new ptbac1("PHUONG TRINH BAC NHAT");
	}
	
	//xu li cac su kien
	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==tinh){
			try{
				int a = Integer.parseInt(ta.getText());
				int b = Integer.parseInt(tb.getText());
				if(a==0)
					if(b==0) kq.setText("Phuong trinh co vo so nghiem");
					else kq.setText("Phuong trinh vo nghiem");
				else kq.setText(Float.toString((float)-b/a));
			}
			catch(Exception e){
				kq.setText("Du lieu khong dung");
			}
		}
		if(m.getSource()==reset){
			ta.setText("");
			tb.setText("");
			kq.setText("");
		}
		if(m.getSource()==thoat) System.exit(0);
	}

}
