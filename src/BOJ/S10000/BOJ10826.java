package BOJ.S10000;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ10826 {
    public void bos10826(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n < 2){
            System.out.println(n);
        }else {

            BigInteger num1 = new BigInteger("0");
            BigInteger num2 = new BigInteger("1");
            BigInteger addNum = null;
            for (int i = 2; i <= n; ++i) {
                addNum = num1.add(num2);
                num1 = num2;
                num2 = addNum;
            }

            System.out.println(addNum);
        }
    }
}
