import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ02003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, K;
	static int[] arr = new int[10_001];
	
	public static void BOJ02003(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		int l=0,r=0;
		int sum = 0;
		int res = 0;
		while(true){
			if(sum < K){
				if(r < N) sum += arr[r++];
				else break;
			}else if(sum == K){
				++res;
				if(l < N) sum -= arr[l++];
				else break;
			}else{
				if(l < N) sum -= arr[l++];
				else break;
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}