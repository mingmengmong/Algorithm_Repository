package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17143 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int R;
	public static int C;
	public static int M;
	public static Node[][] arr;
	
	public static int result;
	
	public static class Node{
//		public int r;
//		public int c;
		public int s;
		public int d;
		public int z;
		
		public Node(int s, int d, int z) {
//			this.r = r;
//			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		public Node(){}
		
		public Node compare(Node n){
			if(n == null){
				return new Node(s,d,z);
			}
			
			if(n.z > z){
				return n;
			}else{
				return new Node(s,d,z);
			}
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"s=" + s +
					", d=" + d +
					", z=" + z +
					'}';
		}
	}
	
	public static void BOJ17143(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Node[R][C];
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] =
					new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		
//		print();
		
		for(int c=0; c<C; ++c){
			getShark(c);
			moveShark();
//			print();
		}
		
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void getShark(int c){
		for(int r=0; r<R; ++r){
			if(arr[r][c] != null){
				result += arr[r][c].z;
				arr[r][c] = null;
				break;
			}
		}
	}
	
	public static int[] rd = {-1, 1, 0,  0};
	public static int[] cd = { 0, 0, 1, -1};
	
	public static void moveShark(){
		Node[][] next = new Node[R][C];
		for(int i=0; i<R; ++i){
			for(int j=0; j<C; ++j){
				if(arr[i][j] != null){
					int r = i;
					int c = j;
					int idx = arr[i][j].d;
					int s = arr[i][j].s;
					for(int k=0; k<s; ++k){
						int nr = r + rd[idx];
						int nc = c + cd[idx];
						try {
							Node n = next[nr][nc];
							r = nr;
							c = nc;
						}catch(Exception e){
							idx = changeDirection(idx);
							--k;
							continue;
						}
					}
					arr[i][j].d = idx;
					next[r][c] = arr[i][j].compare(next[r][c]);
				}
			}
		}
		arr = next;
	}
	
	public static int changeDirection(int direction){
		return (direction / 2) * 2 + (direction + 1) % 2;
	}
	
	public static void print(){
		System.out.println("-----------------------");
		for(int r=0; r<R; ++r){
			System.out.println(Arrays.toString(arr[r]));
		}
		System.out.println("-----------------------");
	}
}