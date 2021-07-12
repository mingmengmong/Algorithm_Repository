package BOJ.S16000;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16928 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	
	public static void BOJ16928(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] board = new int[101];
		int[] move = new int[101];
		for(int i=0; i<N+M; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			move[s] = e;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((ar1, ar2) -> {
			if(ar1[0] == ar2[0]) return Integer.compare(ar1[1], ar2[1]);
			return Integer.compare(ar1[0], ar2[0]);
		});
		pq.add(new int[]{0, 1});
		boolean[] visit = new boolean[101];
		while(!pq.isEmpty()){
			int[] top = pq.poll();
			int cnt = top[0];
			int p = top[1];
			
			if(p == 100){
				System.out.println(cnt);
				break;
			}
			
			if(visit[p]) continue;
			visit[p] = true;
			for(int i=1; i<=6; ++i){
				int np = i+p;
				if(np > 100) break;
				if(move[np] != 0) np = move[np];
				if(visit[np]) continue;
				pq.add(new int[]{cnt+1, np});
			}
		}

		br.close();
		bw.close();
		sc.close();
	}
}