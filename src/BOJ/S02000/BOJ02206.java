package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02206 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int[][] arr;
	public static boolean[][][] visit;
	
	public static class Node{
		public int r;
		public int c;
		public int l;
		public int broken;
		public Node(int r, int c, int l, int broken) {
			this.r = r;
			this.c = c;
			this.l = l;
			this.broken = broken;
		}
	}
	
	public static void BOJ_02206(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M][2];
		for(int i=0; i<N; ++i){
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<M; ++j){
				int num = (int)str[j] - (int)'0';
				arr[i][j] = num;
			}
		}
		
		System.out.println(bfs());
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static int bfs(){
		List<Node> list = new ArrayList<>();
		list.add(new Node(0, 0, 1, 0));
		visit[0][0][0] = true;
		while(!list.isEmpty()){
			Node node = list.remove(0);
			int r = node.r;
			int c = node.c;
			int l = node.l;
			int b = node.broken;
			if(r == N-1 && c == M-1){
				return l;
			}
			
			++l;
			for(int i=0; i<4; ++i){
				int nr = r + rd[i];
				int nc = c + cd[i];
				try {
					int nNum = arr[nr][nc];
					if(nNum == 0 && !visit[nr][nc][b]){
						visit[nr][nc][b] = true;
						list.add(new Node(nr, nc, l, b));
					}else if(nNum == 1 && b == 0 && !visit[nr][nc][1]){
						visit[nr][nc][1] = true;
						list.add(new Node(nr, nc, l, 1));
					}
				}catch(Exception e){}
			}
		}
		return -1;
	}
}