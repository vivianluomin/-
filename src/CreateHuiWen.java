

public class CreateHuiWen {

	public static void main(String[] args) {
		int t = Create("abcda");
		System.out.println(t);
	}
	
	public static int Create(String s){
		char[] chs = s.toCharArray();
		int length = chs.length;
		System.out.println(length);
		int[][] data = new int[length][length];
		int[] flag = new int[length];
		int Max = 1;
		for(int i = 0;i<length;i++){
			flag[i]= 0;
			for(int j = 0;j<length;j++){
				data[i][j] = 0;
			}
		}
		
		data[0][0] = 1;
		flag[0] = 1;
		
		for(int i = 1;i<length;i++){
			for(int j = 0;j<length;j++){
				if(data[j][0]!=0){
				 String temp = getString(data[j],s);
				 temp+=s.charAt(i);
				 System.out.println(temp);
				 if(isHuiWen(temp)){
					 data[j][i] = 1;
					 flag[j]++;
					 if(Max<flag[j]){
						 Max = flag[j];
						 System.out.println(Max);
					 }
				 }else{
					 data[i][0] = 1;
					 flag[i] =1;
				 }
				}
			}
		}
		
		
		return length-Max;
	}
	
	public static String getString(int[] data,String s){
		String ss = "";
		for(int i = 0;i<data.length;i++){
			if(data[i]!=0){
				ss+=s.charAt(i);
			}
		}
		
		return ss;
	}
	
	public static boolean isHuiWen(String chs){
		
		char[] s = chs.toCharArray();
		int i = 0;
		int j = s.length-1;
		while(i<j){
			if(s[i]!=s[j]){
				return false;
			}
			
			i++;
			j--;
		}
		
		return true;
		
	}

}
