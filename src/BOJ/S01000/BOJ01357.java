package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01357 {
	public static void BOJ01357(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		System.out.println(rev(rev(sc.nextInt())+rev(sc.nextInt())));
		
		sc.close();
		br.close();
	}
	public static int rev(int n){
		int result = 0;
		while(n > 0){
			result *= 10;
			result += n%10;
			n /= 10;
		}
		return result;
	}
}