import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class Connect extends Frame {
	private static final long serialVersionUID = 1L;
	public Connect(String title) throws ClassNotFoundException, SQLException {
		super(title);
		setBounds(200,200,500,300);
		setLayout(new BorderLayout());
		System.out.println("Ket noi CSDL");
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url="jdbc:ucanaccess://Database3.accdb;memory=false";
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			String sql0 = "Insert into Table1(ID,TenKH,Diachi,Luong) VALUES('8','Nguyen C', 'HCM', '800')";
			stmt.executeUpdate(sql0);
			String sql2 = "Update Table1 SET Luong=Luong+Luong*0.2";
			int n=stmt.executeUpdate(sql2);
			if(n<1) System.out.println("Khong co ban ghi nao duoc cap nhat");
			else System.out.println("Co "+n+" ban ghi duoc cap nhat");
			String sql="Select ID,TenKH,Diachi,Luong From Table1";
			ResultSet rs=stmt.executeQuery(sql);
			JTable table = new JTable();
			DefaultTableModel tableModel = new DefaultTableModel();
			table.setModel(tableModel);
			JScrollPane sp = new JScrollPane(table);
			add(sp,"Center");
			String colsName[]={"ID","TenKH","Diachi","Luong"};
			tableModel.setColumnIdentifiers(colsName);
			String rowsName[] = new String[4];
			
			while(rs.next()){
				for(int i=0; i<4; i++) rowsName[i]=rs.getString(i+1);
				tableModel.addRow(rowsName);
			}
			setVisible(true);
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){System.exit(0);}
			});
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e){System.out.println(e);}
		
	}
	public static void main(String[] args){
		try {
			new Connect("Khach hang");
		} catch (Exception e) {System.out.println(e);}
	}

}
