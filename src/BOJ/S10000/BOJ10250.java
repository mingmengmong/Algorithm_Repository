package BOJ.S10000;

import java.util.Scanner;

public class BOJ10250 {
    public void boj10250(){
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for(int t=0; t<testcase; ++t){
            int h = sc.nextInt(), w = sc.nextInt(), n = sc.nextInt() - 1;
            int nh = n%h + 1, nw = n/h + 1;

            String result = "";
            result += nh;
            if(nw < 10)
                result += "0";
            result += nw;

            System.out.println(result);
        }
        sc.close();
    }
}
