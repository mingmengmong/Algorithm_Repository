package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01806 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ01806(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; ++i){
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
//		System.out.println(Arrays.toString(arr));
		
		if(sum < S){
			System.out.println(0);
			return;
		}
		
		int lIdx = 0;
		int rIdx = N;
		int result = N;
		while(rIdx > 0){
			if(lIdx == rIdx){
				rIdx -= 1;
				lIdx = Math.max(rIdx-result, 0);
			}
			int ln = arr[lIdx];
			int rn = arr[rIdx];
			if((rn-ln) >= S){
				result = Math.min(result, rIdx-lIdx);
				lIdx += 1;
			}else{
				lIdx = rIdx;
			}
		}

		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}