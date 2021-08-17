package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01654_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, M;
	public static long[] arr;
	
	public static void BOJ01654_2(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		for(int i=0; i<N; ++i){
			arr[i] = Long.parseLong(br.readLine());
		}
		
		long l = 0, r = 1L << 31;
		while(l < r){
			long mid = (r+l) >>> 1;
			int cnt = 0;
			for(long i : arr)
				cnt += i / mid;
			if(cnt >= M) l = mid+1;
			else r = mid;
		}
		
		System.out.println(l-1);
		
		sc.close();
		bw.close();
		br.close();
	}
}
