package BOJ.S02000;

import java.util.Scanner;

public class BOJ02577 {
    public void boj02577(){
        Scanner sc = new Scanner(System.in);

        int num = 1;
        num *= sc.nextInt();
        num *= sc.nextInt();
        num *= sc.nextInt();

        String str = String.valueOf(num);
        int length = str.length();
        int[] arr = {0,0,0,0,0,0,0,0,0,0};

        for(int i=0; i<length; ++i){
            ++arr[str.charAt(i)-'0'];
        }
        for(int i:arr){
            System.out.println(i);
        }

        sc.close();
    }
}
