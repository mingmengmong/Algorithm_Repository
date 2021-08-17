package BOJ.S13000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13505 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 100_000;
	public static String[] arr = new String[MAXN];
	public static Trie root = new Trie();
	
	
	public static void BOJ13505(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = String.format("%31s", Integer.toBinaryString(Integer.parseInt(st.nextToken()))).replace(" ", "0");
			root.insert(arr[i], 0);
		}
		
		StringBuffer sb;
		int res = 0;
		for(int i=0; i<N; ++i){
			sb = new StringBuffer(arr[i]);
			root.find(sb, 0);
			int find = Integer.parseInt(sb.toString(), 2);
			res = Math.max(find, res);
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static class Trie{
		public Trie[] child = new Trie[2];
		public void insert(String str, int idx){
			if(str.length() == idx) return;
			
			int n = str.charAt(idx) - '0';
			if(child[n] == null) child[n] = new Trie();
			
			child[n].insert(str, idx+1);
		}
		
		public void find(StringBuffer sb, int idx){
			if(sb.length() == idx) return;
			
			int n = sb.charAt(idx) - '0';
			n ^= 1;
			if(child[n] != null){
				sb.setCharAt(idx, '1');
				child[n].find(sb, idx+1);
			}else{
				sb.setCharAt(idx, '0');
				child[n ^ 1].find(sb, idx+1);
			}
		}
	}
}