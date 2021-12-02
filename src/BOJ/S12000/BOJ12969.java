import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ12969 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, K, MAX=30;
	static boolean[][][][] visit = new boolean[MAX+1][MAX+1][MAX+1][(MAX*(MAX-1))>>>1];
	static char[] res = new char[MAX+1];
	
	static boolean dfs(int n, int aCnt, int bCnt, int k){
		if(n == N){
			return k == K;
		}
		
		if(visit[n][aCnt][bCnt][k]) return false;
		visit[n][aCnt][bCnt][k] = true;
		
		res[n] = 'A';
		if(dfs(n+1, aCnt+1, bCnt, k)) return true;
		
		res[n] = 'B';
		if(dfs(n+1, aCnt, bCnt+1, k+aCnt)) return true;
		
		res[n] = 'C';
		if(dfs(n+1, aCnt, bCnt, k+aCnt+bCnt)) return true;
		
		return false;
	}
	
	public static void BOJ12969(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(dfs(0,0,0,0)) System.out.println(String.valueOf(res).trim());
		else System.out.println(-1);
		
		br.close();
		bw.close();
		sc.close();
	}
}