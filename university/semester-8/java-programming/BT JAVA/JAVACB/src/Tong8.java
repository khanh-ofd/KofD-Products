
public class Tong8 {
	public float tong(int n){
		float s=0;
		int mau=1;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=2*i-1; j++) mau*=j;
			s+=1.0/mau;
		}
		return s;
	}
	public static void main(String[] args) {
		Tong8 dt = new Tong8();
		System.out.println("Tong la: "+dt.tong(3));
	}

}
