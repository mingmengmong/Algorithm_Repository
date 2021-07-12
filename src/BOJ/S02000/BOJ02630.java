package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02630 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ02630(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] result = new int[2];
		find(result, arr, 0, 0, N);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void find(int[] result, int[][] arr, int r, int c, int size){
		int n = arr[r][c];
		if(size == 1){
			++result[n];
			return;
		}
		
		boolean b = true;
		for(int i=0; i<size && b; ++i){
			for(int j=0; j<size && b; ++j){
				if(n != arr[r+i][c+j]){
					b = false;
				}
			}
		}
		
		if(b){
			++result[n];
			return;
		}
		
		int s = size/2;
		find(result, arr, r, c, s);
		find(result, arr, r+s, c, s);
		find(result, arr, r, c+s, s);
		find(result, arr, r+s, c+s, s);
	}
}