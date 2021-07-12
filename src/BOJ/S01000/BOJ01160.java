package BOJ.S01000;
import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01160 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static long m,a,c,x0,n,g;
	public static BigInteger bim;
	public static Map<Long, Long> rm, rs;
	public static Map<Long, Boolean> bm, bs;
	static{
		rm = new HashMap<>();
		rs = new HashMap<>();
		bm = new HashMap<>();
		bs = new HashMap<>();
	}
	
	public static long getMul(long l1, long l2){
		BigInteger n1 = BigInteger.valueOf(l1);
		BigInteger n2 = BigInteger.valueOf(l2);
		return n1.multiply(n2).mod(bim).longValue();
	}
	
	public static long getSum(long l1, long l2){
		BigInteger n1 = BigInteger.valueOf(l1);
		BigInteger n2 = BigInteger.valueOf(l2);
		return n1.add(n2).mod(bim).longValue();
	}
	
	public static long mulN(long idx){
		if(idx == 0)
			return 1;
		if(idx == 1)
			return a;
		if(bm.getOrDefault(idx, false))
			return rm.get(idx);
		bm.put(idx, true);
		if(idx % 2 == 1){
			rm.put(idx, getMul(a, getMul(mulN(idx/2), mulN(idx/2))));
		}else{
			rm.put(idx, getMul(mulN(idx/2), mulN(idx/2)));
		}
		return rm.get(idx);
	}
	
	public static long sumN(long idx){
		if(idx == 0)
			return 1;
		if(idx == 1)
			return getSum(1, a);
		if(bs.getOrDefault(idx, false))
			return rs.get(idx);
		bs.put(idx, true);
		if(idx % 2 == 1){
			rs.put(idx, getMul(getSum(1, mulN(idx/2+1)), sumN(idx/2)));
		}else{
			rs.put(idx, getSum(sumN(idx/2-1), getMul(mulN(idx/2), sumN(idx/2))));
		}
		return rs.get(idx);
	}
	
	public static void BOJ01160(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input2")));
		
		st = new StringTokenizer(br.readLine());
		
		m = Long.parseLong(st.nextToken());
		a = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		x0 = Long.parseLong(st.nextToken());
		n = Long.parseLong(st.nextToken());
		g = Long.parseLong(st.nextToken());
		
		if(n == 0){
			System.out.println(x0%g);
			return;
		}
		
		a %= m;
		c %= m;
		x0 %= m;
		bim = BigInteger.valueOf(m);
		
		// a^n * x0 + ( a^0 + a^1 + a^2 + ... a^(n-1) ) + c
		long result = getSum(
				getMul(mulN(n), x0),
				getMul(sumN(n-1), c)
		);
		System.out.println(result%g);
		
		sc.close();
		bw.close();
		br.close();
	}
}