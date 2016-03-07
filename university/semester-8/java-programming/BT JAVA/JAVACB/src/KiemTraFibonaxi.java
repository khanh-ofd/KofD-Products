
public class KiemTraFibonaxi {
	public void ktfib(int K){
		int a=1,b=1,c=0;
		if(K==1) System.out.println(K+" thuoc day Fibonaxi");
		else
			while(c<K){
				c=a+b;
				a=b;
				b=c;
			}
		if(c==K) System.out.println(K+" thuoc day Fibonaxi");
		else System.out.println(K+ " khong thuoc day Fibonaxi");
	}
	public static void main(String[] args) {
		KiemTraFibonaxi dt = new KiemTraFibonaxi();
		dt.ktfib(8);
		dt.ktfib(9);
	}

}
