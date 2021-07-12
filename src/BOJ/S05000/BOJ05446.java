package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05446 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static char[] stringArr;
	public static int result;
	
	public static class Node{
		public char c;
		public Node[] child;
		public boolean isDel;
		public Node(){
			this.c = '\0';
			this.isDel = true;
			this.child = new Node[123];
		}
		
		public void add(int idx, boolean isDel){
			if(idx == stringArr.length){
				this.isDel = isDel;
				return;
			}
			
			this.isDel = isDel;
			Node node = child[stringArr[idx]];
			if(node == null){
				node = new Node();
				node.c = stringArr[idx];
				child[stringArr[idx]] = node;
			}
			node.isDel = isDel;
			node.add(idx+1, isDel);
		}
		
		public void print(String indent){
			System.out.println(indent + (this.c == '\0' ? '-' : this.c) + " " + this.isDel);
			for(Node node : child){
				if(node != null){
					node.print(indent + " ");
				}
			}
		}
		
		public void find(){
			if(this.isDel){
				++result;
				return;
			}
			
			for(Node node : child){
				if(node != null) {
					node.find();
				}
			}
		}
	}
	
	public static void BOJ05446(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			Node head = new Node();
			head.c = '-';
			result = 0;
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; ++i){
				stringArr = (br.readLine() + "\0").toCharArray();
				head.add(0, true);
			}
			
			int M = Integer.parseInt(br.readLine());
			for(int i=0; i<M; ++i){
				stringArr = (br.readLine() + "\0").toCharArray();
				head.add(0, false);
			}
			
			head.find();
			bw.write(result + "\n");
		}
		
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}