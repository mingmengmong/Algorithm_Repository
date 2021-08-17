package BOJ.S02000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02458 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 500, M;
	public static int[] conn = new int[MAXN+1];
	public static long[][] dist = new long[MAXN+1][MAXN+1];
	static{
		for(int i=0; i<=MAXN; ++i)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		Arrays.fill(conn, 1);
	}
	
	public static void BOJ02458(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
		}
		
		for(int v=1; v<=N; ++v){
			for(int s=1; s<=N; ++s){
				for(int e=1; e<=N; ++e){
					dist[s][e] = Math.min(dist[s][e], dist[s][v] + dist[v][e]);
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=N; ++j){
				if(dist[i][j] != Integer.MAX_VALUE){
					++conn[i];
					++conn[j];
					if(conn[i] == N) ++ans;
					if(conn[j] == N) ++ans;
				}
			}
		}
		
		System.out.println(ans);
		
		sc.close();
		bw.close();
		br.close();
	}
}
