
public class SoNguyenTo extends KiemTraSNT {
	public void songto(int n){
		KiemTraSNT t = new KiemTraSNT();
		for(int i=1; i<=n; i++)
			if(t.snt(i)==true) System.out.print(i+", ");
	}
	public static void main(String[] args) {
		SoNguyenTo dt = new SoNguyenTo();
		dt.songto(100);
	}

}
