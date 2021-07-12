package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02166 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public long x;
		public long y;
		
		public Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BOJ02166(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		
		long result = getArea(list);
		
		result = Math.abs(result);
		System.out.printf("%.1f\n", (double)result/2d);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static long getArea(List<Node> list){
		long result = 0;
		int size = list.size();
		list.add(list.get(0));
		for(int i=0; i<size; ++i){
			Node n1 = list.get(i);
			Node n2 = list.get(i+1);
			result += n1.x*n2.y - n1.y*n2.x;
		}
		return result;
	}
}