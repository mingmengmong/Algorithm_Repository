package BOJ.S01000;

import java.util.Scanner;

public class BOJ01193 {
    public void boj01193(){
        Scanner sc = new Scanner(System.in);
        /*
        1  2 3 4
        1  2 6 7
        3  5 8
        4  9
        10
         */

        int n = sc.nextInt();
        if(n == 1){
            System.out.println("1/1");
        }else {

            int r = 1;
            int sum = 1;

            while(sum < n) {
                ++r;
                sum += r;
            }
            sum = sum - r + 1;
            int d = n - sum;

            int n1 = 1, n2 = r;
            for(int i=0; i<d; ++i, ++n1, --n2);
            if(r%2 == 0){
                System.out.println(n1 + "/" + n2);
            }else{
                System.out.println(n2 + "/" + n1);
            }
        }

        sc.close();
    }
}
