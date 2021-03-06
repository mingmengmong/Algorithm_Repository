package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ11779 {
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
	
	public final static int INF = 200000000;
	
	public static void BOJ11779(String[] args) throws Exception {
//		int N = Integer.parseInt(br.readLine());
//		int K = Integer.parseInt(br.readLine());
		int N = sc.nextInt();
		int K = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<K; ++i){
//			st = new StringTokenizer(br.readLine());
//			int s = Integer.parseInt(st.nextToken())-1;
//			int e = Integer.parseInt(st.nextToken())-1;
//			int l = Integer.parseInt(st.nextToken());
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int l = sc.nextInt();
			map.put(s*N+e, Math.min(l, map.getOrDefault(s*N+e, Integer.MAX_VALUE)));
		}

//		st = new StringTokenizer(br.readLine());
//		int startIdx = Integer.parseInt(st.nextToken())-1;
//		int endIdx = Integer.parseInt(st.nextToken())-1;
		int startIdx = sc.nextInt()-1;
		int endIdx = sc.nextInt()-1;
		
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
		
		// ?????? ????????? ??????
		int[] path = new int[N+1];
		
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
			// ?????? ?????? ??????
			path[e+1] = s+1;
			
			for(Node n : arr[e]){
				int nnl = n.l + length[e];
				if(nnl >= length[n.e]){
					continue;
				}
				pq.offer(n);
			}
		}
		
		System.out.println(length[endIdx]);
		
		++endIdx;
		int cnt = 1;
		StringBuilder sb = new StringBuilder( String.valueOf(endIdx) );
		while(path[endIdx] != 0){
			sb.insert(0, path[endIdx] + " ");
			endIdx = path[endIdx];
			++cnt;
		}
		System.out.println(cnt);
		System.out.println(sb);
		
		sc.close();
		bw.close();
		br.close();
	}
}