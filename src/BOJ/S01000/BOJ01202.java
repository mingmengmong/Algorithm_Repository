package BOJ.S01000;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01202 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	
	public static void BOJ01202(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] jewelry = new int[N][2];
		int[] beg = new int[M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			jewelry[i][0] = Integer.parseInt(st.nextToken());
			jewelry[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; ++i){
			beg[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewelry, (ar1, ar2) -> {
			if(ar1[0] == ar2[0]) return Integer.compare(ar1[1], ar2[1]);
			return Integer.compare(ar1[0], ar2[0]);
		});
		Arrays.sort(beg);
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>((n1,n2)->Long.compare(n2,n1));
		int jewelryIdx = 0;
		long result = 0;
		for(int i=0; i<M; ++i){
			for(; jewelryIdx<N && jewelry[jewelryIdx][0] <= beg[i]; ++jewelryIdx){
				pq.add((long)jewelry[jewelryIdx][1]);
			}
			
			if(!pq.isEmpty()){
				result += pq.poll();
			}
		}
		
		System.out.println(result);

		br.close();
		bw.close();
		sc.close();
	}
}