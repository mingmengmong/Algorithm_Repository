package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01735 {
	public static void BOJ01735(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();

		int c = sc.nextInt();
		int d = sc.nextInt();

		int ac = a*d + c*b;
		int bd = b*d;
		int gcd = gcd(ac,bd);
		
		System.out.printf("%d %d\n", ac/gcd, bd/gcd);
		
		sc.close();
		br.close();
	}
	public static int gcd(int a, int b){
		return (b == 0) ? a : gcd(b, a%b);
	}
}