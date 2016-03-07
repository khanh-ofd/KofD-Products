
public class Fibonaxi {
	public void sofib(int n){
		int a=1, b=1, c=0;
		if(n==1) System.out.println("1");
		if(n==2) System.out.println("1 1");
		if(n>=3){
			System.out.print("1 1 ");
			for(int i=3; i<=n; i++){
				c=a+b;
				a=b;
				b=c;
				System.out.print(c+" ");
			}
		}
	}
	public static void main(String[] args) {
		Fibonaxi dt = new Fibonaxi();
		dt.sofib(5);
	}

}
