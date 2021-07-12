package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14938 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int R;
	public static int[][] distance;
	public static int[][] pi;
	
	public static int[] arr;
	
	public static int MAX_VALUE = 0x3fffffff;
	
	public static void BOJ14938(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		init();
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i< R; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			distance[s][e] = Integer.min(distance[s][e], d);
			distance[e][s] = Integer.min(distance[e][s], d);
			pi[s][e] = s;
			pi[e][s] = e;
		}
		
		floydWarshall();
		
		int result = 0;
		for(int i=0; i<N; ++i){
			int sum = arr[i];
			for(int j=0; j<N; ++j){
				if(i==j){
					continue;
				}
				if(distance[i][j] <= M){
					sum += arr[j];
				}
			}
			result = Integer.max(result, sum);
		}
		
		System.out.println(result);
		
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