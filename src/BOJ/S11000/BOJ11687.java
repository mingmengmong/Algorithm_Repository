package BOJ.S11000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11687 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN=100_000_000;
	
	public static void BOJ11687(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		
		int right = N * 5, left = 0, cnt = 0;
		
		while(left <= right){
			cnt = 0;
			int n = (left+right) >>> 1;
			n -= n % 5;
			int mid = n;
			while(n > 0){
				int nn = n / 5;
				cnt += nn;
				n = nn;
			}
			
			System.out.printf("(%d,%d,%d) %d\n", left,mid,right,cnt);
			
			if(cnt < N) left = mid+5;
			else if(cnt == N) {
				left = mid;
				break;
			}
			else right = mid - 5;
		}
		
		if(cnt == N) System.out.println(left);
		else System.out.println(-1);
		
		sc.close();
		bw.close();
		br.close();
	}
}