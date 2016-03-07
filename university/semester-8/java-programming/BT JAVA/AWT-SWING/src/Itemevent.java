import java.awt.*;
import java.awt.event.*;
public class Itemevent extends Frame implements ItemListener, ActionListener {
	List list;
	Choice ch;
	Button exit;
	Checkbox c1,c2;
	Panel p1,p2,p3;
	Label lb;
	private static final long serialVersionUID = 1L;
	public void gui(){
		setBounds(200,200,500,300);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		setLayout(new GridLayout(3,1));
		p1=new Panel();
		p1.setLayout(new FlowLayout());
		p2=new Panel();
		p2.setLayout(new GridLayout(2,1));
		p3=new Panel();
		p3.setLayout(new FlowLayout());
		CheckboxGroup cg =new CheckboxGroup();
		c1=new Checkbox("Female",cg,true); p1.add(c1); c1.addItemListener(this);
		c2=new Checkbox("Male",cg,true); p1.add(c2); c2.addItemListener(this);
		list = new List(3,false);
		list.add("MS DOS");
		list.add("WINDOWS");
		list.add("LINUX");
		p2.add(list);
		list.addItemListener(this);
		ch = new Choice();
		ch.addItem("Tiger");
		ch.addItem("Lion");
		ch.addItem("Dog");
		ch.addItem("Cat");
		p2.add(ch);
		ch.addItemListener(this);
		lb=new Label("The Item is display here");
		p3.add(lb);
		exit = new Button("Exit"); 
		p3.add(exit); exit.addActionListener(this);
		add(p1); add(p2); add(p3);
	}
	public Itemevent(String title){
		super(title);
		gui();
	}
	public static void main(String[] args) {
		new Itemevent("Item Event");
	}

	public void itemStateChanged(ItemEvent m) {
		if(m.getItemSelectable()==ch) lb.setText(ch.getSelectedItem()+" had been choice");
		if(m.getItemSelectable()==list) lb.setText(list.getSelectedItem()+" had been choice");
		if(m.getItemSelectable()==c1) lb.setText("Female had been choice");
		if(m.getItemSelectable()==c2) lb.setText("Male had been choice");
	}
	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==exit) System.exit(0);		
	}

}
