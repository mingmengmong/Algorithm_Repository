package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11049 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node{
		public int r;
		public int c;
		public int n;
		public Node(){
			r=0;
			c=0;
			n=0;
		}
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
			this.n = 0;
		}
		public Node(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}
	
	public static void BOJ11049(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Node[][] arr = new Node[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			arr[0][i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1; i<N; ++i){
			for(int j=i; j<N; ++j){
				Node node = new Node(arr[0][j-i].r, arr[0][j].c);
				int min = Integer.MAX_VALUE;
				for(int k=0; k<i; ++k){
					Node iter1 = arr[k][j-i+k];
					Node iter2 = arr[i-1-k][j];
					int sum = iter1.n + iter2.n + iter1.r*iter2.r*iter2.c;
					min = Math.min(min,sum);
				}
				node.n = min;
				arr[i][j] = node;
			}
		}
		System.out.println(arr[N-1][N-1].n);
		
		sc.close();
		bw.close();
		br.close();
	}
}