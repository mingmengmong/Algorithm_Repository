package BOJ.S02000;

import java.util.Scanner;

public class BOJ02775 {
    public void boj02775(){
        Scanner sc = new Scanner(System.in);
        /*
        1 2 3 4  5  6  7 8 9
        1 3 6 10 15 21
         */

        int testcase = sc.nextInt();
        for(int t=0; t<testcase; ++t){
            int k = sc.nextInt(), n = sc.nextInt();
            int[][] arr = new int[k+1][n+1];
            for(int i=0; i<=n; ++i){
                arr[0][i] = i;
            }
            for(int r=1; r<=k; ++r){
                for(int c=1; c<=n;++c){
                    arr[r][c] = arr[r][c-1] + arr[r-1][c];
                }
            }

            System.out.println(arr[k][n]);
        }



        sc.close();
    }
}
