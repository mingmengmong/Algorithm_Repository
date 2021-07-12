package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17069 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ17069(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		arr[0][0] = 1;
		for(int i=1; i<=N; ++i){
			arr[0][i] = 1;
			arr[i][0] = 1;
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로
		long[][] arr1 = new long[N+1][N+1];
		// 세로
		long[][] arr2 = new long[N+1][N+1];
		// 대각
		long[][] arr3 = new long[N+1][N+1];
		
		arr1[1][1] = arr1[1][2] = 1;
		for(int r=1; r<=N; ++r){
			for(int c=3; c<=N; ++c){
				// arr1
				if(arr[r][c] == 0 && arr[r][c-1] == 0){
					arr1[r][c] = arr1[r][c-1] + arr3[r][c-1];
				}
				// arr2
				if(arr[r][c] == 0 && arr[r-1][c] == 0){
					arr2[r][c] = arr2[r-1][c] + arr3[r-1][c];
				}
				//arr3
				if(arr[r][c] == 0 && arr[r-1][c] == 0 && arr[r][c-1] == 0 && arr[r-1][c-1] == 0){
					arr3[r][c] = arr1[r-1][c-1] + arr2[r-1][c-1] + arr3[r-1][c-1];
				}
			}
		}
		
		System.out.println(arr1[N][N] + arr2[N][N] + arr3[N][N]);
		
		sc.close();
		bw.close();
		br.close();
	}
}