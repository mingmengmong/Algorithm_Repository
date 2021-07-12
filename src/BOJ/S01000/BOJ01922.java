package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01922 {
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
			return String.format("%d-%d, %d", n1,n2,l);
		}
	}
	
	public static int[] arr;
	
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
	
	public static void BOJ01922(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i=0; i<=N; ++i){
			arr[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.l, o2.l));
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int result = 0;
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