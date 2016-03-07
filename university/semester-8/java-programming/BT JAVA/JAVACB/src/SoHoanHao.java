
public class SoHoanHao {
	public void shh(){
		int sum=0;
		for(int i=1; i<=1000; i++){
			for(int j=1; j<i; j++)
				if(i%j==0) sum+=j;
			if(sum==i) System.out.print(i+", ");
			sum=0;
		}
	}
	public static void main(String[] args) {
		SoHoanHao dt = new SoHoanHao();
		System.out.print("Cac so hoan hao <1000: ");
		dt.shh();
	}

}
