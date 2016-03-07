
public class GiaiThuaKep {
	public int gtkep(int n){
		int s=1;
		for(int i=n; i>=1; i-=2) s*=i;
		return s;
	}
	public static void main(String[] args) {
		GiaiThuaKep dt = new GiaiThuaKep();
		System.out.println("Ket qua: "+dt.gtkep(5));
	}

}
