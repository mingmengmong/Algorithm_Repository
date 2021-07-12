package BOJ.S20000;
import java.io.*;
import java.util.*;

public class BOJ20920 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	static class Node{
		public String word;
		public int n,l;
		public Node(String word, int n, int l) {
			this.word = word;
			this.n = n;
			this.l = l;
		}
	}
	
	static int N, M;
	static List<Node> list = new ArrayList<>();
	static Map<String, Node> map = new HashMap<>();
	
	public static void BOJ20920(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; ++i){
			String word = br.readLine();
			if(word.length() < M) continue;
			Node node = map.get(word);
			if(node == null){
				node = new Node(word, 0, word.length());
				map.put(word, node);
			}
			++node.n;
		}
		
		for(Node iter : map.values()){
			list.add(iter);
		}
		
		list.sort((n1, n2) -> {
			if(n1.n != n2.n) return n2.n - n1.n;
			if(n1.l != n2.l) return n2.l - n1.l;
			return String.CASE_INSENSITIVE_ORDER.compare(n1.word, n2.word);
		});
		
		for(Node iter : list) {
			bw.write(iter.word);
			bw.newLine();
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}