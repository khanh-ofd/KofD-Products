
public class Tong6 {
	public float tong(int n){
		float s=0;
		for(int i=1; i<=n; i++) s+=1.0/i;
		return s;
	}
	public static void main(String[] args) {
		Tong6 dt = new Tong6();
		System.out.println("Ket qua: "+dt.tong(5));
	}

}
