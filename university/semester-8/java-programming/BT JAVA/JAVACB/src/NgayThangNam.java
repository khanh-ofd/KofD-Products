
public class NgayThangNam {
	public void ntn(int thang, int nam){
		switch(thang){
		case 4:
		case 6:
		case 9:
		case 11: System.out.println("Thang co 30 ngay"); break;
		case 2:
			if(nam%400==0 || (nam%4==0 && nam%100!=0)) {System.out.println("Thang co 29 ngay"); break;}
			else {System.out.println("Thang co 28 ngay"); break;}
		default: System.out.println("Thang co 31 ngay");
		}
	}
	public static void main(String[] args) {
		NgayThangNam dt = new NgayThangNam();
		dt.ntn(2, 2000);
		dt.ntn(10, 2002);
	}

}
