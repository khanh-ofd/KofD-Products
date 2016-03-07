
public class ChuSo {
	public void tinh(int m){
		int s=0, p=1, n;
		do {
			n=m%10;
			s+=n; p*=n;
			m=m/10;
		} while(m!=0);
		System.out.println("Tong la: "+s);
		System.out.println("Tich la: "+p);
	}
	public static void main(String[] args) {
		ChuSo dt = new ChuSo();
		dt.tinh(364);
	}

}
