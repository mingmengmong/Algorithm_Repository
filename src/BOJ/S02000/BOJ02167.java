package BOJ.S02000;

import java.util.Scanner;

public class BOJ02167 {
    public void boj02167(){
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt(), col = sc.nextInt();
        int[][] arr = new int[row][col];
        for(int i=0; i<row; ++i)
            for(int j=0; j<col; ++j)
                arr[i][j] = sc.nextInt();

        int testcase = sc.nextInt();
        for(int t=0; t<testcase; ++t){
            int i = sc.nextInt() - 1, j = sc.nextInt() - 1;
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            int sum =0;
            for(int r=i; r<=x; ++r)
                for(int c=j; c<=y; ++c)
                    sum += arr[r][c];
            System.out.println(sum);
        }

        sc.close();
    }
}
