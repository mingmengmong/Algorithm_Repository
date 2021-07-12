package BOJ.S07000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ07568 {
	public static void BOJ07568(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		for(int i=0; i<N; ++i){
			Node n1 = list.get(i);
			for(int j=0; j<N; ++j){
				if(i==j){
					continue;
				}
				
				Node n2 = list.get(j);
				if(n1.h < n2.h && n1.w < n2.w){
					++n1.rate;
				}
			}
			
			System.out.print(n1.rate + " ");
		}
		System.out.println();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static class Node{
		public int rate;
		public int w;
		public int h;
		
		public Node(int w, int h){
			this.w = w;
			this.h = h;
			this.rate = 1;
		}
	}
}