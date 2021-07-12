package BOJ.S01000;
import java.io.*;
import java.util.*;

public class BOJ01208 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, mid, M;
	public static long res = 0;
	public static int[] arr;
	public static Map<Integer, Integer> map = new HashMap<>();
	
	public static void leftDfs(int sum, int idx){
		if(idx == mid){
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			return;
		}
		
		leftDfs(sum, idx+1);
		leftDfs(sum + arr[idx], idx+1);
	}
	
	public static void rightDfs(int sum, int idx){
		if(idx == N){
			res += map.getOrDefault(M-sum, 0);
			return;
		}
		
		rightDfs(sum, idx+1);
		rightDfs(sum + arr[idx], idx+1);
	}
	
	public static void BOJ01208(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		sc = new Scanner(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		mid = N >>> 1;
		arr = new int[N];
		
		for(int i=0; i<N; ++i)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		leftDfs(0, 0);
		rightDfs(0, mid);
		
		if(M == 0) --res;
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}