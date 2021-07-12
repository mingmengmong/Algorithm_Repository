package BOJ.S01000;

import java.util.Scanner;

public class BOJ01890 {
    int n;
    int[][] arr;
    long[][] checkArr;

    int[] NR = {0, 1};
    int[] NC = {1, 0};

    public void start(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        checkArr = new long[n][n];
        for(int i=0; i<n; ++i)
            for(int j=0; j<n; ++j) {
                arr[i][j] = sc.nextInt();
                checkArr[i][j] = -1;
            }
        checkArr[n-1][n-1] = 1;

        System.out.println(find(0, 0));

        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                System.out.print(checkArr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public long find(int r, int c){
        if(checkArr[r][c] >= 0)
            return checkArr[r][c];
        else{
            long check = 0;
            for(int i=0; i<2; ++i){
                if(arr[r][c] == 0)
                    break;
                int nr = r + NR[i]*arr[r][c];
                int nc = c + NC[i]*arr[r][c];

                if(nr >= n || nc >=n)
                    continue;
                check += find(nr, nc);
            }
            return checkArr[r][c] = check;
        }
    }
}
