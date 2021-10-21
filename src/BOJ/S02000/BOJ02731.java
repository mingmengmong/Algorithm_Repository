import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ02731 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC;
	static long N, MAX = 10_000_000_000L;
	static boolean flag;
	static BigInteger bi, mod;
	
	static void makeNum(long n, long n10){
		if(flag) return;
		if(BigInteger.valueOf(n).pow(3).mod(mod).longValue() == N){
			System.out.println(n);
			flag = true;
			return;
		}
		if(MAX == n10) return;
		
		long nextN10 = n10 * 10;
		for(int i=0; i<10 && !flag; ++i){
			long next = i*n10 + n;
			if(BigInteger.valueOf(next).pow(3).mod(BigInteger.valueOf(nextN10)).longValue() == (N%nextN10)){
				makeNum(next, nextN10);
			}
		}
	}
	
	public static void BOJ02731 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			String nStr = br.readLine();
			N = Long.parseLong(nStr);
			long ln = N % 10;
			long sn = 0;
			if(ln == 1){
				bi = BigInteger.ONE;
				sn = 1;
			}else if(ln == 3){
				bi = BigInteger.valueOf(7);
				sn = 7;
			}else if(ln == 7){
				bi = BigInteger.valueOf(3);
				sn = 3;
			}else if(ln == 9){
				bi = BigInteger.valueOf(9);
				sn = 9;
			}
			long modn = 1;
			for(int i=0; i<nStr.length(); ++i) modn *= 10;
			mod = BigInteger.valueOf(modn);
			
			flag = false;
			
			makeNum(sn, 10);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}