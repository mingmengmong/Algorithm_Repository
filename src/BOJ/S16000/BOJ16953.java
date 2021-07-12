package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ16953 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int n;
		public int l;
		public Node(int n, int l) {
			this.n = n;
			this.l = l;
		}
	}
	
	public static void BOJ16953(String[] args) throws Exception {
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Node> list = new ArrayList<>();
		Set<Integer> visit = new HashSet<>();
		
		visit.add(N);
		list.add(new Node(N, 1));
		
		while(!list.isEmpty()){
			Node now = list.remove(0);
			int n = now.n;
			int l = now.l;
			if(n == K){
				System.out.println(l);
				return;
			}
			
			int nl = l+1;
			if(n <= 500000000){
				int nn = n << 1;
				if(!visit.contains(nn) && nn <= K){
					visit.add(nn);
					list.add(new Node(nn, nl));
				}
			}
			
			if(n < 100000000){
				int nn = n*10 + 1;
				if(!visit.contains(nn) && nn <= K){
					visit.add(nn);
					list.add(new Node(nn, nl));
				}
			}
		}
		System.out.println(-1);
		
		sc.close();
		bw.close();
		br.close();
	}
}