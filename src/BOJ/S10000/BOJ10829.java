package BOJ.S10000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10829 {
	public static void BOJ10829(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		long l = Long.parseUnsignedLong(br.readLine());
		System.out.println(Long.toUnsignedString(l, 2));
		
		br.close();
	}
}
