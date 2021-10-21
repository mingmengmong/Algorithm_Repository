import java.io.*;
import java.util.*;

public class BOJ11812 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static long N;
	static int K, Q;
	
	static class Node{
		public long u, par, depth, sum, pow;
		public Node(){}
		public String toString(){
			return String.format("%d -> %d, %d", u,par,depth);
		}
	}
	
	static void getNode(long u, Node node){
		long uu=u, pow = 1, sum=0;
		int depth = 0;
		while(uu > pow){
			uu -= pow;
			sum += pow;
			pow *= K;
			++depth;
		}
		
		pow /= K;
		
		node.u = u;
		node.depth = depth;
		node.sum = sum;
		node.pow = pow;
		node.par = sum - pow + (uu-1) / K + 1;
	}
	
	static void nextNode(Node node){
		long u = node.par;
		long depth = node.depth-1;
		long sum = node.sum - node.pow;
		long uu = u - sum;
		long pow = node.pow / K;
		
//		System.out.printf("u : %d\n",u);
//		System.out.printf("uu : %d\n",uu);
//		System.out.printf("depth : %d\n",depth);
//		System.out.printf("pow : %d\n",pow);
//		System.out.printf("sum : %d\n",sum);
		
		node.u = u;
		node.depth = depth;
		node.par = sum - pow + (uu-1) / K + 1;
		node.sum = sum;
		node.pow = pow;
	}
	
	public static void BOJ11812 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		Node an = new Node(), bn = new Node();
		
		while(Q-- > 0){
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(K == 1) {
				bw.write(String.valueOf(Math.abs(a - b)));
				bw.newLine();
				continue;
			}
			
			getNode(a, an);
			getNode(b, bn);
			
			long res = an.depth + bn.depth;
			
			while(an.depth > bn.depth){
				nextNode(an);
			}
			
			while(bn.depth > an.depth){
				nextNode(bn);
			}
			
			while(an.u != bn.u){
				nextNode(an);
				nextNode(bn);
			}
			
			res -= an.depth << 1;
			bw.write(String.valueOf(res));
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}