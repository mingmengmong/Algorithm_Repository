package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02109 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ02109(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(arr[d] == 0){
				arr[d] = p;
				continue;
			}
			
			int idx = d;
			int tmp = p;
			while(idx > 0 && arr[idx] != 0){
				int n1 = tmp;
				int n2 = arr[idx];
				arr[idx] = Math.max(n1, n2);
				tmp = Math.min(n1, n2);
				--idx;
			}
			
			arr[idx] = tmp;
		}
		
		int sum = 0;
		for(int i=1; i<=10000; ++i){
			sum += arr[i];
		}
		System.out.println(sum);
		
		sc.close();
		bw.close();
		br.close();
	}
}