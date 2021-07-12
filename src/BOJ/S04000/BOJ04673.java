package BOJ.S04000;

import java.util.Scanner;

public class BOJ04673 {
    public static int[] arr = new int[10001];

    public static void selfNumber(int num){
        int nextNum = num;
        int n = num;
        while(n != 0) {
            nextNum += n % 10;
            n /= 10;
        }
        if(nextNum <= 10000 && arr[nextNum] == 0) {
            arr[nextNum] = 1;
            selfNumber(nextNum);
        }
    }

    public static void boj04673(){
        Scanner sc = new Scanner(System.in);

        for(int i=1; i<=10000; ++i){
            if(arr[i] == 0){
                System.out.println(i);
                selfNumber(i);
            }
        }

        sc.close();
    }
}
