package BOJ.S01000;

import java.util.Scanner;

public class BOJ01520 {
    public static int N;
    public static int M;

    static int[][] arr;
    static int[][] checkArr;

    public static int[] ud = {1, 0, -1, 0};
    public static int[] rl = {0, 1, 0, -1};

    public static void BOJ01520(){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for(int i=0; i<N; ++i)
            for(int j=0;j<M;++j)
                arr[i][j] = sc.nextInt();

        checkArr = new int[N][M];
        for(int i=0; i<N; ++i)
            for(int j=0; j<M; ++j)
                checkArr[i][j] = -1;
        checkArr[N-1][M-1] = 1;
        System.out.println(find(0,0));

        sc.close();
    }

    public static int find(int r, int c){
        if(checkArr[r][c] >= 0)
            return checkArr[r][c];
        else{
            int check = 0;
            for(int i=0; i<4; ++i){
                int nr = r + rl[i];
                int nc = c + ud[i];

                if(nr < 0 || nr == N || nc < 0 || nc == M)
                    continue;
                if(arr[nr][nc] < arr[r][c])
                    check += find(nr, nc);
            }
            return checkArr[r][c] = check;
        }
    }
}
