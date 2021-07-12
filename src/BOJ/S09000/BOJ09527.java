package BOJ.S09000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ09527 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static long N, M;
	
	public static long sum(long a){
		long res = 0;
		long num = 1L;
		while(a >= num){
			long next = num << 1;
			long n = a / next;
			res += n * num;
			
			long m = a % next;
			long mm = m / num;
			res += mm * (m - num + 1);
			
			num = next;
		}
		return res;
	}
	
	public static void BOJ09527(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		System.out.println((sum(M) - sum(N-1)));
		
		sc.close();
		bw.close();
		br.close();
	}
}