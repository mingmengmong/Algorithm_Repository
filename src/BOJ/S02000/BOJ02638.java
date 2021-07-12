package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02638 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int[][] arr;
	
	public static void BOJ02638(String[] args) throws Exception {
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		while(true){
			if(!isCheck()){
				break;
			}
			++result;
			
			visit = new boolean[N][M];
			dfs(0,0);
			
//			print();
			
			for(int i=0; i<N; ++i){
				for(int j=0; j<M; ++j){
					if(arr[i][j] == 1) {
						int cnt = 0;
						for (int k = 0; k < 4; ++k) {
							int nr = i + rd[k];
							int nc = j + cd[k];
							try {
								if (arr[nr][nc] == 2) {
									++cnt;
								}
							} catch (Exception e) {
							}
						}
						if (cnt >= 2) {
							arr[i][j] = 0;
						}
					}
				}
			}
		}
		System.out.println(result);
		
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	public static boolean[][] visit;
	public static void dfs(int r, int c){
		visit[r][c] = true;
		if(arr[r][c] == 1){
			return;
		}
		arr[r][c] = 2;
		for(int i=0; i<4; ++i){
			try{
				int nr = r + rd[i];
				int nc = c + cd[i];
				if(!visit[nr][nc]){
					dfs(nr,nc);
				}
			}catch(Exception e){}
		}
	}
	
	public static boolean isCheck(){
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				if(arr[i][j] == 1){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void print(){
		System.out.println("--------------------------------------------------------");
		for(int i=0; i<N; ++i){
			System.out.println(Arrays.toString(arr[i]).replaceAll(",", "").replaceAll("\\[", "").replaceAll("]", ""));
		}
		System.out.println("--------------------------------------------------------");
	}
}