package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02056 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ02056(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int result = 0;
		for(int i=1; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int max = 0;
			for(int j=0; j<n; ++j){
				max = Math.max(max, arr[Integer.parseInt(st.nextToken())]);
			}
			arr[i] = max + l;
			result = Math.max(result, arr[i]);
		}
		
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}