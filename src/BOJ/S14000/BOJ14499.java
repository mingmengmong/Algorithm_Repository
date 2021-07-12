package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14499 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int up = 0;
	public static int down = 0;
	public static int front = 0;
	public static int back = 0;
	public static int left = 0;
	public static int right = 0;
	
	public static int[][] arr;
	public static int[] rd = {1, 0,  0, -1};
	public static int[] cd = {0, 1, -1,  0};
	
	public static void BOJ14499(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dr = Integer.parseInt(st.nextToken());
		int dc = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0:d, 1:r, 2:l, 3:u
		st = new StringTokenizer(br.readLine());
		while(K-- > 0){
			int direction = Integer.parseInt(st.nextToken()) % 4;
			
			dr += rd[direction];
			dc += cd[direction];
			if(dr < 0 || dr == N || dc < 0 || dc == M){
				dr -= rd[direction];
				dc -= cd[direction];
				continue;
			}
			
			moveDice(direction);
			if(arr[dr][dc] == 0){
				arr[dr][dc] = down;
			}else{
				down = arr[dr][dc];
				arr[dr][dc] = 0;
			}
			bw.write(up + " \n");
		}
		bw.flush();
		
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void moveDice(int direction){
		int temp = up;
		if(direction == 0){
			up = back;
			back = down;
			down = front;
			front = temp;
		}else if(direction == 3){
			up = front;
			front = down;
			down = back;
			back = temp;
		}else if(direction == 1){
			up = left;
			left = down;
			down = right;
			right = temp;
		}else if(direction == 2){
			up = right;
			right = down;
			down = left;
			left = temp;
		}
	}
}