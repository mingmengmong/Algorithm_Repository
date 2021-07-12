package BOJ.S07000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * prev solve -> wrong solve
 */
public class BOJ07453 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
//	public static class Node implements Comparable<Node>{
//		public int num;
//		public int idx;
//
//		public Node(int num, int idx) {
//			this.num = num;
//			this.idx = idx;
//		}
//
//		@Override
//		public int compareTo(Node o) {
//			return Integer.compare(this.num, o.num);
//		}
//		public String toString(){
//			return String.format("(%d, %d)",num,idx);
//		}
//	}
	
	public static int N;
	public static int[][] arr;
//	public static Node[] arr;
//	public static Map<Integer, List<int[]>> map = new HashMap<>();
	public static Map<Integer, Integer> map = new HashMap<>();
	
	public static void BOJ07453(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][4];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				int key = arr[i][0] + arr[j][1];
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				int key = arr[i][2] + arr[j][3];
				key *= -1;
				cnt += map.getOrDefault(key, 0);
			}
		}
		System.out.println(cnt);
		
		
		
		/*
		
		arr = new Node[N*4];
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i * 4] = new Node(Integer.parseInt(st.nextToken()), 0);
			arr[i * 4 + 1] = new Node(Integer.parseInt(st.nextToken()), 1);
			arr[i * 4 + 2] = new Node(Integer.parseInt(st.nextToken()), 2);
			arr[i * 4 + 3] = new Node(Integer.parseInt(st.nextToken()), 3);
		}
		
		Arrays.sort(arr);
		N *= 4;
		
		int cnt = 0;
		for(int n3=2; n3<N-1; ++n3){
			Node node2 = arr[n3-1];
			for(int n1=0; n1<n3-1; ++n1){
				Node node1 = arr[n1];
				if(node1.idx == node2.idx){
					continue;
				}
				int key = node2.num + node1.num;
				final int[] v = new int[]{node1.idx, node2.idx};
				if(map.containsKey(key)){
					map.get(key).add(v);
				}else{
					map.put(key, new ArrayList<int[]>(){{add(v);}});
				}
			}
			
			Node node3 = arr[n3];
			for(int n4=n3+1; n4<N; ++n4){
				Node node4 = arr[n4];
				if(node3.idx == node4.idx){
					continue;
				}
				int key = node3.num + node4.num;
				key *= -1;
				
				if(map.containsKey(key)){
					List<int[]> list = map.get(key);
					for(int[] iter : list){
						if(iter[0] != node3.idx && iter[1] != node3.idx && iter[0] != node4.idx && iter[1] != node4.idx){
							++cnt;
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
		*/
		
		
		sc.close();
		bw.close();
		br.close();
	}
}