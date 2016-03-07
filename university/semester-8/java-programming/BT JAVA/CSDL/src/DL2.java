import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
public class DL2 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	TextField tf1,tf2;
	DefaultTableModel tableModel = new DefaultTableModel();
	Button submit,reset,cancel;
	Statement stm;
	String value[];
	public void connect(){
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url=""+tf1.getText()+";";
			Connection conn = DriverManager.getConnection(url);
			stm = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void gui(){
		setBounds(200,200,600,400);
		setLayout(new GridLayout(3,1));
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2,2));
		Label lb1 = new Label("Nhap thong tin"); p1.add(lb1);
		tf1 = new TextField("Jdbc:Odbc:Database2",30); p1.add(tf1);
		Label lb2=new Label("SQL"); p1.add(lb2);
		tf2 = new TextField("Select * From Table1",30); p1.add(tf2);
		add(p1);
		
		Panel p2=new Panel();
		p2.setLayout(new BorderLayout());
		JTable table = new JTable();
		table.setModel(tableModel);
		JScrollPane sp = new JScrollPane(table);
		p2.add(sp,"Center");
		String colsName[]={"ID", "Ten khach hang", "Dia chi", "San pham"};
		tableModel.setColumnIdentifiers(colsName);
		value = new String[4];
		add(p2);
		
		Panel p3=new Panel();
		p3.setLayout(new FlowLayout());
		submit = new Button("Submit");
		p3.add(submit); submit.addActionListener(this);
		reset = new Button("Reset");
		p3.add(reset); reset.addActionListener(this);
		cancel = new Button("Cancel");
		p3.add(cancel); cancel.addActionListener(this);
		add(p3);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
	}
	public DL2(String title){
		super(title);
		gui();
		//connect();
	}
	public static void main(String[] args) {
		new DL2("Select");

	}

	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==reset){
			tf1.setText("");
			tf2.setText("");
		}
		if(m.getSource()==cancel) System.exit(0);
		if(m.getSource()==submit){
			connect();
			String sql=""+tf2.getText()+";";
			try {
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					for(int i=0;i<4;i++) value[i] = rs.getString(i+1);
				tableModel.addRow(value);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
