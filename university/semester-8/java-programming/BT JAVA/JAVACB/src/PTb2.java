
public class PTb2 extends PTb1{
	public void ptb2(float a, float b, float c){
		PTb1 t = new PTb1();
		float Delta;
		if(a==0) t.ptb1(b,c);
		else{
			Delta=b*b-4*a*c;
			if(Delta>0) System.out.println("Phuong trinh co 2 nghiem phan biet x1 = "+(-b-Math.sqrt(Delta))/(2*a)+", x2 = "+(-b-Math.sqrt(Delta))/(2*a));
			if(Delta==0) System.out.println("Phuong trinh co nghiem kep x = "+(-b)/(2*a));
			if(Delta<0) System.out.println("Phuong trinh vo nghiem");
		}
	}
	public static void main(String[] args) {
		PTb2 dt = new PTb2();
		dt.ptb2(0, 1, 2);
		dt.ptb2(1, 2, -2);
		dt.ptb2(1, 2, 1);
		dt.ptb2(1, 1, 1);
	}

}
