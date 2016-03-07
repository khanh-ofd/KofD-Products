
public class UCBC {
	public int UCLN(int a, int b){
		if(a==0||b==0) return a+b;
		while(a!=b)
			if(a>b) a=a-b;
			else b=b-a;
		return a;
	}
	public int BCNN(int a, int b){
		return (a*b)/UCLN(a,b);	
	}
	public static void main(String[] args) {
		UCBC dt = new UCBC();
		System.out.println(dt.UCLN(0, 10));
		System.out.println(dt.BCNN(5, 6));
	}

}
