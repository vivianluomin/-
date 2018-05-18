package 算法训练;

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
		
		//输入数据
		for(int i = 0;i<n;i++){
			abil = in.nextLong();
			student s = new student(abil);
			lits.add(s);
			
		}
		
		int k = in.nextInt();
		int d = in.nextInt();
		
		//维护的两个最大值和最小值的数组，k表示选择几个学生，n表示第k个选取的学生
		//所以fMax[k][n]的乘积就是选择k个学生且第k个学生是n的时候的最大值
		long [][] fMax = new long[k][n];
		long [][] fMin = new long[k][n];
		long Max = MIN_VALUE;
		
	
		for(int i = 0;i<k;i++){
			for(int j =0;j<n;j++){
				fMax[i][j] = MIN_VALUE;
				fMin[i][j] = MAX_VALUE;
			}
		}
		
		
		//初始化选取一个的时候的最大最小值
		for(int i = 0 ;i<n;i++){
			fMax[0][i] = lits.get(i).ability;
			fMin[0][i] = lits.get(i).ability;
		}
		
		for(int i = 1 ;i<k;i++){
			
			for(int j = i;j<n;j++){
				long max = MIN_VALUE;
				long min = MAX_VALUE;
				long temp;
				//在j的d范围内可以选取的前i-1个的最大值
				//因为乘法交换律，所以每次只考虑当前元素的左侧有效范围
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
