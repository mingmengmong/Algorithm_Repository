package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01330 {
	public static void BOJ01330(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a>b?">":(a==b?"==":"<"));
		
		sc.close();
		br.close();
	}
}
