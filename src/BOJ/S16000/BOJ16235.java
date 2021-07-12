package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ16235 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = {1, 1, 0, -1, -1, -1,  0,  1};
	public static int[] cd = {0, 1, 1,  1,  0, -1, -1, -1};
	
	public static class Node implements Comparable{
		public int r;
		public int c;
		public int z;
		public Node(int r, int c, int z){
			this.r = r;
			this.c = c;
			this.z = z;
		}
		@Override
		public String toString(){
			return String.format("(%d, %d : %d)", r, c, z);
		}
		@Override
		public int compareTo(Object o) {
			Node n = (Node) o;
			if(this.z > n.z){
				return 1;
			}else if(this.z == n.z){
				return 0;
			}
			return -1;
		}
	}
	
	public static void BOJ16235(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] base = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = 5;
				base[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Node> tree = new PriorityQueue<Node>();
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			tree.offer(new Node(x, y, z));
		}
		
//		System.out.println(tree);
//		System.out.println("---------------------");
		
		while(K-- > 0){
			PriorityQueue<Node> nTree = new PriorityQueue<>();
			List<Node> dead = new ArrayList<>();
			List<Node> breedList = new ArrayList<>();
			while(!tree.isEmpty()){
				Node n = tree.poll();
				int r = n.r;
				int c = n.c;
				int z = n.z;
				if(arr[r][c] >= z){
					arr[r][c] -= z;
					++n.z;
					nTree.offer(n);
					if((n.z%5) == 0){
						breedList.add(n);
					}
				}else{
					dead.add(n);
				}
			}
			
			tree = nTree;
			
			for(Node n : dead){
				arr[n.r][n.c] += n.z/2;
			}
			
			for(Node n : breedList){
				int r = n.r;
				int c = n.c;
				for(int i=0; i<8; ++i){
					int nr = r + rd[i];
					int nc = c + cd[i];
					try{
						int t = arr[nr][nc];
					}catch (Exception e){
						continue;
					}
					
					tree.offer(new Node(nr, nc, 1));
				}
			}
			
			for(int i=0; i<N; ++i){
				for(int j=0; j<N; ++j){
					arr[i][j] += base[i][j];
//					System.out.print(arr[i][j] + " ");
				}
//				System.out.println();
			}
			
//			System.out.println(tree);
//			System.out.println("---------------------------");
		}
		
		System.out.println(tree.size());
		
		sc.close();
		bw.close();
		br.close();
	}
}