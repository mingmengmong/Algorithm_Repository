package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01238 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int s;
		public int e;
		public int l;
		public Node(int s, int e, int l) {
			this.s = s;
			this.e = e;
			this.l = l;
		}
		public String toString(){
			return String.format("{(%d, %d) - %d}", s,e,l);
		}
	}
	
	// 200,000,000
	public final static int INF = 200000000;
	
	public static void BOJ01238(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int startIdx = Integer.parseInt(st.nextToken())-1;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<K; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken());
			map.put(s*N+e, Math.min(l, map.getOrDefault(s*N+e, Integer.MAX_VALUE)));
		}
		
		List<Node>[] arr = new List[N];
		for(int i=0; i<N; ++i){
			arr[i] = new ArrayList<>();
		}
		for(int key : map.keySet()){
			int s = key/N;
			int e = key%N;
			arr[s].add(new Node(s,e,map.get(key)));
		}
		
		int[][] lengthArr = new int[N][];
		
		for(int k=0; k<N; ++k) {
			int[] length = new int[N];
			boolean[] visit = new boolean[N];
			for (int i = 0; i < N; ++i) {
				length[i] = INF;
			}
			length[k] = 0;
			visit[k] = true;
			
			
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return Integer.compare(o1.l, o2.l);
				}
			});
			
			for (Node node : arr[k]) {
				pq.offer(node);
			}
			
			
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				int s = node.s;
				int e = node.e;
				int l = node.l;
				
				int nl = length[s] + l;
				if (nl >= length[e]) {
					continue;
				}
				
				length[e] = nl;
				
				for (Node n : arr[e]) {
					int nnl = n.l + length[e];
					if (nnl >= length[n.e]) {
						continue;
					}
					pq.offer(n);
				}
			}
			
			lengthArr[k] = length;
		}
		
		int result =  Integer.MIN_VALUE;
		for(int i=0; i<N; ++i) {
			result = Math.max(result, lengthArr[i][startIdx] + lengthArr[startIdx][i]);
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}