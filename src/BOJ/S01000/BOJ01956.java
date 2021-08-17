package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01956 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int V,E, MAXV = 400, MAXC = 1_000_000_000;
	static int[][] G = new int[MAXV +1][MAXV +1];
	static{
		for(int i=0; i<=MAXV; ++i){
			for(int j=0; j<=MAXV; ++j){
				G[i][j] = MAXC;
			}
//			G[i][i] = 0;
		}
	}
	
	public static void BOJ01956(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			G[s][e] = c;
		}
		
		for(int k=0; k<V; ++k){
			for(int s=0; s<V; ++s){
				for(int e=0; e<V; ++e){
					G[s][e] = Math.min(G[s][k] + G[k][e], G[s][e]);
				}
			}
		}
		
		int res = MAXC;
		for(int i=0; i<V; ++i){
			res = Math.min(res, G[i][i]);
		}
		
		if(res == MAXC) res = -1;
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}