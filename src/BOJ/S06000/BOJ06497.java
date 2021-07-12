package BOJ.S06000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ06497 {
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
	
	public static void BOJ06497(String[] args) throws Exception {
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0){
				break;
			}
			
			arr = new int[N + 1];
			for (int i = 1; i <= N; ++i) {
				arr[i] = i;
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.l, o2.l));
			
			long result = 0;
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				Node node = new Node(Integer.parseInt(st.nextToken()) + 1, Integer.parseInt(st.nextToken()) + 1, Integer.parseInt(st.nextToken()));
				pq.add(node);
				result += node.l;
			}
			
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				int n1 = node.n1;
				int n2 = node.n2;
				int l = node.l;
				if (find(n1) != find(n2)) {
					union(n1, n2);
					result -= l;
				}
			}
			bw.write(result+"\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}