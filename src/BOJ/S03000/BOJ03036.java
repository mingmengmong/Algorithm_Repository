package BOJ.S03000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ03036 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void BOJ03036(String[] args) throws Exception {
		int N = sc.nextInt();
		int F = sc.nextInt();
		
		for(int i=1; i<N; ++i){
			int n = sc.nextInt();
			int gcd = gcd(F, n);
			System.out.printf("%d/%d\n", F/gcd, n/gcd);
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}