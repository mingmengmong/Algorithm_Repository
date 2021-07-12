package BOJ.S08000;

import java.util.Scanner;

public class BOJ08958 {
    public void boj08958(){
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for(int t=0; t<testcase; ++t){
            String OXstr = sc.next();
            int length = OXstr.length();
            int sum = 0;
            int point = 0;
            for(int i=0; i<length;++i){
                char OX = OXstr.charAt(i);
                if(OX == 'O'){
                    ++point;
                }else{
                    point = 0;
                }
                sum += point;
            }
            System.out.println(sum);
        }

        sc.close();
    }
}
