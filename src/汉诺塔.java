

public class 汉诺塔 {

	public static void main(String[] args) {
		int[] A = {0,1,2,3};
		int B[] = new int[4];
		int C[] = new int[4];
		
		HanoiTower(A,B,C,3);
	}
	
	public static void HanoiTower(int []A,int B[],int C[],int n){
		if(n == 1){
			C[n] = A[n];
			for(int i = 0;i<C.length;i++){
				System.out.print(C[i]+"  ");
			}
			System.out.println("");
		}else{
			HanoiTower(A,C,B,n-1);
			C[n]=A[n];
			System.out.println("��A->C,"+C[n]);
			HanoiTower(B,A,C,n-1);
			
		}
		
	}

}
