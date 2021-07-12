package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01717 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[] arr;
	
	public static int findNum(int a){
		if(a == arr[a]){
			return a;
		}
		return arr[a] = findNum(arr[a]);
	}
	
	public static void join(int a, int b){
		a = findNum(a);
		b = findNum(b);
		if(a != b) {
			arr[b] = a;
		}
	}
	
	public static void BOJ01717(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i=0; i<=N; ++i){
			arr[i] = i;
		}
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(n == 0){
				join(a,b);
			}else{
				a = findNum(a);
				b = findNum(b);
				if(a == b){
					bw.write("YES\n");
				}else{
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}