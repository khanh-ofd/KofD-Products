
public class SoTrungGian {
	public void stg(int a, int b, int c){
		if((a>=b&&a<=c)||(a<=b&&a>=c)) System.out.println("So trung gian la: "+a);
		if((b>=a&&b<=c)||(b<=a&&b>=c)) System.out.println("So trung gian la: "+b);
		if((c>=a&&c<=b)||(c<=a&&c>=b)) System.out.println("So trung gian la: "+c);
	}
	public static void main(String[] args) {
		SoTrungGian dt = new SoTrungGian(); 
		dt.stg(1, 0, 2);
		dt.stg(1, 2, 3);
		dt.stg(3, 1, 2);
	}

}
