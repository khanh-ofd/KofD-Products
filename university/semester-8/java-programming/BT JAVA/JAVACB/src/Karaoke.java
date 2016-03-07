
public class Karaoke {
	public int kara(int a, int b){
		int tien;
		if(b<=18) tien = (b-a)*45000;
		else if(a<18) tien = (18-a)*45000 + (b-18)*60000;
			else tien = (b-a)*60000;
		return tien;
	}
	public static void main(String[] args) {
		Karaoke dt = new Karaoke();
		System.out.println("So tien phai tra tu 12-18h: "+dt.kara(12, 18));
		System.out.println("So tien phai tra tu 12-20h: "+dt.kara(12, 20));
		System.out.println("So tien phai tra tu 19-24h: "+dt.kara(19, 24));
	}

}
