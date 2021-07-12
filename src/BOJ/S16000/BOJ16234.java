package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16234 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int L;
	public static int R;
	public static int[][] arr;
	
	public static void BOJ16234(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int loopCnt = 0;
		while(true){
			boolean[][] bArr = new boolean[N][N];
			List<List<Integer>> changeList = new ArrayList<>();
			for(int r=0; r<N; ++r){
				for(int c=0; c<N; ++c){
					if(!bArr[r][c]) {
						List<Integer> result = new ArrayList<>();
						dfs(r, c, result, bArr);
						if(result.size() > 1){
							changeList.add(result);
						}
					}
				}
			}
			
			if(changeList.isEmpty()){
				break;
			}
			++loopCnt;
			
			for(int i=0; i<changeList.size(); ++i){
				List<Integer> list = changeList.get(i);
				int sum = 0;
				for(int idx : list){
					int r = idx/N;
					int c = idx%N;
					sum += arr[r][c];
				}
				sum /= list.size();;
				for(int idx : list){
					int r = idx/N;
					int c = idx%N;
					arr[r][c] = sum;
				}
			}
		}
		System.out.println(loopCnt);

		sc.close();
		bw.close();
		br.close();
	}
	
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static void dfs(int r, int c, List<Integer> resultList, boolean[][] checkArr){
		checkArr[r][c] = true;
		resultList.add(r*N+c);
		for(int i=0; i<4; ++i){
			int nr = r + rd[i];
			int nc = c + cd[i];
			
			try{
				if(!checkArr[nr][nc]){
					int d = Math.abs(arr[r][c] - arr[nr][nc]);
					if(L <= d && d <= R){
						dfs(nr, nc, resultList, checkArr);
					}
				}
			}catch (Exception e){}
		}
	}
}