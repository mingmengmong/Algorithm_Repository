package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01075 {
	public static void BOJ01075(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int F = sc.nextInt();
		
		int ln = N%100;
		int mn = N%F;
		
		int r = (ln-mn) + (ln < mn ? F : 0);
		while(r>=0){
			r -= F;
		}
		System.out.printf("%02d\n",(r+F));
		
		sc.close();
		br.close();
	}
}