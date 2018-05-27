import java.util.Scanner;

public class 星际穿越 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        double h = in.nextLong();
        System.out.println(h);
//        long left = 0;
//        long right = h;
        long x;
//        long t = h;

//        while(left<=right){
//            t = (left+right+1)/2;
//            System.out.println((left+right+1)/2);
//            if((t+t*t)>h){
//                right = t-1;
//                System.out.println("right -------"+right);
//            }else {
//                if((t+t*t)==h){
//                    x = t;
//                    break;
//                }
//                x = t;
//                left = t+1;
//                System.out.println("left -----"+left);
//            }
//        }

        x =(long) Math.sqrt(h);
        if(x+x*x<=h){
            System.out.println(x);
        }else{
            System.out.println(x-1);
        }


    }

}
