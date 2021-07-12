package BOJ.S02000;

import java.util.Scanner;

public class BOJ02839 {
    public void boj02839(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[5001];
        arr[0] = arr[1] = arr[2] = arr[4] = 0;
        arr[3] = arr[5] = 1;

        for(int i=6; i<=n; ++i){
            int n3 = 10000, n5 = 10000;
            if(arr[i-3] != 0)
                n3 = arr[i-3];
            if(arr[i-5] != 0)
                n5 = arr[i-5];

            if(n3 == 10000 && n5 == 10000){
                arr[i] = 0;
            }else {
                arr[i] = Math.min(n3, n5) + 1;
            }
        }
        if(arr[n] == 0)
            System.out.println(-1);
        else
            System.out.println(arr[n]);

        sc.close();
    }
}
