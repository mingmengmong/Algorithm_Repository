package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ02231 {
	public static void BOJ02231(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int c = -1;
		for(int i=0; i<=N; ++i){
			int s = i;
			int n = i;
			while(n > 0){
				s += n%10;
				n /= 10;
			}
			
			if(s == N){
				c = i;
				break;
			}
		}
		
		System.out.println(c==-1?0:c);
		
		sc.close();
		br.close();
	}
}
