package BOJ.S16000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16565 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int MAX = 52, MOD = 10_007, N;
	static int[][] arr = new int[MAX+1][MAX+1];
	
	public static void BOJ16565(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		arr[0][0] = 1;
		for(int i=1; i<=MAX; ++i){
			arr[i][0] = 1;
			for(int j=1; j<=i; ++j){
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				arr[i][j] %= MOD;
			}
		}
		
		int res = 0;
		for(int i=1; i<=13 && i*4 <= N; ++i){
			// arr[13][i] * arr[52-i*4][N-i*4]
			if(i % 2 == 1){
				res += arr[13][i] * arr[52-i*4][N-i*4];
			}else{
				res -= arr[13][i] * arr[52-i*4][N-i*4];
				while(res < 0) res += MOD;
			}
			res %= MOD;
		}
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}