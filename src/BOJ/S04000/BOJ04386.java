package BOJ.S04000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ04386 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int n1;
		public int n2;
		public double l;
		
		public Node(int n1, int n2, double l) {
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
		public float x;
		public float y;
		public Node2(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BOJ04386(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		List<Node2> list = new ArrayList<>();
		for(int i=1; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			list.add(new Node2(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken())));
			arr[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Double.compare(o1.l, o2.l));
		
		for(int i=0; i<N; ++i){
			Node2 n1 = list.get(i);
			for(int j=i+1; j<N; ++j){
				Node2 n2 = list.get(j);
				float x = n1.x-n2.x;
				x *= x;
				float y = n1.y-n2.y;
				y *= y;
				
				pq.add(new Node(i+1, j+1, Math.sqrt(x+y)));
			}
		}
		
		double result = 0;
		while(!pq.isEmpty()){
			Node node = pq.poll();
			int n1 = node.n1;
			int n2 = node.n2;
			double l = node.l;
			if(find(n1) != find(n2)){
				union(n1, n2);
				result += l;
			}
		}
		
		System.out.printf("%.2f\n", result);
		
		sc.close();
		bw.close();
		br.close();
	}
}