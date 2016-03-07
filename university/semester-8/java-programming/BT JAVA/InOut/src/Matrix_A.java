import java.util.*;
public class Matrix_A {
	long A[][],X[];
	int m,n;
	Scanner input = new Scanner(System.in);
	boolean check=true;
	public void Nhap(){
		while(check==true){
			System.out.println("Nhap so dong, so cot (m,n)=[3,7]: ");
			try{ 
				do{
					m=input.nextInt();
					n=input.nextInt();
					check=false;
					if(m<3||m>7||n<3||n>7) System.out.println("So dong, so cot !=[3,7]. Nhap lai");
				}while(m<3||m>7||n<3||n>7);
			}catch(Exception e){System.out.println("Du lieu nhap khong dung. Nhap lai"); check=true; input.nextLine();}
		}
		check=true;
		A=new long[m][n];
		while(check){
			System.out.println("Nhap cac phan tu ma tran");
			try{
				for(int i=0; i<m; i++)
					for(int j=0; j<n; j++)
						A[i][j]=input.nextLong();
				check=false;
			}catch(Exception e){System.out.println("Du lieu nhap khong dung. Nhap lai"); check=true; input.nextLine();}
		}
		check=true;
	}
	public void Demsoboi3(){
		int dem=0;
		for(int i=0; i<m; i++)
			if(A[i][1]%3==0) dem+=1;
		System.out.println("So cac so boi 3 tren cot 1 la: "+dem);
	}
	public void Mang1chieu(){
		X=new long[m];
		long max=0;
		for(int i=0; i<m; i++){
			max=A[i][0];
			for(int j=1; j<n; j++) if(A[i][j]>max) max=A[i][j];
			X[i]=max;
		}
	}
	public void KiemtraK(){
		long K=0;
		boolean t=false;
		int j=0;
		while(check){
			System.out.println("Nhap phan tu K: ");
			try{
				K=input.nextLong();
				check=false;
			}catch(Exception e){System.out.println("Du lieu khong dung. Nhap lai"); check=true; input.nextLine();}
		}
		check=true;
		for(int i=m-1; i>=0; i--)
			if(X[i]==K){t=true; j=i;}
		if(t==true) System.out.println(K+" co trong X, vi tri xuat hien dau tien la "+j);
		else System.out.println(K+" khong xuat hien trong X");
	}
	public void Sapxep(){
		long tam=0;
		for(int i=0; i<m; i++)
			for(int j=i+1; j<m; j++)
				if(X[i]<X[j]){tam=X[i]; X[i]=X[j]; X[j]=tam;}
	}
	public void Xuat(){
		System.out.print("Mang X: ");
		for(int i=0; i<m; i++) System.out.print(X[i]+" ");
	}
	public static void main(String[] args) {
		Matrix_A dt = new Matrix_A();
		dt.Nhap();
		dt.Demsoboi3();
		dt.Mang1chieu();
		dt.KiemtraK();
		dt.Sapxep();
		dt.Xuat();

	}

}
