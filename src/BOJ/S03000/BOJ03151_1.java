import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ03151_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, T = 20_000;
	static int[] arr, cnt = new int[40_001];
	
	public static void BOJ03151_1 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; ++i)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		long res = 0;
		for(int e=0; e<N; ++e){
			res += cnt[T-arr[e]];
			for(int s=0; s<e; ++s)
				++cnt[T + arr[s] + arr[e]];
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}