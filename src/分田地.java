import java.util.HashSet;
import java.util.Scanner;

public class 分田地 {


    public static int cal(int x,int y,int i,int j,int[][] sum){
        return sum[x][y] - sum[x][j] -sum[i][y]+sum[i][j];
    }
    public static boolean jujce(int x,int n,int m,int[][] sum){

        for(int i = 1;i<=m-3;i++){
            for(int j = i+1;j<=m-2;j++){
                for(int k = j+1;k<=m-1;k++){
                    int last = 0;
                    int cnt = 0;
                    for(int r = 1;r<=n;r++){
                        int n1 = cal(r,i,last,0,sum);
                        int n2 = cal(r,j,last,i,sum);
                        int n3 = cal(r,k,last,j,sum);
                        int n4 = cal(r,m,last,k,sum);
                        if(n1>=x&&n2>=x&&n3>=x&&n4>=x){
                            last = r;
                            cnt++;
                        }
                    }

                    if(cnt >=4){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] filed = new int[n][m];
        for(int i = 0;i<n;i++){
            char[] s = in.next().toCharArray();
            for(int j = 0;j<m;j++){
                filed[i][j] = s[j]-'0';
            }
        }
        int[][] sum = new int[n+1][m+1];
        for(int i = 0;i<=m;i++){
            sum[0][i] = 0;
        }
        for (int i =0;i<=n;i++){
            sum[i][0] = 0;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+filed[i-1][j-1];
            }
        }
        int left = 0;
        int right = sum[n][m];
        int res = 0;
        while (left<=right){
            int x = (left+right)/2;
            if(jujce(x,n,m,sum)){
                left = x +1;
                res = x;
            }else {
                right = x -1;
            }
        }

        System.out.println(res);
    }
}
