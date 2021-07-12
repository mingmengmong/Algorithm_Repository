package BOJ.S12000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12849 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	/*
	
	0 : 정보 과학관
	1 : 전산관
	2 : 미래관
	3 : 신양관
	4 : 환경직기념관
	5 : 진리관
	6 : 형남공학관
	7 : 학생회관
	
	 */
	
	public static void BOJ12849(String[] args) throws Exception {
		int D = Integer.parseInt(br.readLine());
		int mod = 1000000007;
		long[][] arr = new long[D+1][8];
		arr[0][0] = 1;
		for(int i=1; i<=D; ++i){
			arr[i][0] = (arr[i-1][1] + arr[i-1][2]) % mod;
			arr[i][1] = (arr[i-1][0] + arr[i-1][2] + arr[i-1][3]) % mod;
			arr[i][2] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][3] + arr[i-1][4]) % mod;
			arr[i][3] = (arr[i-1][1] + arr[i-1][2] + arr[i-1][4] + arr[i-1][5]) % mod;
			arr[i][4] = (arr[i-1][2] + arr[i-1][3] + arr[i-1][5] + arr[i-1][6]) % mod;
			arr[i][5] = (arr[i-1][3] + arr[i-1][4] + arr[i-1][7]) % mod;
			arr[i][6] = (arr[i-1][4] + arr[i-1][7]) % mod;
			arr[i][7] = (arr[i-1][5] + arr[i-1][6]) % mod;
		}
		
		System.out.println(arr[D][0]);
		
		
		sc.close();
		bw.close();
		br.close();
	}
}