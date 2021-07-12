package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01094 {
	public static void BOJ01094(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		int l = 64;
		int result = 0;
		
		while(n > 0){
			if(n >= l){
				n -= l;
				++result;
			}
			l /= 2;
		}
		
		System.out.println(result);
		
		br.close();
	}
}
