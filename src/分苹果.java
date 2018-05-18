import java.util.Scanner;

public class 分苹果 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int add = 0;

        int[] cows = new int[count];
        for(int i =0;i<count;i++){
            cows[i] = in.nextInt();
            add+=cows[i];
        }
        int cnt = 0;
        int avg = add/count;
        System.out.println(avg+"------"+add+"-------"+avg*count);
        if(add-(avg)*count != 0||!ifcan(cows,avg)){
            System.out.println(-1);
        }else {
            int[] value = find(cows);
            while(cows[value[0]]!=cows[value[1]]){
                cows[value[0]]-=2;
                cows[value[1]]+=2;
                cnt++;
                value = find(cows);
            }

            System.out.print(cnt);
        }


    }


    public static int[] find(int[] cows ){
        int[] value = new int[2];
        int max = cows[0];
        int min = cows[0];
        int maxl = 0;
        int minl = 0;
        for(int i = 1;i<cows.length;i++){
            if(cows[i]>max){
                max = cows[i];
                maxl = i;
            }else if(cows[i]<min){
                min = cows[i];
                minl = i;
            }
        }
        value[0] = maxl;
        value[1] = minl;
        return value;
    }

    public static boolean ifcan(int[] cows,int avg){
        for(int i =0;i<cows.length;i++){
            if((Math.abs(cows[i]-avg))%2 != 0){
                System.out.println("------"+i+"-------"+(cows[i]-avg));
                return false;
            }
        }
        return true;
    }

    public static void sort(int[] cows,int left,int right){
       if (left<right){
           int mid= quicksort(cows,left,right);
          // System.out.println(mid);
           sort(cows,left,mid-1);
           sort(cows,mid+1,right);
       }
    }

    public static int quicksort(int[] cows ,int left,int right){
        int l = left;
        int r = right;
        int x = cows[left];
        while (l<r){
            for(;l<=right&&cows[l]>=x;l++);
            for (;r>=left&&cows[r]<x;r--);
            if(l<r){
                int t = cows[l];
                cows[l] = cows[r];
                cows[r] = t;
//                l++;
//                r--;
            }

        }

        int t = cows[r];
        cows[r] = x;
        cows[left] = t;
        return r;
    }
}
