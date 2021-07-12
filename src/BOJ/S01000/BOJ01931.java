package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01931 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static class Node {
		public int s;
		public int e;
		
		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		public String toString() {
			return String.format("(%d, %d)", s, e);
		}
	}
	
	public static void BOJ01931(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			list.add( new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) );
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.e > o2.e){
					return 1;
				}else if(o1.e == o2.e){
					if(o1.s > o2.s){
						return 1;
					}
				}
				return -1;
			}
		});
		
		int result = 0;
		int prev = 0;
		for(Node n : list){
			if(prev <= n.s){
				++result;
				prev = n.e;
			}
		}
		
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}