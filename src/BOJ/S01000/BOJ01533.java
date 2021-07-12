package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01533 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static final long MOD = 1000003;
	
	public static void BOJ01533(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = (Integer.parseInt(st.nextToken())-1) * 5;
		int E = (Integer.parseInt(st.nextToken())-1) * 5;
		int T = Integer.parseInt(st.nextToken());
		long[][] arr = new long[N*5][N*5];
		
		for(int i=0; i<N; i++){
			for(int j=1; j<5; j++){
				arr[i*5+j][i*5+j-1] = 1;
			}
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<N; j++){
				int t = str[j] - '0';
				if(t >= 1) arr[i*5][j*5+t-1] = 1;
			}
		}
		
		long[][] result = multiple(arr, T);
		System.out.println(result[S][E]);
		
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static long[][] multiple(long[][] arr, int t){
		if(t == 1){
			return copy(arr);
		}
		
		long[][] result = multiple(arr, t/2);
		result = multiple(result, result);
		if((t&1) == 1){
			result = multiple(result, arr);
		}
		return result;
	}
	
	public static long[][] multiple(long[][] arr1, long[][] arr2){
		int size = arr1.length;
		long[][] result = new long[size][size];
		for(int i=0; i<size; ++i){
			for(int j=0; j<size; ++j){
				for(int k=0; k<size; ++k){
					result[i][j] += arr1[i][k] * arr2[k][j];
					result[i][j] %= MOD;
				}
			}
		}
		return result;
	}
	
	public static long[][] copy(long[][] arr){
		int size = arr.length;
		long[][] result = new long[size][size];
		for(int i=0; i<size; ++i){
			for(int j=0; j<size; ++j){
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}
}