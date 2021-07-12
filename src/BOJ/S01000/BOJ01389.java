package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01389 {
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
	
	public static void BOJ01389(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] link = new List[N];
		for(int i=0; i<N; ++i){
			link[i] = new ArrayList<>();
		}
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			link[n1].add(n2);
			link[n2].add(n1);
		}
		
		int result = -1;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; ++i){
			int[] arr = new int[N];
			arr[i] = Integer.MAX_VALUE;
			List<Node> list = new ArrayList<>();
			for(int iter : link[i]){
				list.add(new Node(iter, 1));
			}
			while(!list.isEmpty()){
				Node node = list.remove(0);
				int n = node.n;
				if(arr[n] > 0){
					continue;
				}
				
				int l = node.l;
				arr[n] = l;
				for(int iter : link[n]){
					if(arr[iter] == 0){
						list.add(new Node(iter, l+1));
					}
				}
			}
			int sum = 0;
			arr[i] = 0;
			for(int j=0; j<N; ++j){
				sum += arr[j];
			}
			if(sum < min){
				result = i;
				min = sum;
			}else if(sum == min){
				result = Math.min(result, i);
			}
		}
		System.out.println(result+1);
		
		sc.close();
		bw.close();
		br.close();
	}
}