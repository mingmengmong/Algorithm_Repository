package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17144 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int R;
	public static int C;
	public static int T;
	public static int[][] arr;
	public static List<Integer> airCleaner = new LinkedList<>();
	
	public static void BOJ17144(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		
		for(int i=0; i<R; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1){
					airCleaner.add(i);
				}
			}
		}
		
		for(int i=0; i<T; ++i){
			next();
			airCleaning(airCleaner.get(0), 1);
			airCleaning(airCleaner.get(1), -1);
		}
		
		int sum =0;
		for(int i=0; i<R; ++i){
			for(int j=0; j<C; ++j){
				if(arr[i][j] > 0){
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int[] rd = {0, -1,  0, 1};
	public static int[] cd = {1,  0, -1, 0};
	
	public static void next(){
		int[][] next = new int[R][C];
		for(int r=0; r<R; ++r){
			for(int c=0; c<C; ++c){
				if(arr[r][c] > 0){
					int cnt = 0;
					int n = arr[r][c] / 5;
					for(int i=0; i<4; ++i){
						int nr = r + rd[i];
						int nc = c + cd[i];
						try{
							if(arr[nr][nc] != -1){
								++cnt;
								next[nr][nc] += n;
							}
						}catch(Exception e){}
					}
					arr[r][c] -= cnt * n;
				}
			}
		}
		for(int i=0; i<R; ++i){
			for(int j=0; j<C; ++j){
				arr[i][j] += next[i][j];
			}
		}
	}
	
	public static void airCleaning(int sr, int direction){
		int r = sr;
		int c = 0;
		int idx = 0;
		int[][] next = new int[R][C];
		while(true){
			int nr = r + rd[idx] * direction;
			int nc = c + cd[idx];
			try{
				if(arr[nr][nc] == -1){
					arr[r][c] = 0;
					break;
				}
				next[nr][nc] = arr[r][c];
				if(arr[r][c] != -1){
					arr[r][c] = 0;
				}
				r = nr;
				c = nc;
			}catch(Exception e){
				++idx;
			}
		}
		for(int i=0; i<R; ++i){
			for(int j=0; j<C; ++j){
				if(next[i][j] > 0){
					arr[i][j] = next[i][j];
				}
			}
		}
	}
}