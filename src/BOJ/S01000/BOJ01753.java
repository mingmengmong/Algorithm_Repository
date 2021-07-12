package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01753 {
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
	
	public final static int INF = 1000000000;
	
	public static void BOJ01753(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int startIdx = Integer.parseInt(br.readLine())-1;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<K; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken());
			map.put(s*N+e, Math.min(l, map.getOrDefault(s*N+e, Integer.MAX_VALUE)));
		}
		
		List<Node>[] arr = new List[N];
		int[] length = new int[N];
		boolean[] visit = new boolean[N];
		for(int i=0; i<N; ++i){
			arr[i] = new ArrayList<>();
			length[i] = INF;
		}
		length[startIdx] = 0;
		visit[startIdx] = true;
		for(int key : map.keySet()){
			int s = key/N;
			int e = key%N;
			arr[s].add(new Node(s,e,map.get(key)));
		}
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.l, o2.l);
			}
		});
		
		for(Node node : arr[startIdx]){
			pq.offer(node);
		}
		
		while(!pq.isEmpty()){
			Node node = pq.poll();
			int s = node.s;
			int e = node.e;
			int l = node.l;
			
			int nl = length[s] + l;
			if(nl >= length[e]){
				continue;
			}
			
			length[e] = nl;
			
			for(Node n : arr[e]){
				int nnl = n.l + length[e];
				if(nnl >= length[n.e]){
					continue;
				}
				pq.offer(n);
			}
		}
		
		for(int i : length){
			if(i >= INF){
				bw.write("INF");
			}else{
				bw.write(String.valueOf(i));
			}
			bw.newLine();
		}
		bw.flush();
		
		
		sc.close();
		bw.close();
		br.close();
	}
}