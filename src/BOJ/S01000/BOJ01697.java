package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01697 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node{
		public int n;
		public int l;
		
		public Node(int n, int l) {
			this.n = n;
			this.l = l;
		}
	}
	
	public static void BOJ01697(String[] args) throws Exception {
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] arr = new boolean[100001];
		List<Node> list = new ArrayList<Node>(){{
			add( new Node(N, 0) );
		}};
		
		while(!list.isEmpty()){
			Node node = list.remove(0);
			int n = node.n;
			int l = node.l;
			if(arr[n]){
				continue;
			}
			
			if(n == M){
				System.out.println(l);
				return;
			}
			
			arr[n] = true;
			
			try{
				if(!arr[n-1]){
					list.add( new Node(n-1, l+1) );
				}
			}catch(Exception e){}
			try{
				if(!arr[n+1]){
					list.add( new Node(n+1, l+1) );
				}
			}catch(Exception e){}
			try{
				if(!arr[n*2]){
					list.add( new Node(n*2, l+1) );
				}
			}catch(Exception e){}
		}
		
		
		sc.close();
		bw.close();
		br.close();
	}
}