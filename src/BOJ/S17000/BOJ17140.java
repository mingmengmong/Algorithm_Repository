package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ17140 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int R;
	public static int C;
	public static int K;
	public static int r = 3;
	public static int c = 3;
	public static int[][] arr = new int[100][100];
	
	public static class Node implements Comparable{
		public int n;
		public int cnt;
		
		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Object o) {
			Node n = (Node) o;
			if(this.cnt > n.cnt){
				return 1;
			}else if(this.cnt == n.cnt){
				if(this.n > n.n){
					return 1;
				}else if(this.n == n.n){
					return 0;
				}else{
					return -1;
				}
			}else{
				return -1;
			}
		}
	}
	
	public static void BOJ17140(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()) - 1;
		C = Integer.parseInt(st.nextToken()) - 1;
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<3; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print();
		
		int cnt = 0;
		while(true){
			if(arr[R][C] == K){
				break;
			}
			if(cnt > 100){
				cnt = -1;
				break;
			}
			
			++cnt;
			if(r >= c){
				calR();
			}else{
				calC();
			}
//			print();
		}
		
		System.out.println(cnt);
		
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void calR(){
		int nc = -1;
		for(int i=0; i<r; ++i){
			Map<Integer, Integer> map = new HashMap<>();
			for(int j=0; j<c; ++j){
				if(arr[i][j] > 0){
					map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
				}
			}
			List<Node> list = new ArrayList<>();
			for(int j : map.keySet()){
				list.add(new Node(j, map.get(j)));
			}
			Collections.sort(list);
			
			for(int j=0; j<50; ++j){
				if(j < list.size()){
					Node n = list.get(j);
					arr[i][j*2] = n.n;
					arr[i][j*2+1] = n.cnt;
				}else{
					arr[i][j*2] = 0;
					arr[i][j*2+1] = 0;
				}
			}
			nc = Math.max(nc, Math.min(100,list.size()*2));
		}
		c = nc;
	}
	
	public static void calC(){
		int nr = -1;
		for(int i=0; i<c; ++i){
			Map<Integer, Integer> map = new HashMap<>();
			for(int j=0;  j<r; ++j){
				if(arr[j][i] > 0){
					map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
				}
			}
			List<Node> list = new ArrayList<>();
			for(int j : map.keySet()){
				list.add(new Node(j, map.get(j)));
			}
			Collections.sort(list);
			
			for(int j=0; j<50; ++j){
				if(j < list.size()){
					Node n = list.get(j);
					arr[j*2][i] = n.n;
					arr[j*2+1][i] = n.cnt;
				}else{
					arr[j*2][i] = 0;
					arr[j*2+1][i] = 0;
				}
			}
			nr = Math.max(nr, Math.min(100, list.size()*2));
		}
		r = nr;
	}
	
	public static void print(){
		System.out.println("---------------------");
		for(int i=0; i<r; ++i){
			for(int j=0; j<c; ++j){
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
}