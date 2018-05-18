

public class 二维数组查找 {

	public static void main(String[] args) {
		
		int[][] array = {
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		
	Find(7,array);
		
	}

	public static boolean Find(int target, int [][] array) {
	        
		int i = array.length-1;
		int j = array[0].length-1;
		int k = 0;
		
		System.out.println(i+"   "+j);
		while(i>=0&&k<=j){
			if(target>array[i][k]){
				k++;
			}else if(target < array[i][k]){
				i--;
			}else{
				System.out.println(i+"  "+k);
				return true;
			}
		}
	        
	       return false; 
	}
}
