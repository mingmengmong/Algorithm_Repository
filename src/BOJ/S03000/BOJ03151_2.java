import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ03151_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=10_000;
	static int[] arr;
	
	public static void BOJ03151_1 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; ++i)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		long res = 0;
		for(int s=0; s<N-2; ++s){
			int m = s+1;
			int e = m+1;
			for(int i=0; i<=s; ++i){
				int target = arr[i] + arr[m];
				target *= -1;
				int lowerIdx = lowerBound(target, e, N);
				int upperIdx = lowerBound(target+1, e, N);
				if(lowerIdx < N && arr[lowerIdx] == target) res += upperIdx-lowerIdx;
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
	
	static int lowerBound(int target, int s, int e) {
		while(s<e){
			int m = (s+e) >>> 1;
			if(arr[m]< target) s = m+1;
			else e = m;
		}
		return s;
	}
}