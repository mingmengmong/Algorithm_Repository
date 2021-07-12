package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14503 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = {-1, 0, 1,  0};
	public static int[] cd = { 0, 1, 0, -1};
	
	public static void BOJ14503(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true){
			if(arr[row][col] == 0) {
				arr[row][col] = 2;
				++cnt;
			}
			
			boolean b = true;
			for(int i=0; i<4 && b; ++i){
				direction += 3;
				direction %= 4;
				
				int nr = row + rd[direction];
				int nc = col + cd[direction];
				if(arr[nr][nc] == 0){
					b = false;
					break;
				}
			}
			
			if(!b){
				row += rd[direction];
				col += cd[direction];
				continue;
			}
			
			int br = row - rd[direction];
			int bc = col - cd[direction];
			if(arr[br][bc] == 1){
				break;
			}else{
				row = br;
				col = bc;
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
		bw.close();
		br.close();
	}
}