
public class KiemTraSCP {
	public boolean scp(int n){
		boolean t=false;
		for(int i=1; i<=n/2; i++) 
			if(i*i==n) t=true;
		return t;
	}
	public static void main(String[] args) {
		KiemTraSCP dt = new KiemTraSCP();
		if(dt.scp(16)==true) System.out.println("Day la so chinh phuong");
		else System.out.println("Day khong phai la so chinh phuong");
	}

}
