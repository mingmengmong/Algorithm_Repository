package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01300 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N,M;
	
	public static void BOJ01300(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		int left = 1, right = M;
		int res = 0;
		while(left <= right){
			int mid = (left + right) >>> 1;
			int cnt = 0;
			for(int r=1; r<=N; ++r){
				cnt += Math.min(mid/r, N);
			}
			
			if(cnt < M){
				left = mid + 1;
			}else{
				res = mid;
				right = mid - 1;
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}