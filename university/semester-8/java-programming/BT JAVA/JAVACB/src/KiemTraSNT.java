
public class KiemTraSNT {
	public boolean snt(int n){
		boolean t=false;
		int kt=0;
		for(int i=1; i<=n; i++) if(n%i==0) kt++;
		if(kt==2) t=true;
		else t=false;
		return t;
	}
	public static void main(String[] args) {
		KiemTraSNT dt = new KiemTraSNT();
		if(dt.snt(5)==true) System.out.println("La so nguyen to");
		else System.out.println("Khong phai la so nguyen to");
	}

}
