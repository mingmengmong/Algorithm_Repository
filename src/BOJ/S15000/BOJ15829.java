package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15829 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ15829(String[] args) throws Exception {
		int M = 1234567891;
		int r = 31;
		int l = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		long sum = 0;
		for(int i=0; i<l; ++i){
			long c = arr[i]-'a'+1;
			for(int j=0; j<i; ++j){
				c *= r;
				c %= M;
			}
			sum += c;
			sum %= M;
		}
		System.out.println(sum);
		
		sc.close();
		bw.close();
		br.close();
	}
}