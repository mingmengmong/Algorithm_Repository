package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01215 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ01215(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
//		long sum = 0;
//		for(int i=1; i<=n; ++i){
//			sum += k%i;
//		}
//		System.out.println(sum);
//		System.out.println();
		
		
		long sum2 = 0;
		int sqrtK = (int) Math.sqrt(k);
//		System.out.println("sqrtK : " + sqrtK);
		if(n >= k){
			sum2 += (long)k * (long)(n-k);
			for(int i=1; i<sqrtK; ++i){
				int right = k/i;
				int left = k/(i+1) + 1;
				int mod = k%right;
				
//				System.out.printf("[%d, %d, %d, %d]\n", left,right,mod,i);
//				System.out.println(sum2);
//				if(right == 20950){
//					System.out.println(sigma(left, right, mod, i));
//				}
				
				sum2 += sigma(left, right, mod, i);
			}
			int min = Math.min(k/sqrtK, n);
			for(int i=1; i<=min; ++i){
				sum2 += k%i;
			}
			System.out.println(sum2);
		}else{
			for(int i=1; i<sqrtK && i<=n; ++i){
				int right = Math.min(k/i, n);
				int left = k/(i+1) + 1;
				int mod = k%right;
				
//				System.out.printf("[%d, %d, %d, %d] = %d\n", left,right,mod,i, sigma(left,right,mod,i));
				
				sum2 += sigma(left, right, mod, i);
			}
			int min = Math.min(k/sqrtK, n);
//			System.out.println("min : " + min);
			for(int i=1; i<=min; ++i){
				sum2 += k%i;
			}
			System.out.println(sum2);
		}
		
		
		
		
//		int sum = 0;
//		for(int i=1; i<=200; ++i){
//			int n = 200%i;
//			System.out.printf("%3d / 200 = %3d + %3d\n", i, 200/i, 200%i);
//			sum += n;
//		}
//		System.out.println();
//		System.out.println(sum);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static long sigma(int start, int end, int first, int ratio){
		if(start > end){
			return 0L;
		}
		long length = end - start + 1;
//		if(end == 20950){
//			System.out.println("----------------------");
//			System.out.println((long)first * length);
//			System.out.println((long)ratio * (length-1L) * length / 2L);
//
//			System.out.println(sum);
//			System.out.println("----------------------");
//		}
		long sum = (long)first * length + (long)ratio * (length-1L) * length / 2L;
		return sum;
//		return (long) ((long)first * length + (long)ratio * (length-1L) * length / 2L);
	}
}