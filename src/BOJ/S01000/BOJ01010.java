package BOJ.S01000;

import java.util.Scanner;

public class BOJ01010 {
    public void boj01010(){
        Scanner sc = new Scanner(System.in);

        /*
           0 1 2 3 4 5  6 7 8 9
        0  0 0 0 0 0 0  0 0 0 0
        1    1 2 3 4 5  6 7 8 9
        2      1 3 6 10
        3        1 4 10
         */
        int testcase = sc.nextInt();
        for(int t=0; t<testcase; ++t) {
            int N = sc.nextInt(), M = sc.nextInt();
            if (N == 0) {
                System.out.println(0);
            } else {
                int[][] arr = new int[N + 1][M + 1];
                for (int i = 0; i <= M; ++i)
                    arr[0][i] = 1;
                for (int i = 1; i <= N; ++i)
                    arr[i][i] = 1;
                for (int i = 1; i <= N; ++i)
                    for (int j = 2; j <= M; ++j)
                        arr[i][j] = arr[i - 1][j - 1] + arr[i][j - 1];

                System.out.println(arr[N][M]);
            }
        }

        sc.close();
    }
}
