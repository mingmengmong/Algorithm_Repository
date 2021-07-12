package BOJ.S13000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13549 {
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
	
	public static void BOJ13549(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N >= K){
			System.out.println(N-K);
			return;
		}
		
		List<Node> list = new ArrayList<>();
		boolean[] visit = new boolean[100001];
		
		list.add(new Node(N, 0));
		visit[N] = true;
		
		while(!list.isEmpty()){
			Node now = list.remove(0);
			int n = now.n;
			int l = now.l;
			if(n == K){
				System.out.println(l);
				return;
			}
			
			int nn = n<<1;
			while(nn <= 100000 && nn <= K && !visit[nn]){
				visit[nn] = true;
				list.add(new Node(nn, l));
				nn = nn<<1;
			};
			if(nn <= 100000 && !visit[nn]){
				visit[nn] = true;
				list.add(new Node(nn, l));
			}
			
			nn = n-1;
			if(nn >= 0 && !visit[nn]){
				visit[nn] = true;
				list.add(new Node(nn, l+1));
			}
			
			nn = n+1;
			if(nn <= 100000 && !visit[nn]){
				visit[nn] = true;
				list.add(new Node(nn, l+1));
			}
		}
		
		
		sc.close();
		bw.close();
		br.close();
	}
}