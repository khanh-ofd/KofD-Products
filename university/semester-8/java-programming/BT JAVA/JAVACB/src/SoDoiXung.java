
public class SoDoiXung {
	public void sdx(int n){
		int m=0, t=n;
		while(t>0){
			m = m*10 + t%10;
			t/=10;
		}
		if(m==n) System.out.println("Day la so doi xung");
		else System.out.println("Day khong phai la so doi xung");
	}
	public static void main(String[] args) {
		SoDoiXung dt = new SoDoiXung();
		dt.sdx(454);
		dt.sdx(123);
	}

}
