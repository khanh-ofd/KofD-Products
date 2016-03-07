
public class Tong7 {
	public float tong(int n){
		float s=15;
		int mau=1, dau=-1;
		for(int i=1; i<=n; i++){
			mau*=i;
			s+= (float) dau/mau;
			dau*=-1;
		}
		return s;
	}
	public static void main(String[] args) {
		Tong7 dt = new Tong7();
		System.out.println("Tong la: "+dt.tong(3));
	}

}
