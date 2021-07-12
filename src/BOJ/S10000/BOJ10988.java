package BOJ.S10000;

import java.util.Scanner;

public class BOJ10988 {
    public void boj10988(){
        Scanner sc = new Scanner(System.in);
        String inStr = sc.next();

        int length = inStr.length();

        int s1,s2;
        if(length%2 == 1){
            s1 = length/2 -1;
            s2 = length/2 +1;
        }else{
            s1 = length/2 -1;
            s2 = length/2;
        }


        int check = 1;
        for(;s1>=0; --s1, ++s2){
            if(inStr.charAt(s1) != inStr.charAt(s2)) {
                check = 0;
                break;
            }
        }

        System.out.println(check);
    }
}
