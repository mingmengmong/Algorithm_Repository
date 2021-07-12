package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ02884 {
	public static void BOJ02884(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int h2 = m>=45 ? h : (h == 0 ? 23 : h-1);
		int m2 = m>=45 ? m-45 : m+15;
		
		System.out.println(h2 + " " + m2);
		
		sc.close();
		br.close();
	}
}
