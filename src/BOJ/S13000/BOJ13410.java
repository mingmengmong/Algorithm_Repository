package BOJ.S13000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ13410 {
    public void boj13410(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();
        List<Integer> arr = new ArrayList<Integer>();

        for(int i=1; i<=K; ++i){
            String str = "" + (N*i);
            String rstr = "";
            int length = str.length();
            for(int j=0; j<length; ++j){
                rstr += str.charAt(length - j - 1);
            }
            arr.add(Integer.parseInt(rstr));
        }
        int max = 0;
        for(int i:arr){
            if(max < i)
                max = i;
        }
        System.out.println(max);

        sc.close();
    }
}
