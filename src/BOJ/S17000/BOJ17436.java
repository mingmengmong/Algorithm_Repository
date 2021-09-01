package BOJ.S17000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17436 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N;
	static long M;
	static long[] arr = new long[10];
	
	public static void BOJ17436(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i)
			arr[i] = Long.parseLong(st.nextToken());
		
		long res = 0;
		for(int i=1; i<(1<<N); ++i){
			long num = 1;
			int cnt = 0;
			for(int j=0; j<N; ++j){
				if((i&(1<<j)) > 0){
					++cnt;
					num *= arr[j];
				}
			}
			
			if(cnt % 2 == 1) res += M/num;
			else res -= M/num;
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}