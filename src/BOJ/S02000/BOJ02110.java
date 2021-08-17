package BOJ.S02000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02110 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, M;
	public static long[] arr;
	
	public static void BOJ02110(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		for(int i=0; i<N; ++i){
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		long l = 1, r = arr[N-1];
		while(l < r){
			long mid = (r+l) >>> 1, idx = arr[0];
			int cnt = 1;
			for(int i=1; i<N; ++i){
				if(idx + mid <= arr[i]){
					++cnt;
					idx = arr[i];
				}
			}
			
			if(cnt >= M) l = mid+1;
			else r = mid;
		}
		
		System.out.println(l-1);
		
		sc.close();
		bw.close();
		br.close();
	}
}
