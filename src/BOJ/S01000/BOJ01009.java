package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01009 {
	public static void BOJ01009(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; ++tc){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int result = 1;
			while(b-- > 0){
				result *= a;
				result %= 10;
			}
			sb.append(result == 0 ? 10 : result);
			sb.append("\n");
		}
		System.out.println(sb);
		
		sc.close();
		br.close();
	}
}