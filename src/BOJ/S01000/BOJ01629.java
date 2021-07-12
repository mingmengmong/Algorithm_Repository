package BOJ.S01000;

import java.util.Scanner;

public class BOJ01629 {
    public void boj01629(){
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        int PN = sc.nextInt(), MN = sc.nextInt();

        long mn = 1;
        while(true){

            if(PN == 1){
                break;
            }

            if(PN % 2 == 1)
                mn = (mn * N) % MN;

            N = (N * N) % MN;
            PN /= 2;

        }
        N = (N * mn) % MN;
        System.out.println(N);

        sc.close();
    }
}
