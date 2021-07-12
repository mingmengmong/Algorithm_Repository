package BOJ.S01000;

import java.util.Scanner;

public class BOJ01331 {
    public void boj01331(){
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[6][6];

        String first = sc.next();
        int firstY = first.charAt(0)-'A';
        int firstX = first.charAt(1)-'1';

        int lastX = firstX, lastY = firstY;
        arr[lastX][lastY] = 1;
        String check = "Valid";
        for(int i=1; i<36; ++i){
            String p = sc.next();
            int pY = p.charAt(0)-'A';
            int pX = p.charAt(1)-'1';

            int checkLength = (int)Math.pow(pX-lastX, 2) + (int)Math.pow(pY-lastY, 2);
            if(checkLength != 5){
                check = "Invalid";
                break;
            }
            if(arr[pX][pY] == 1){
                check = "Invalid";
                break;
            }
            arr[pX][pY] = 1;
            lastX = pX;
            lastY = pY;

        }
        int checkLength = (int)Math.pow(firstX-lastX, 2) + (int)Math.pow(firstY-lastY, 2);
        if(checkLength !=5)
            check = "Invalid";

        System.out.println(check);
    }
}
