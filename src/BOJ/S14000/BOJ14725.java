package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ14725 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ14725(String[] args) throws Exception {
		Node head = new Node("", -1);
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0){
			Node iter = head;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			a : while(n-- > 0){
				String siblingName = st.nextToken();
				List<Node> siblingList = iter.siblingList;
				int siblingSize = siblingList.size();
				
				for(int i=0; i<siblingSize; ++i){
					Node sibling = siblingList.get(i);
					if(siblingName.equals(sibling.name)){
						iter = siblingList.get(i);
						continue a;
					}
				}
				
				Node newSibling = new Node(siblingName, iter.depth+1);
				siblingList.add(newSibling);
				iter = newSibling;
			}
		}
		
		head.print();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static class Node{
		public String name;
		public int depth;
		public List<Node> siblingList;
		public Node(String name, int depth){
			this.name = name;
			this.depth = depth;
			siblingList = new ArrayList<>();
		}
		@Override
		public String toString(){
			return String.format("%s-%s", name, (siblingList.size() > 0 ? siblingList : ""));
		}
		public void print() throws Exception{
			if(name != null && name.length() != 0){
				for(int i=0; i<depth; ++i)
					bw.write("--");
				bw.write(name + "\n");
			}
			Collections.sort(siblingList, (n1, n2) -> n1.name.compareTo(n2.name));
			for(Node iter : siblingList){
				iter.print();
			}
		}
	}
}