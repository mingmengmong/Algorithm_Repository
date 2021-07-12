package BOJ.S13000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ13334 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ13334(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[i][0] = Math.min(n1, n2);
			arr[i][1] = Math.max(n1, n2);
		}
		
		int d = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		for(int[] iter : arr){
			if((iter[1] - iter[0]) > d)
				continue;
			list.add(new Node(iter[1]-d, 1));
			list.add(new Node(iter[0], -1));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.p == o2.p)
					return Integer.compare(-o1.s, -o2.s);
				return Integer.compare(o1.p, o2.p);
			}
		});
		
		int r = 0;
		int s = 0;
		for(Node node : list){
			s += node.s;
			if(r < s)
				r = s;
		}
		
		System.out.println(r);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static class Node{
		public int p;
		public int s;
		public Node(int p, int s) {
			this.p = p;
			this.s = s;
		}
		public String toString(){
			return String.format("(%d, %d)", p, s);
		}
	}
}