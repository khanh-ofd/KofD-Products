import java.sql.*;

public class demo {
	public static void main(String[] args) {
		try {	
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url="jdbc:ucanaccess://Database1.accdb;memory=false";
			Connection conn = DriverManager.getConnection(url);
			Statement stm = conn.createStatement();
			String spl = "SELECT * FROM Table1";
			ResultSet rs = stm.executeQuery(spl);
			while (rs.next()) {
				int ms = rs.getInt("Maso");
				String ht = rs.getString("Hoten");
				String nsinh = rs.getString("ngaysinh");
				String dc = rs.getString("diachi");
				String gtinh = rs.getString("gioitinh");
				System.out.print(ms + " " + ht + " " + nsinh + " " + dc + " "+ gtinh);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
