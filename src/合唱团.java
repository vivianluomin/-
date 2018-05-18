
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

class student{
	public long ability;
	public student(long ability){
		this.ability = ability;
	}
}

public class 合唱团 {
	

	public static long MAX_VALUE = Long.MAX_VALUE;
	public static long MIN_VALUE = Long.MIN_VALUE;
	
	public static void main(String[] args) {
	
		long Max = getMax();
		System.out.println(Max);
	
	}
	
	
	public static long getMax(){
		List<student> lits = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long abil;
		

		for(int i = 0;i<n;i++){
			abil = in.nextLong();
			student s = new student(abil);
			lits.add(s);
			
		}
		
		int k = in.nextInt();
		int d = in.nextInt();
		

		long [][] fMax = new long[k][n];
		long [][] fMin = new long[k][n];
		long Max = MIN_VALUE;
		
	
		for(int i = 0;i<k;i++){
			for(int j =0;j<n;j++){
				fMax[i][j] = MIN_VALUE;
				fMin[i][j] = MAX_VALUE;
			}
		}
		
		

		for(int i = 0 ;i<n;i++){
			fMax[0][i] = lits.get(i).ability;
			fMin[0][i] = lits.get(i).ability;
		}
		
		for(int i = 1 ;i<k;i++){
			
			for(int j = i;j<n;j++){
				long max = MIN_VALUE;
				long min = MAX_VALUE;
				long temp;

				for(int t = Math.max(i-1, j-d);t<j;t++){
					temp = Math.max(fMax[i-1][t]*lits.get(j).ability, fMin[i-1][t]*lits.get(j).ability);
					if(max<temp){
						max = temp;
					}
					temp = Math.min(fMax[i-1][t]*lits.get(j).ability, fMin[i-1][t]*lits.get(j).ability);
					
					if(min>temp){
						min=temp;
					}
				}
				
				fMax[i][j] = max;
				fMin[i][j] = min;
				
			}
		}
		
		
		
		for(int i = k-1 ;i<n;i++){
		
			if(Max<fMax[k-1][i]){
				Max = fMax[k-1][i];
			}
			
		}
		
		
		return Max;
			
		}
	
		

}
