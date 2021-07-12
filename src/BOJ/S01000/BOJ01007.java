package BOJ.S01000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01007 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int TC, N, HN, MAX=20;
	public static Node[] arr = new Node[MAX];
	public static boolean[] combArr = new boolean[MAX];
	public static long res = Long.MAX_VALUE;
	
	static{
		for(int i=0; i<MAX; ++i)
			arr[i] = new Node();
	}
	
	public static class Node{
		public int x,y;
		public Node(){}
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void comb(int idx, int combArrIdx){
		if(combArrIdx == HN){
			//TODO: calculate
			long x = 0, y = 0;
			for(int i=0; i<N; ++i){
				if(combArr[i]){
					x += arr[i].x;
					y += arr[i].y;
				}else{
					x -= arr[i].x;
					y -= arr[i].y;
				}
			}
			
			res = Math.min(res, x*x + y*y);
			
			return;
		}
		if(idx == N) return;
		
		for(int i=idx; i<N; ++i){
			combArr[i] = true;
			comb(i+1, combArrIdx + 1);
			combArr[i] = false;
		}
	}
	
	
	public static void BOJ01007(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			N = Integer.parseInt(br.readLine());
			HN = N >>> 1;
			res = Long.MAX_VALUE;
			Arrays.fill(combArr, false);
			for(int i=0; i<N; ++i){
				st = new StringTokenizer(br.readLine());
				arr[i].x = Integer.parseInt(st.nextToken());
				arr[i].y = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			
			System.out.println(Math.sqrt((double) res));
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}
