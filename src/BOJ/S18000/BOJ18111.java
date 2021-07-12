package BOJ.S18000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ18111 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node{
		public int time;
		public int height;
		public Node(int time, int height) {
			this.time = time;
			this.height = height;
		}
		public String toString(){
			return String.format("%d %d", time, height);
		}
	}
	
	public static void BOJ18111(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<R; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(arr[i][j], min);
				max = Math.max(arr[i][j], max);
			}
		}
		
		List<Node> list = new ArrayList<>();
		for(int h=(min<0?0:min); h<=max && h<=256; ++h){
			int b = B;
			int t = 0;
			for(int i=0; i<R; ++i){
				for(int j=0; j<C; ++j){
					if(arr[i][j] > h){
						int d = arr[i][j] - h;
						b += d;
						t += d*2;
					}else if(arr[i][j] < h){
						int d = h - arr[i][j];
						b -= d;
						t += d;
					}
				}
			}
			
			if(b < 0){
				break;
			}
			
			list.add(new Node(t, h));
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.time < o2.time){
					return -1;
				}else if(o1.time == o2.time){
					if(o1.height > o2.height){
						return -1;
					}else if(o1.height == o2.height){
						return 0;
					}else{
						return 1;
					}
				}else{
					return 1;
				}
			}
		});
		System.out.println(list.get(0));
		
		sc.close();
		bw.close();
		br.close();
	}
}