package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ11047 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void BOJ11047(String[] args) throws Exception {
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; ++i){
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;
		while(K > 0){
			int m = findMax(arr, N, K);
			while(K >= m){
				K -= m;
				++cnt;
			}
		}
		System.out.println(cnt);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int findMax(int[] arr, int size, int k){
		for(int i=0; i<size; ++i){
			if(arr[i] > k){
				return arr[i-1];
			}
		}
		return arr[size-1];
	}
}
/*

4 1 3 3 1
5 3 5 1 3 10
7 2 1 4 5 1 2 3
7 2 1 4 5 0 3 3
0

*/


/*

0 1 2 3 4 5 6 7

			0~7
			1
		0~3     4~7
		2       3
	0~1  2~3  4~5  6~7
	4    5     6     7
    0 1  2  3  4  5  6  7
    8 9  10 11 12 13 14 15
    
                0~10
                 1
           0~5         6~10
            2            3
      0~2    3~5    6~8    9~10
       4      5      6       7
	0~1 2   3~4 5  6~7 8  9    10
	 8  9   10  11 12  13 14   15
   0  1     3 4    6 7
   16 17   18 19  20 21
 */