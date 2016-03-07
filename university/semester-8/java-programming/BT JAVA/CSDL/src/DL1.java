import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
public class DL1 extends JFrame implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	Statement stm;
	JTextField nhap;
	JButton timkiem,reset,exit;
	Checkbox maso,hoten,ns,diachi,gt;
	String select,value[];
	DefaultTableModel tableModel = new DefaultTableModel();
	public void data(){
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url="jdbc:ucanaccess://Database1.accdb;memory=false";
			Connection conn = DriverManager.getConnection(url);
			stm = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void gui(){
		CheckboxGroup cg = new CheckboxGroup();
		setBounds(200,200,600,300);
		setLayout(new BorderLayout());
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(2,1));
		JPanel p11 = new JPanel();
		p11.setLayout(new FlowLayout());
		JLabel lb1 = new JLabel("Nhap noi dung"); p11.add(lb1);
		nhap = new JTextField("Nhap thong tin muon tim kiem",20); p11.add(nhap);
		timkiem = new JButton("Tim Kiem"); p11.add(timkiem); timkiem.addActionListener(this);
		reset = new JButton("Reset"); p11.add(reset); reset.addActionListener(this);
		exit = new JButton("Exit"); p11.add(exit); exit.addActionListener(this);
		p1.add(p11);
		
		JPanel p12=new JPanel();
		p12.setLayout(new FlowLayout());
		JLabel lb2 = new JLabel("Tim kiem theo"); p12.add(lb2);
		maso = new Checkbox("Ma so",cg,false); p12.add(maso); maso.addItemListener(this);
		hoten = new Checkbox("Ho ten",cg,false); p12.add(hoten); hoten.addItemListener(this);
		ns = new Checkbox("Ngay sinh",cg,false); p12.add(ns); ns.addItemListener(this);
		diachi = new Checkbox("Dia chi",cg,false); p12.add(diachi); diachi.addItemListener(this);
		gt = new Checkbox("Gioi tinh",cg,false); p12.add(gt); gt.addItemListener(this);
		p1.add(p12);
		add(p1,"North");
		
		//Tao bang
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout());
		JTable table = new JTable();
		JScrollPane sp = new JScrollPane(table);
		p2.add(sp,"Center");
		table.setModel(tableModel);
		String colsName[]={"Ma so", "Ho ten", "Ngay sinh", "Dia chi", "Gioi tinh"};
		tableModel.setColumnIdentifiers(colsName);
		value = new String[5];
		add(p2,"Center");
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public DL1(String title){
		super(title);
		gui();
		data();
	}
	public static void main(String[] args) {
		new DL1("Select");
	}
	public void itemStateChanged(ItemEvent m) {
		if(m.getItemSelectable()==maso) select="maso";
		if(m.getItemSelectable()==hoten) select="hoten";
		if(m.getItemSelectable()==ns) select="ngaysinh";
		if(m.getItemSelectable()==diachi) select="diachi";
		if(m.getItemSelectable()==gt) select="gioitinh";
		
	}
	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==exit) System.exit(0);
		if(m.getSource()==reset) {
			nhap.setText("");
		}
		if(m.getSource()==timkiem){
			try {
				String spl="SELECT * FROM Table1 WHERE "+select+"='"+nhap.getText()+"';";
				ResultSet rs=stm.executeQuery(spl);
				while(rs.next()){
					for(int i=0; i<5; i++)
						value[i]=rs.getString(i+1);
					tableModel.addRow(value);
				}
			} catch (SQLException e) {
				System.out.println("Loi thao tac du lieu");
			}
		}
		
	}

}
