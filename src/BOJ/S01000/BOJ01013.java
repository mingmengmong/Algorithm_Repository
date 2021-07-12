package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class BOJ01013 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void BOJ01013(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0){
			String str = br.readLine();
			System.out.println(Pattern.matches("(100+1+|01)+", str) ? "YES" : "NO");
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}