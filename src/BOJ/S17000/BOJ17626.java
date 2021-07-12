package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17626 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] arr = new int[50001];
	
	// 223^2 = 49729
	public static void BOJ17626(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		System.out.println(fourSquares(n));
		
		sc.close();
		bw.close();
		br.close();
	}
	public static int fourSquares(int n){
		if(n == 0){
			return 0;
		}
		if(arr[n] > 0){
			return arr[n];
		}
		int maxI = 0;
		for(int i=0; i<=223; ++i){
			int i2 = i*i;
			if(i2 < n){
				maxI = i;
			}else if(i2 == n){
				return arr[n] = 1;
			}else{
				break;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=maxI; i>=1; --i){
			int i2 = i*i;
			if(i2 <= n){
				int k = fourSquares(n-i2);
				min = Math.min(min, k);
			}else{
				break;
			}
		}
		return arr[n] = min+1;
	}
}