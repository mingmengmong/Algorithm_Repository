package BOJ.S01000;

import java.util.Scanner;

public class BOJ01475 {
    public void boj01475(){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] arr = new int[10];
        while (num != 0) {
            ++arr[num % 10];
            num /= 10;
        }
        int count = (arr[6] + arr[9] + 1) / 2;
        for(int i=0; i<9; ++i){
            if(i == 6)
                continue;
            count = Math.max(arr[i], count);
        }
        if(count == 0)
            count = 1;
        System.out.println(count);
    }
}
