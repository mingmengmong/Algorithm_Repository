package BOJ.S01000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01019 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 1_000_000_000;
	public static long[] res = new long[10], minusZeroCnt = new long[11];
	public static long[][] cnt = new long[11][10];
	static{
		// 0~9, 00~99, 000~999 10^(idx+1) 까지의 수 개수
		Arrays.fill(cnt[0], 1L);
		for(int i=1, j=10; i<=10; ++i, j*=10) Arrays.fill(cnt[i], cnt[i-1][0] * 10L + j);
//		for(int i=0; i<=10; ++i) System.out.println(Arrays.toString(cnt[i]));
		
		// 0~9, 00~99, 000~999 10^(idx+1) 까지의 수앞에 0이 나오는 개수 (01,02,03, 001,002,003,004 ...)
		minusZeroCnt[0] = 1;
		for(int i=1, j=10; i<=10; ++i, j*=10) minusZeroCnt[i] = minusZeroCnt[i-1] + j;
//		System.out.println(Arrays.toString(minusZeroCnt));
	}
	
	
	public static void BOJ01019(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		
		int size = String.valueOf(N).length() - 1;
		long pow10 = (long) Math.pow(10, size);
//		System.out.println(size + " " + pow10);
//		System.out.println();
		
		if(size > 0)
			res[0] -= minusZeroCnt[size - 1];
		res[0] -= pow10;
		
		// 1의 자리 제외 나머지 계산.
		for(int i=1; i<=size; ++i, pow10/=10){
			// 2, 2 / 23, 3 / 234, 4
			String over = String.valueOf(N / pow10);
			int loopCnt = over.charAt(over.length()-1) - '0';
			
//			System.out.println(over + " " + loopCnt);
			
			for(int j=0; j<10; ++j){
				res[j] += loopCnt * cnt[size-i][j];
			}
			
			for(int j=0; j<loopCnt; ++j){
				res[j] += pow10;
			}
			
			for(int j=0; j<over.length()-1; ++j){
				res[over.charAt(j)-'0'] += loopCnt * pow10;
			}
		}
		
		// 1의자리 계산. 많아야 10번 반복.
		for(int i=N-(N%10); i<=N; ++i){
			char[] num = String.valueOf(i).toCharArray();
			for(char c : num)
				++res[c-'0'];
		}
		
		for(int i=0; i<10; ++i) System.out.printf("%d ", res[i]);
		System.out.println();
		
		
		sc.close();
		bw.close();
		br.close();
	}
}