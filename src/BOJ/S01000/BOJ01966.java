package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01966 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static class Node{
		public int i;
		public int n;
		public Node(int i, int n){
			this.i = i;
			this.n = n;
		}
	}
	
	public static void BOJ01966(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int fIdx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			List<Node> list = new ArrayList<>();
			for(int i=0; i<size; ++i){
				list.add(new Node(i,Integer.parseInt(st.nextToken())));
			}
			
			int[] arr = new int[size];
			int rating = 1;
			while(size > 0){
				Node node = list.remove(0);
				int n = node.n;
				boolean b = false;
				for(Node nd : list){
					if(n < nd.n){
						b = true;
						break;
					}
				}
				
				if(b){
					list.add(node);
				}else{
					arr[node.i] = rating++;
					--size;
				}
			}
			
			bw.write(arr[fIdx] + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}