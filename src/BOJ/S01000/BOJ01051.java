package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01051 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ01051(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		sc = new Scanner(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		int N = sc.nextInt(), M = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0; i<N; ++i) arr[i] = sc.next();
		
		int res = 0;
		int minLength = Math.min(N,M);
		for(int length=1; length<=minLength; ++length){
			for(int r=0; r+length<=N; ++r){
				for(int c=0; c+length<=M; ++c){
					char c1 = arr[r].charAt(c);
					char c2 = arr[r].charAt(c+length-1);
					char c3 = arr[r+length-1].charAt(c);
					char c4 = arr[r+length-1].charAt(c+length-1);
					if(c1 == c2 && c2 == c3 && c3 == c4){
						res = Math.max(res, length);
					}
				}
			}
		}
		
		System.out.println(res*res);
		
		br.close();
		bw.close();
		sc.close();
	}
}