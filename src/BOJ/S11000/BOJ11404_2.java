package BOJ.S11000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11404_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int V, MAXV = 100, E, MAX = 1_000_000_007;
	public static int[][] dist = new int[MAXV+1][MAXV+1];
	static{
		for(int i=0; i<=MAXV; ++i) {
			for(int j=0; j<=MAXV; ++j)
				dist[i][j] = MAX;
			dist[i][i] = 0;
		}
	}
	
	public static void BOJ11404_2(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[u][v] = Math.min(dist[u][v], w);
		}
		
		for(int v=1; v<=V; ++v){
			for(int s=1; s<=V; ++s){
				for(int e=1; e<=V; ++e){
					dist[s][e] = Math.min(dist[s][e], dist[s][v] + dist[v][e]);
				}
			}
		}
		
		for(int i=1; i<=V; ++i){
			for(int j=1; j<=V; ++j){
				if(dist[i][j] == MAX) dist[i][j] = 0;
				System.out.printf("%d ", dist[i][j]);
			}
			System.out.println();
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}
