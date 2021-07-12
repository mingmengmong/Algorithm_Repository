package BOJ.S02000;

import java.util.Scanner;

public class BOJ02163 {
    public void boj02163(){
        Scanner sc = new Scanner(System.in);

        int r=sc.nextInt(), c=sc.nextInt();
        int sum = r-1;
        for(int i=1; i<c; ++i){
            sum += r;
        }
        System.out.println(sum);

        sc.close();
    }
}
