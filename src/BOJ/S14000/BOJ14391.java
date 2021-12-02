import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ14391 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX1=4, MAX2=MAX1*MAX1;
	static int[][] arr = new int[MAX1][MAX1];
	
	public static void BOJ14391(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; ++i){
			char[] iter = br.readLine().toCharArray();
			for(int j=0; j<M; ++j){
				arr[i][j] = iter[j] - '0';
			}
		}
		
		// 0:가로 1:세로
		int bitLength = N*M;
		int res = 0;
		for(int bit=0; bit<(1<<bitLength); ++bit){
			int sum = 0;
			// 가로
			for(int r=0; r<N; ++r){
				for(int c=0; c<M; ++c){
					int n = 0;
					while(c<M && (bit & (1<<(r*M+c))) == 0){
						n *= 10;
						n += arr[r][c];
						++c;
					}
					sum += n;
				}
			}
			
			// 세로
			for(int c=0; c<M; ++c){
				for(int r=0; r<N; ++r){
					int n = 0;
					while(r<N && (bit & (1<<(r*M+c))) != 0){
						n *= 10;
						n += arr[r][c];
						++r;
					}
					sum += n;
				}
			}
			
			res = Math.max(res, sum);
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}