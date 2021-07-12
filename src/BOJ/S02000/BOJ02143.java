package BOJ.S02000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02143 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int T, N, M, MAX = 1_000;
	public static int[] arr = new int[MAX];
	public static List<Integer> nl = new ArrayList<>(), ml = new ArrayList<>();
	
	public static void Main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			nl.add(n);
			for(int j=0; j<i; ++j){
				arr[j] += n;
				nl.add(arr[j]);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; ++i){
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			ml.add(n);
			for(int j=0; j<i; ++j){
				arr[j] += n;
				ml.add(arr[j]);
			}
		}
		
		nl.sort(Integer::compareTo);
		ml.sort(Integer::compareTo);
		
		int nlSize = nl.size();
		long res = 0;
		for(int m : ml){
			int idx1 = lowerBound(T-m, 0, nlSize);
			int idx2 = lowerBound(T-m+1, 0, nlSize);
			res += idx2 - idx1;
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int lowerBound(int t, int s, int e){
		while(s < e){
			int m = (s+e) >>> 1;
			int mm = nl.get(m);
			if(t <= mm) e = m;
			else s = m+1;
		}
		return s;
	}
}