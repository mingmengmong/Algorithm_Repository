package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05639 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static class Node{
		public int num;
		public Node ln;
		public Node rn;
		public Node(int num){
			this.num = num;
		}
		public Node compare(int n){
			if(n < num){
				return ln;
			}else{
				return rn;
			}
		}
		public void insert(int n){
			if(n < num){
				ln = new Node(n);
			}else{
				rn = new Node(n);
			}
		}
		public void print() throws Exception{
			if(ln != null){
				ln.print();
			}
			if(rn != null){
				rn.print();
			}
			bw.write(num + "\n");
		}
	}
	
	public static class Tree{
		public Node head;
		public void insert(int n){
			if(head == null){
				head = new Node(n);
				return;
			}
			
			Node nowNode = head;
			Node prevNode = head;
			while(nowNode != null){
				prevNode = nowNode;
				nowNode = nowNode.compare(n);
			}
			prevNode.insert(n);
		}
		public void print() throws Exception{
			head.print();
		}
	}
	
	public static void BOJ05639(String[] args) throws Exception {
		Tree tree = new Tree();
		String input = "";
		while((input = br.readLine()) != null && input.length() != 0){
			tree.insert(Integer.parseInt(input));
		}
		tree.print();
		
		sc.close();
		bw.close();
		br.close();
	}
}