package BOJ.S03000;

import java.io.*;
import java.util.*;

public class BOJ03830 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[] arr;
	public static long[] arr2;
	
	public static class Node{
		public int n;
		public long l;
		public Node(int n, long l) {
			this.n = n;
			this.l = l;
		}
		public Node set(long l){
			this.l = l;
			return this;
		}
	}
	
	public static Node findNum(int a){
		int aa = arr[a];
		if(aa == 0){
			return new Node(a, 0);
		}
//		arr2[a] = sumNum(a);
//		arr[a] = findNum(aa);
		Node node = findNum(aa);
		arr[a] = node.n;
		arr2[a] += node.l;
		return node.set(arr2[a]);
	}
	
	public static long sumNum(int a){
		long result = 0;
		while(0 != arr[a]){
			result += arr2[a];
			a = arr[a];
		}
		return result;
	}
	
	public static void join(int a, int b, long l){
		Node aa = findNum(a);
		Node bb = findNum(b);
		if(aa.n != bb.n) {
			arr[bb.n] = aa.n;
			arr2[bb.n] = l + aa.l - bb.l;
		}
	}
	
	public static void BOJ03830(String[] args) throws Exception {
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0){
				break;
			}
			
			arr = new int[N+1];
			arr2 = new long[N+1];
			
			while(M-- > 0){
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				if ("!".equals(cmd)) {
					long l = Long.parseLong(st.nextToken());
					join(n1, n2, l);
				}else{
					Node nn1 = findNum(n1);
					Node nn2 = findNum(n2);
					if(nn1.n == nn2.n){
//						long l1 = sumNum(n1);
//						long l2 = sumNum(n2);
						bw.write((nn2.l-nn1.l) + "\n");
					}else{
						bw.write("UNKNOWN\n");
					}
				}
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}