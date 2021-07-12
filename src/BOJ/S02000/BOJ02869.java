package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ02869 {
	public static void BOJ02869(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		int A = Integer.parseInt(strSpl[0]);
		int B = Integer.parseInt(strSpl[1]);
		int V = Integer.parseInt(strSpl[2]);
		
		int r = A-B;
		int t = V-A;
		
		System.out.println(
				(t/r) + (t%r > 0 ? 1 : 0) + 1
		);
		
		br.close();
	}
}
