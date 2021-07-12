package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11758 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int x;
		public int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BOJ11758(String[] args) throws Exception {
		Node n1 = new Node(sc.nextInt(), sc.nextInt());
		Node n2 = new Node(sc.nextInt(), sc.nextInt());
		Node n3 = new Node(sc.nextInt(), sc.nextInt());
		
		System.out.println(ccw(n1, n2, n3));
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int ccw(Node n1, Node n2, Node n3){
		long temp = n1.x*n2.y + n2.x*n3.y + n3.x*n1.y;
		temp = temp - n1.y*n2.x - n2.y*n3.x - n3.y*n1.x;
		if(temp > 0){
			return 1;
		}else if(temp < 0){
			return -1;
		}else{
			return 0;
		}
	}
}