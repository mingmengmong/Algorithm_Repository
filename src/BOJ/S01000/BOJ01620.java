package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01620 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node implements Comparable{
		public int idx;
		public String str;
		
		public Node(int idx, String str) {
			this.idx = idx;
			this.str = str;
		}
		
		@Override
		public int compareTo(Object o) {
			if(o instanceof String){
				return this.str.compareTo((String) o);
			}else if(o instanceof Node){
				return this.str.compareTo(((Node) o).str);
			}else{
				return 0;
			}
		}
	}
	
	public static void BOJ01620(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String> strList = new ArrayList<>();
		List<Node> numList = new ArrayList<>();
		for(int i=0; i<N; ++i){
			String str = br.readLine();
			strList.add(str);
			numList.add(new Node(i+1, str));
		}
		Collections.sort(numList);
		for(int i=0; i<M; ++i){
			String str = br.readLine();
			try{
				int n = Integer.parseInt(str);
				// number
				bw.write(strList.get(n-1) + "\n");
			}catch(NumberFormatException e){
				// string
//				bw.write((Collections.binarySearch(numList, str)+1) + "\n");
				bw.write((binarySearch(numList, 0, N-1, str) + "\n"));
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	public static int binarySearch(List<Node> list, int sIdx, int eIdx, String key){
		if(sIdx == eIdx){
			return list.get(sIdx).idx;
		}
		int mid = (sIdx+eIdx) >>> 1;
		int compareNum = list.get(mid).str.compareTo(key);
		if(compareNum > 0){
			return binarySearch(list, sIdx, mid-1, key);
		}else if(compareNum == 0){
			return list.get(mid).idx;
		}else{
			return binarySearch(list, mid+1, eIdx, key);
		}
	}
}