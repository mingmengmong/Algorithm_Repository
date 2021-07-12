package BOJ.S01000;

import java.util.Scanner;

public class BOJ01065 {
    public void boj01065(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        for(int i=1; i<=n; ++i){
            String num = String.valueOf(i);
            int length = num.length();
            if(length >= 2) {
                int d = num.charAt(0) - num.charAt(1);
                boolean check = true;
                for (int j = 1; j < length - 1; ++j) {
                    int td = num.charAt(j) - num.charAt(j+1);
                    if(d != td){
                        check = false;
                        break;
                    }
                }
                if(check){
                    ++count;
                }
            }else{
                ++count;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
