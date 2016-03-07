import java.util.*;
public class Mang_A {
	int A[], n;
	Scanner input = new Scanner(System.in);
	boolean check=true;
	public void nhap(){
		while(check){
			System.out.println("Nhap so luong phan tu mang: ");
			try{
				n=input.nextInt();
				check=false;
			} catch(Exception e){System.out.println("Du lieu khong dung. Nhap lai"); check=true; input.nextLine();}
		}
		check=true;
		A=new int[n];
		while(check){
			System.out.println("Nhap cac phan tu mang");
			try{
				for(int i=0; i<n; i++) A[i]=input.nextInt();
				check=false;
			} catch(Exception e){System.out.println("Du lieu nhap khong dung. Nhap lai");check=true; input.nextLine();}
		}
		check=true;
	}
	public void TongTich(){
		int Tong=0, Tich=1;
		for(int i=0; i<n; i++)
			if(A[i]%2==0){
				Tong+=A[i];
				Tich*=A[i];
			}
		System.out.println("Tong cac so chan la: "+Tong);
		System.out.println("Tich cac so chan la: "+Tich);
	}
	public void Xoasole(){
		int j=-1;
		for(int i=n-1; i>=0; i--) if(A[i]%2==1) j=i;
		if(j!=-1){
			for(int i=j; i<n-1; i++) A[i]=A[i+1];
			n--;
		}
	}
	public void Sapxep(){
		int tam;
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
				if(A[i]>A[j]){
					tam=A[i]; A[i]=A[j]; A[j]=tam;
				}
	}
	public void Chen(){
		int j=-1,b=0;
		while(check){
			System.out.println("Nhap gia tri muon chen: ");
			try{
				b=input.nextInt();
				check=false;
			} catch(Exception e){System.out.println("Du lieu khong dung. Nhap lai");check=true;input.nextLine();}
		}
		check=true;
		n=n+1;
		A[n-1]=0;
		for(int i=n-1; i>=0; i--) 
			if(A[i]>b) j=i; 
		if(j==-1) A[n-1]=b;
		else{
			for(int i=n-1; i>j; i--) A[i]=A[i-1];
			A[j]=b;
		}
	}
	public void Xuat(){
		System.out.print("Mang A: ");
		for(int i=0; i<n; i++) System.out.print(A[i]+" ");
	}
	public static void main(String[] args) {
		Mang_A dt = new Mang_A();
		dt.nhap();
		dt.TongTich();
		dt.Xoasole();
		dt.Sapxep();
		dt.Chen();
		dt.Xuat();
	}

}
