package BOJ.S05000;
import java.io.*;
import java.util.*;

public class BOJ05052 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node{
		public String str;
		public int l;
		public Node(String str){
			this.str = str;
			this.l = this.str.length();
		}
	}
	
	public static void BOJ05052Success(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			List<Node> list = new ArrayList<>();
			for(int i=0; i<N; ++i){
				list.add(new Node(br.readLine()));
			}
			Collections.sort(list, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.l > o2.l) {
						return 1;
					}else if(o1.l == o2.l){
						return 0;
					}
					return -1;
				}
			});
			
			boolean b = true;
			for(int i=0; i<N && b; ++i){
				Node n1 = list.get(i);
				String str1 = n1.str;
				for(int j=i+1; j<N && b; ++j){
					Node n2 = list.get(j);
					String str2 = n2.str;
					if(n1.l == n2.l){
						continue;
					}
					if(str2.startsWith(str1)){
						b = false;
					}
				}
			}
			
			bw.write(b ? "YES\n" : "NO\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	
	public static void BOJ05052Fail(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			for(int i=0; i<N; ++i){
				list.add(br.readLine());
			}
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int l1 = o1.length();
					int l2 = o1.length();
					if(l1 > l2){
						return 1;
					}else if(l1 == l2){
						return 0;
					}
					return  -1;
				}
			});
			
			boolean b = true;
			for(int i=0; i<N && b; ++i){
				String str1 = list.get(i);
				for(int j=i+1; j<N && b; ++j){
					String str2 = list.get(j);
					if(str1.length() == str2.length()){
						continue;
					}
					if(str2.startsWith(str1)){
						b = false;
					}
				}
			}
			
			bw.write(b ? "YES\n" : "NO\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}