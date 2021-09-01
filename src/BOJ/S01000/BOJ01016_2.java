package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01016_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int MAX = 1_000_000;
	static long[] arr = new long[MAX+1];
	
	/**
	 * 뫼비우스 함수
	 * 제곱 인수가 있는 정수인지, 없다면 소인수의 개수가 짝수인지 또는 홀수인지에 따라
	 * {0, -1, 1}을 반환하는 함수이다.
	 */
	static void init(){
		arr[1] = 1;
		for(int i=1; i<=MAX; ++i){
			for(int j=i+i; j<=MAX; j+=i){
				arr[j] -= arr[i];
			}
		}
	}
	
	static long getCnt(long n){
		long res = 0;
		
		for(long i=1; i*i<=n; ++i){
			res += arr[(int)i] * (n / (i*i));
		}
		
		return res;
	}
	
	public static void BOJ01016_2(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		init();
		
		st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken())-1;
		long max = Long.parseLong(st.nextToken());
		
		System.out.println(getCnt(max) - getCnt(min));
		
		br.close();
		bw.close();
		sc.close();
	}
}