import java.util.HashSet;
import java.util.Scanner;

public class 下厨房 {

    public static void main(String[] args){
        HashSet<String> sets = new HashSet<>();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] ss = s.split(" ");
            for(int i =0;i<ss.length;i++){
                sets.add(ss[i]);
            }
        }

        System.out.println(sets.size());
    }
}
