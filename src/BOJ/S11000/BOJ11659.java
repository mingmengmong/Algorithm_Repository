package BOJ.S11000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11659 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	
	public static void BOJ11659(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<=N; ++i){
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(arr[e] - arr[s-1]);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}