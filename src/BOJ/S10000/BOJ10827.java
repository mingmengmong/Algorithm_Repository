package BOJ.S10000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class BOJ10827 {
	public static void BOJ10827(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		
		BigDecimal bd = new BigDecimal(strSpl[0]);
		bd = bd.pow(Integer.parseInt(strSpl[1]));
		
		System.out.println(bd.toPlainString());
		
		br.close();
	}
}
