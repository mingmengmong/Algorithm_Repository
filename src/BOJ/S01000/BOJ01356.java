package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01356 {
	public static void BOJ01356(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		char[] num = sc.next().toCharArray();
		
		if(num.length == 1){
			System.out.println("NO");
			return;
		}
		
		long ln = 1;
		long rn = 1;
		int zeroCnt = 0;
		for(char n : num){
			rn *= (n-'0');
			if(n=='0'){
				++zeroCnt;
			}
		}
		
		if(zeroCnt > 0){
			System.out.println(zeroCnt==1?"NO":"YES");
		}else {
			boolean b = false;
			for (char cn : num) {
				int n = cn - '0';
				ln *= n;
				rn /= n;
				
				if (rn == ln) {
					b = true;
					break;
				}
			}
			
			System.out.println(b ? "YES" : "NO");
		}
		
		sc.close();
		br.close();
	}
}