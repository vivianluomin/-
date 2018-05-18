



import java.util.Scanner;

public class  地牢问题 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int i,j;
		int x = in.nextInt();
		int y = in.nextInt();
		
	
		char[][] map = new char[x][y];
		for(i = 0;i<x;i++){
			String t = in.next();
			map[i] = t.toCharArray();
		}
		
		int x0 = in.nextInt();
		int y0 = in.nextInt();
		int n = in.nextInt();
		//System.out.println(x0+"  "+y0+"  "+n);
		int[][] step = new int[n][2];
		for(i = 0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			step[i][0] = a;
			step[i][1] = b;
		}
		
		int[][] s = new int[x][y];
		for(i = 0;i<x;i++){
			for(j = 0;j<y;j++){
				if(map[i][j] =='.'){
					s[i][j] = -1;
				}else{
					s[i][j] = -2;
				}
				
			}	
		}
		
		
		s[x0][y0] = 0;
		int[] queueX = new int[x*y];
		int[] queueY = new int[x*y];
		int rear = -1;
		int font = -1;
		for(i =0;i<n;i++){
			if(x0+step[i][0]<x&&y0+step[i][1]<y&&x0+step[i][0]>=0
					&&y0+step[i][1]>=0&&map[x0+step[i][0]][y0+step[i][1]]=='.'){
                if(s[x0+step[i][0]][y0+step[i][1]]==-1&&s[x0+step[i][0]][y0+step[i][1]]!=0){
				queueX[++rear] = x0+step[i][0];
				queueY[rear] = y0+step[i][1];
				s[x0+step[i][0]][y0+step[i][1]] = 1;
				System.out.println(x0+step[i][0]+"---------"+(y0+step[i][1]));
                }
			}
		}
		while(rear!=font){
			font++;
			 i = queueX[font];
			j = queueY[font];
			System.out.println(i+"    "+j);
			for(int k =0;k<n;k++){
				if(i+step[k][0]<x&&j+step[k][1]<y&&i+step[k][0]>=0
						&&j+step[k][1]>=0&&map[i+step[k][0]][j+step[k][1]]=='.'){
					if(s[i+step[k][0]][j+step[k][1]]==-1&&s[i+step[k][0]][j+step[k][1]]!=0){
						queueX[++rear] =i+step[k][0];
						queueY[rear] = j+step[k][1];
					s[i+step[k][0]][j+step[k][1]] = s[i][j]+1;
				
					}
					
				}	
			
			}
		}
		
		
		
		int max = s[0][0];
		
		for(int q = 0;q<x;q++){
			for(int p = 0;p<y;p++){
				if(s[q][p] == -1){
					System.out.println(-1);
					return;
				}
				if(max<s[q][p]){
				max = s[q][p];
			}
				
			
			}
			
		}
		
		
		
		System.out.println(max);

	}

}
