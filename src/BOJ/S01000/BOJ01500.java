package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01500 {
	public static void BOJ01500(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int K = sc.nextInt();
		
		long r = 1;
		while(S > 0){
			int n = S/K;
			r *= n;
			S -= n;
			--K;
		}
		System.out.println(r);
		
		sc.close();
		br.close();
	}
	
}