package BOJ.S10000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10830 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static Map<Long, int[][]> map = new HashMap<>();
	public static int N;
	
	public static void BOJ10830(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		map.put(1L, arr);
		
		matrix(B);
		
		arr = map.get(B);
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void matrix(long k){
		if(map.containsKey(k)){
			return;
		}
		
		long n1 = k/2;
		long n2 = k-n1;
		
//		System.out.printf("%d - %d, %d\n",k, n1, n2);
		
		matrix(n1);
		matrix(n2);
		multiple(n1, n2);
	}
	
	public static void multiple(long n1, long n2){
		int[][] result = new int[N][N];
		int[][] arr1 = map.get(n1);
		int[][] arr2 = map.get(n2);
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				for(int k=0; k<N; ++k){
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
				result[i][j] %= 1000;
			}
		}
		map.put(n1+n2, result);
	}
}