package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01037 {
	public static void BOJ01037(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		String[] strSpl = br.readLine().split(" ");
		
		long min = 10000000;
		long max = 0;
		for(String str : strSpl){
			int num = Integer.parseInt(str);
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		System.out.println((long)(min * max));

		br.close();
	}
}
