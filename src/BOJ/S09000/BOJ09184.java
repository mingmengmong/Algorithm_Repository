package BOJ.S09000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ09184 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int[][][] dp = new int[101][101][101];
	
	static int w(int a, int b, int c){
		if(dp[a+50][b+50][c+50] != 0) return dp[a+50][b+50][c+50];
		if (a <= 0 || b <= 0 || c <= 0) return dp[a+50][b+50][c+50] = 1;
		if (a > 20 || b > 20 || c > 20) return dp[a+50][b+50][c+50] = w(20, 20, 20);
		if (a < b && b < c) return dp[a+50][b+50][c+50] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		return dp[a+50][b+50][c+50] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
	
	public static void BOJ09184(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		while(true){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			bw.write(String.format("w(%d, %d, %d) = %d\n", a,b,c,w(a,b,c)));
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}