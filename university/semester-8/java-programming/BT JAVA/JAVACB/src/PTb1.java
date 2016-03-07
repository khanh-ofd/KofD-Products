
public class PTb1 {
	public void ptb1(float a, float b){
		if(a==0) if(b==0) System.out.println("Phuong trinh co vo so nghiem");
					else System.out.println("Phuong trinh vo nghiem");
		else System.out.println("Phuong trinh co nghiem x = "+(-b)/a);
	}
	public static void main(String[] args) {
		PTb1 dt = new PTb1();
		dt.ptb1(0, 0);
		dt.ptb1(0, 1);
		dt.ptb1(1, 3);
	}

}
