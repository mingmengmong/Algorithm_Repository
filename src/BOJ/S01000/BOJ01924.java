package BOJ.S01000;

import java.util.Scanner;

public class BOJ01924 {
    public void boj01924(){
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        int resultDate = 1;

        for(int i=1; i<month; ++i){
            resultDate += month(i);
        }

        resultDate += day-1;
        resultDate %= 7;
        String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(date[resultDate]);


        sc.close();
    }
    public static int month(int m){
        switch (m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 2:
                return 28;

            default:
                return -1;
        }
    }
}
