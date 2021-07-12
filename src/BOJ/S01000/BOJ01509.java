package BOJ.S01000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01509 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int MAX = 2500, length;
	public static String str;
	public static boolean[][] dp = new boolean[MAX+1][MAX+1];
	
	public static void BOJ01509(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		sc = new Scanner(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		str = " " + br.readLine();
		length = str.length()-1;
		
		// make 팰린드롬
		long C = 0;
		for(int i=1; i<=length; ++i) {
			dp[i][i] = true;
			++C;
		}
		for(int i=1; i<length; ++i)
			if(str.charAt(i) == str.charAt(i+1)) {
				dp[i][i + 1] = true;
				++C;
			}
		for(int leng=2; leng<length; ++leng){
			for(int left=1; left+leng<=length; ++left){
				int right = left+leng;
				if(str.charAt(left) == str.charAt(right) && dp[left+1][right-1]){
					dp[left][right] = true;
					++C;
				}
			}
		}
		
		// 팰린드롬 갯수
		System.out.println("팰린드롬 갯수 : " + C);
		
		long[] cnt = new long[length+1];
		Arrays.fill(cnt, Long.MAX_VALUE);
		cnt[0] = 0;
		for(int r=1; r<=length; ++r){
			for(int l=1; l<=r; ++l){
				if(dp[l][r]){
					cnt[r] = Math.min(cnt[l-1]+1, cnt[r]);
				}
			}
		}
		
		System.out.println(cnt[length]);
		
		br.close();
		bw.close();
		sc.close();
	}
}