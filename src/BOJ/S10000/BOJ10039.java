package BOJ.S10000;

import java.util.Scanner;

public class BOJ10039 {
    public void boj10039(){
        Scanner sc = new Scanner(System.in);

        int avg = 0;
        for(int i=0; i<5; ++i){
            int n = sc.nextInt();
            if(n<40)
                n = 40;
            avg += n;
        }
        avg /= 5;
        System.out.println(avg);

        sc.close();
    }
}
