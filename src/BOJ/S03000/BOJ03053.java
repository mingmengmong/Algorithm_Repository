package BOJ.S03000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BOJ03053 {
	public static void BOJ03053(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		BigDecimal r = BigDecimal.valueOf(sc.nextInt());
		
		BigDecimal a = BigDecimal.valueOf(Math.PI);
		a = a.multiply(r).multiply(r);
		
		BigDecimal b = BigDecimal.valueOf(2);
		b = b.multiply(r).multiply(r);
		
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println(df.format(a));
		System.out.println(df.format(b));
		
		sc.close();
		br.close();
	}
}
