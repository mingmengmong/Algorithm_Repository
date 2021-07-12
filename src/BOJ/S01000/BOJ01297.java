package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01297 {
	public static void BOJ01297(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int c = sc.nextInt();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		double c2 = Math.sqrt(a*a+b*b);
		
		double ratio = ((double)c)/c2;
		
		int a2 = (int)(a*ratio);
		int b2 = (int)(b*ratio);
		System.out.printf("%d %d\n", a2, b2);
		
		sc.close();
		br.close();
	}
}