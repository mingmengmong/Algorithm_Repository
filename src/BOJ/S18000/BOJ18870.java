package BOJ.S18000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ18870 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int i;
		public int n;
		public int c = 0;
		public Node(int i, int n) {
			this.i = i;
			this.n = n;
		}
		public String toString(){
			return String.format("(%d %d)", i, n);
		}
	}
	
	public static void BOJ18870(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			int n = Integer.parseInt(st.nextToken());
			list.add(new Node(i, n));
		}
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.n, o2.n));
		
		int i = 0;
		int n = list.get(0).n;
		for(Node iter : list){
			if(iter.n == n){
				iter.c = i;
			}else{
				n = iter.n;
				iter.c = ++i;
			}
		}
		
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.i, o2.i));
		
		for(Node iter : list){
			bw.write(String.format("%d ", iter.c));
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}