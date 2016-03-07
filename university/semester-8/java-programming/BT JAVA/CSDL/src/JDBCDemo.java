import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class JDBCDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	public JDBCDemo(String title){
		super(title);
		setBounds(200,200,500,300);
		setLayout(new BorderLayout());
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url="jdbc:ucanaccess://Database3.accdb;memory=false";
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			String sql="SELECT * FROM Table1";
			ResultSet rs=stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			JTable table = new JTable();
			DefaultTableModel tableModel = new DefaultTableModel();
			table.setModel(tableModel);
			JScrollPane sp = new JScrollPane(table);
			add(sp,"Center");
			int numberOfColumns=rsmd.getColumnCount();
			String colsName[] = new String[numberOfColumns];
			for(int i=1; i<=numberOfColumns; i++) colsName[i-1]=rsmd.getColumnLabel(i);
			tableModel.setColumnIdentifiers(colsName);
			String rowsName[] = new String[numberOfColumns];
			while(rs.next()){
				for(int i=0; i<numberOfColumns; i++) rowsName[i]=rs.getString(i+1);
				tableModel.addRow(rowsName);
			}
			rs.close();
			stmt.close();
			conn.close();
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}catch(Exception e){System.out.println(e);}
	}
	public static void main(String[]args){
		new JDBCDemo("Khach hang");
	}

}
