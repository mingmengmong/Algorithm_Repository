package BOJ.S12000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12852 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int n;
		public int l;
		public String str;
		public Node(int n, int l){
			this.n = n;
			this.l = l;
			this.str = String.valueOf(n);
		}
		public Node(int n, int l, String str) {
			this.n = n;
			this.l = l;
			this.str = str;
		}
	}
	
	public static void BOJ12852(String[] args) throws Exception {
		int N = sc.nextInt();
		if(N == 1){
			System.out.println("0\n1");
			return;
		}
		
		boolean[] bArr = new boolean[N+1];
		List<Node> list = new ArrayList<>();
		
		bArr[N] = true;
		list.add(new Node(N, 0));
		while(true){
			Node node = list.remove(0);
			int n = node.n;
			int nl = node.l+1;
			String str = node.str;
			
			if(n%3 == 0){
				int next = n/3;
				if(next == 1){
					System.out.println(nl);
					System.out.println(str + " 1");
					break;
				}else if(!bArr[next]){
					bArr[next] = true;
					list.add(new Node(next, nl, str+" "+next));
				}
			}
			if(n%2 == 0){
				int next = n/2;
				if(next == 1){
					System.out.println(nl);
					System.out.println(str + " 1");
					break;
				}else if(!bArr[next]){
					bArr[next] = true;
					list.add(new Node(next, nl, str+" "+next));
				}
			}
			int next = n-1;
			if(next == 1){
				System.out.println(nl);
				System.out.println(str + " 1");
				break;
			}else if(!bArr[next]){
				bArr[next] = true;
				list.add(new Node(next, nl, str+" "+next));
			}
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}