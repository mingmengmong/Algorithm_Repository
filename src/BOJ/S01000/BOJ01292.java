package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01292 {
	public static void BOJ01292(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int[] arr = new int[1001];
		for(int i=1, index=1; i<=45 && index<=1000; ++i){
			for(int j=0; j<i && index<=1000; ++j, ++index){
				arr[index] = i;
			}
		}
		
		int s = sc.nextInt();
		int f = sc.nextInt();
		
		int r = 0;
		for(int i=s; i<=f; ++i){
			r += arr[i];
		}
		System.out.println(r);
		
		sc.close();
		br.close();
	}
}