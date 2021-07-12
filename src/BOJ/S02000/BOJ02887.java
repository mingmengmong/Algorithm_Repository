package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ02887 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int n1;
		public int n2;
		public int l;
		
		public Node(int n1, int n2, int l) {
			this.n1 = n1;
			this.n2 = n2;
			this.l = l;
		}
		public String toString(){
			return String.format("%d-%d, %f", n1,n2,l);
		}
	}
	
	public static int find(int a){
		if(arr[a] == a){
			return a;
		}
		return arr[a] = find(arr[a]);
	}
	
	public static void union(int a, int b){
		a = find(a);
		b = find(b);
		if(a != b){
			arr[b] = a;
		}
	}
	
	public static int[] arr;
	
	public static class Node2{
		public int idx;
		public int x;
		public int y;
		public int z;
		public Node2(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public String toString(){
			return String.format("(%d,%d,%d)",x,y,z);
		}
	}
	
	public static void BOJ02887(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for(int i=1; i<=N; ++i){
			arr[i] = i;
		}
		
		List<Node2> list = new ArrayList<Node2>();
		for(int i=1; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			list.add(new Node2(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.l, o2.l));
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.x, o2.x));
		for(int i=1; i<N; ++i){
			Node2 n1 = list.get(i-1);
			Node2 n2 = list.get(i);
			pq.add(new Node(n1.idx, n2.idx, Math.abs(n1.x-n2.x)));
		}
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.y, o2.y));
		for(int i=1; i<N; ++i){
			Node2 n1 = list.get(i-1);
			Node2 n2 = list.get(i);
			pq.add(new Node(n1.idx, n2.idx, Math.abs(n1.y-n2.y)));
		}
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.z, o2.z));
		for(int i=1; i<N; ++i){
			Node2 n1 = list.get(i-1);
			Node2 n2 = list.get(i);
			pq.add(new Node(n1.idx, n2.idx, Math.abs(n1.z-n2.z)));
		}
		
		long result = 0;
		while(!pq.isEmpty()){
			Node node = pq.poll();
			int n1 = node.n1;
			int n2 = node.n2;
			int l = node.l;
			if(find(n1) != find(n2)){
				union(n1, n2);
				result += l;
			}
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}