package BOJ.S12000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ12865 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static class Node{
		public int w;
		public int p;
		public Node(int w, int p){
			this.w = w;
			this.p = p;
		}
		public String toString(){
			return String.format("(%d, %d)", w, p);
		}
	}
	
	public static void BOJ12865(String[] args) throws Exception {
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.w > o2.w){
					return 1;
				}else if(o1.w == o2.w){
					if(o1.p < o2.p){
						return 1;
					}
				}
				return -1;
			}
		});
		
		Map<Integer, Integer> result = new HashMap<>();
		result.put(0, 0);
		int max = 0;
		for(Node n : list){
			List<Integer> keyList = new ArrayList<>(result.keySet());
			Collections.sort(keyList, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 < o2 ? 1 : -1;
				}
			});
			int size = keyList.size();
			for(int i=0; i<size; ++i){
				int w = keyList.get(i);
				int p = result.get(w);
				
				int nw = w + n.w;
				int np = p + n.p;
				
				if(nw <= K){
					result.put(nw, Math.max(result.getOrDefault(nw, 0), np));
					max = Math.max(max, np);
				}
			}
		}
		
		System.out.println(max);
		
		sc.close();
		bw.close();
		br.close();
	}
}