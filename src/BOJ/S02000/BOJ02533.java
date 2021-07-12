package BOJ.S02000;
import java.io.*;
import java.util.*;

public class BOJ02533 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN=1_000_000;
	// dp1 : i = no early adaptor / dp2 : i = early adaptor
	public static int[] dp1 = new int[MAXN+1], dp2 = new int[MAXN+1];
	public static List<Integer>[] G = new List[MAXN+1];
	static{
		Arrays.fill(dp1, -1);
		Arrays.fill(dp2, -1);
		for(int i=0; i<=MAXN; ++i) G[i] = new ArrayList<>();
	}
	
	public static void dfs(int u, int p){
		// u = no early adaptor
		int dp1Cnt = 0;
		// u = early adaptor
		int dp2Cnt = 1;
		for(int v : G[u]){
			if(p == v) continue;
			dfs(v, u);
			dp1Cnt += dp2[v];
			dp2Cnt += Math.min(dp1[v], dp2[v]);
		}
		
		dp1[u] = dp1Cnt;
		dp2[u] = dp2Cnt;
	}
	
	public static void BOJ02533(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			G[u].add(v);
			G[v].add(u);
		}
		
		dfs(1, 0);
		System.out.println(Math.min(dp1[1], dp2[1]));
		
		sc.close();
		bw.close();
		br.close();
	}
}