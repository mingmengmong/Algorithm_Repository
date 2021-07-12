package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01504 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static List<Node>[] listArr;
	
	public static class Node implements Comparable<Node>{
		public int now;
		public int next;
		public int length;
		public Node(int now, int next, int length) {
			this.now = now;
			this.next = next;
			this.length = length;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.length, o.length);
		}
		
		@Override
		public String toString(){
			return String.format("(%d-%d : %d)", now,next,length);
		}
		
		public Node copy(){
			return new Node(this.now, this.next, this.length);
		}
	}
	
	public static void BOJ01504(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		listArr = new List[N];
		for(int i=0; i<N; ++i){
			listArr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int l = Integer.parseInt(st.nextToken());
			listArr[s].add(new Node(s,e,l));
			listArr[e].add(new Node(e,s,l));
		}
		
		st = new StringTokenizer(br.readLine());
		int m1 = Integer.parseInt(st.nextToken()) - 1;
		int m2 = Integer.parseInt(st.nextToken()) - 1;
		
//		for(int i=0; i<N; ++i){
//			long[] result = dijkstra(i);
//			System.out.println(i + " : " + Arrays.toString(result));
//		}
		
		long[] sArr = dijkstra(0);
		long[] m1Arr = dijkstra(m1);
		long[] m2Arr = dijkstra(m2);
		long r1 = sArr[m1] + m1Arr[m2] + m2Arr[N-1];
		long r2 = sArr[m2] + m2Arr[m1] + m1Arr[N-1];
		if(r1 >= Integer.MAX_VALUE && r2 >= Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(Math.min(r1, r2));
		}
		
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static long[] dijkstra(int start){
		long[] result = init(start);
		boolean[] visit = new boolean[N];
		visit[start] = true;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(Node node : listArr[start]){
			pq.offer(node.copy());
		}
		
		while(!pq.isEmpty()){
//			System.out.println(pq);
			Node node = pq.poll();
			int n = node.now;
			int e = node.next;
			int l = node.length;
			if(result[e] > result[n]+l){
				result[e] = result[n]+l;
				for(Node iter : listArr[e]){
					pq.offer(iter);
				}
			}
			
//			result[e] = Math.min(result[e], result[n]+l);
//			if(!visit[e]){
//				visit[e] = true;
//				for(Node iter : listArr[e]){
//					pq.offer(iter.copy());
//				}
//			}
		}
		
		return result;
	}
	
	public static long[] init(int start){
		long[] result = new long[N];
		for(int i=0; i<N; ++i){
			result[i] = Integer.MAX_VALUE;
		}
		result[start] = 0;
		return result;
	}
}