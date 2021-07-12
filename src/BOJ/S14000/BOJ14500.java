package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14500 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static String[] tetromino = {
			"1111", "1 1 1 1",
			"11 11",
			"111 100", "100 111", "10 10 11", "11 01 01",
			"111 001", "001 111", "01 01 11", "11 10 10",
			"10 11 01", "011 110",
			"01 11 10", "110 011",
			"010 111", "10 11 10", "111 010", "01 11 01"
	};
	
	public static void BOJ14500(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(String str : tetromino){
			String[] strSpl = str.split(" ");
			int rSize = strSpl.length;
			int cSize = strSpl[0].length();
			
			for(int r=0; r<=(N-rSize); ++r){
				for(int c=0; c<=(M-cSize); ++c){
					int sum = 0;
					for(int i=0; i<rSize; ++i){
						for(int j=0; j<cSize; ++j){
							sum += (strSpl[i].charAt(j) - '0') * arr[r+i][c+j];
						}
					}
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
		
		
		sc.close();
		bw.close();
		br.close();
	}
}