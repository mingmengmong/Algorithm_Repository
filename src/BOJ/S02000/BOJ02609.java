package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02609 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int gcd(int a, int b){
		return (b==0 ? a : gcd(b, a%b));
	}
	
	public static void BOJ02609(String[] args) throws Exception {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int g = gcd(a,b);
		System.out.println(g);
		System.out.println(a*b/g);
		
		sc.close();
		bw.close();
		br.close();
	}
}