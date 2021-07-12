package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01865 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int W;
	public static int[][] distance;
	public static int[][] pi;
	
	public static int MAX_VALUE = 0x3fffffff;
	
	public static void BOJ01865(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			init();
			
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
				distance[s][e] = Integer.min(distance[s][e], d);
				distance[e][s] = Integer.min(distance[e][s], d);
				pi[s][e] = s;
				pi[e][s] = e;
			}
			
			for(int i=0; i<W; ++i){
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken()) * -1;
				distance[s][e] = Integer.min(distance[s][e], d);
				pi[s][e] = s;
			}
			
			floydWarshall();
			
			boolean b = false;
			for(int i=0; i<N; ++i){
				if(distance[i][i] < 0){
					b = true;
					break;
				}
			}
			System.out.println(b?"YES":"NO");
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void init(){
		distance = new int[N][N];
		pi = new int[N][N];
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				distance[i][j] = MAX_VALUE;
				pi[i][j] = -1;
			}
			distance[i][i] = 0;
		}
	}
	
	public static void floydWarshall(){
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				for(int k=0; k<N; ++k){
					if(distance[k][j] > distance[k][i]+distance[i][j]){
						distance[k][j] = distance[k][i] + distance[i][j];
						pi[k][j] = pi[i][j];
					}
				}
			}
		}
	}
}