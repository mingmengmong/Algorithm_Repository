package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ01463 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void BOJ01463(String[] args) throws Exception {
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		System.out.println(find(arr, N));
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int find(int[] arr, int n){
		if(n == 1){
			return 0;
		}
		if(arr[n] != 0){
			return arr[n];
		}
		
		int r = Integer.MAX_VALUE;
		if(n % 3 == 0){
			r = Math.min(r, find(arr, n/3));
		}
		if(n % 2 == 0){
			r = Math.min(r, find(arr, n/2));
		}
		r = Math.min(r, find(arr, n-1));
		
		return arr[n] = r+1;
	}
}