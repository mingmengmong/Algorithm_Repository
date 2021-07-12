package BOJ.S01000;

import java.util.Scanner;

public class BOJ01932 {
    public void boj01932(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] inArr = new int[N][N];
        int[][] arr = new int[N][N];
        for(int i=0; i<N; ++i)
            for(int j=0; j<=i; ++j)
                inArr[i][j] = sc.nextInt();


        arr[0][0] = inArr[0][0];
        for(int i=1; i<N; ++i){
            for(int j=0; j<=i; ++j){
                if(j==0)
                    arr[i][j] = arr[i-1][j] + inArr[i][j];
                else if(j==i)
                    arr[i][j] = arr[i-1][j-1] + inArr[i][j];
                else
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-1]) + inArr[i][j];
            }
        }

        int result = 0;
        for(int i=0; i<N; ++i){
            result = Math.max(result, arr[N-1][i]);
        }

        System.out.println(result);

        sc.close();
    }
}
