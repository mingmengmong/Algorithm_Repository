package BOJ.S10000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10159 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 100, M;
	public static int[] conn = new int[MAXN+1];
	public static long[][] dist = new long[MAXN+1][MAXN+1];
	static{
		for(int i=0; i<=MAXN; ++i)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		Arrays.fill(conn, 1);
	}
	
	public static void BOJ10159(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[b][a] = 1;
		}
		
		for(int v=1; v<=N; ++v){
			for(int s=1; s<=N; ++s){
				for(int e=1; e<=N; ++e){
					dist[s][e] = Math.min(dist[s][e], dist[s][v] + dist[v][e]);
				}
			}
		}
		
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=N; ++j){
				if(dist[i][j] != Integer.MAX_VALUE){
					++conn[i];
					++conn[j];
				}
			}
		}
		
		for(int i=1; i<=N; ++i)
			System.out.println(N - conn[i]);
		
		sc.close();
		bw.close();
		br.close();
	}
}
