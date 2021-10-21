import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, R;
	static int[][] arr;
	static int[] tmp = new int[100_000];
	
	static void rotate(){
		int S = Math.min(N, M) >>> 1;
		for(int i=0; i<S; ++i){
			int sR = i;
			int sC = i;
			int eR = N-1 - i;
			int eC = M-1 - i;
			
			int idx = 0;
			
			for(int c=sC; c<eC; ++c)
				tmp[idx++] = arr[sR][c];
			for(int r=sR; r<eR; ++r)
				tmp[idx++] = arr[r][eC];
			for(int c=eC; c>sC; --c)
				tmp[idx++] = arr[eR][c];
			for(int r=eR; r>sR; --r)
				tmp[idx++] = arr[r][sC];
			
			int size = idx;
			idx = R % size;
			

			for(int c=sC; c<eC; ++c, idx = (idx+1) % size)
				arr[sR][c] = tmp[idx];
			for(int r=sR; r<eR; ++r, idx = (idx+1) % size)
				arr[r][eC] = tmp[idx];
			for(int c=eC; c>sC; --c, idx = (idx+1) % size)
				arr[eR][c] = tmp[idx];
			for(int r=eR; r>sR; --r, idx = (idx+1) % size)
				arr[r][sC] = tmp[idx];
		}
	}
	
	public static void BOJ16926 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate();
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j)
				bw.write(String.format("%d ", arr[i][j]));
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}