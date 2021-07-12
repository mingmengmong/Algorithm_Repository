package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ02588 {
	public static void BOJ02588(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ab = a*b;
		
		while(b > 0){
			int c = b%10;
			System.out.println(a*c);
			b/=10;
		}
		System.out.println(ab);
		
		sc.close();
		br.close();
	}
}
