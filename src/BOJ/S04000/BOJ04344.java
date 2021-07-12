package BOJ.S04000;

import java.util.Scanner;

public class BOJ04344 {
    public void start(){
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for(int t=0; t<testcase;++t){
            int n = sc.nextInt();
            double[] arr = new double[n];
            double avg = 0;
            for(int i=0; i<n; ++i){
                arr[i] = sc.nextDouble();
                avg += arr[i];
            }
            avg /= n;

            int count = 0;
            for(int i=0; i<n; ++i)
                if(arr[i] > avg)
                    ++count;

            System.out.printf("%2.3f%%\n", (double)((double)count * 100d / (double)n));
        }

        sc.close();
    }
}
