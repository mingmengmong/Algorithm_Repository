package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01550 {
	public static void BOJ01550(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		System.out.println(Integer.parseInt(str, 16));
		
		sc.close();
		br.close();
	}
}