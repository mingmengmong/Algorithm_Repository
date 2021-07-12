package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ15685 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static boolean[][] arr = new boolean[101][101];
	public static List<List<Node>> dragonCurve = new ArrayList<>();
	
	public static class Node{
		public int x;
		public int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		public Node copy(){
			return new Node(this.x, this.y);
		}
		public String toString(){
			return String.format("(%d, %d)", x, y);
		}
	}
	
	public static void BOJ15685(String[] args) throws Exception {
		dragonCurve.add( new ArrayList<Node>(){{
			add(new Node(0,0));
			add(new Node(1,0));
		}} );
		makeDragonCurve();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			d = ((d%2 == 1 ? 2 : 0) + d) % 4;
			int g = Integer.parseInt(st.nextToken());
			
			// d=3 -> 1, d=1 -> 3, d=2 -> 2, d=0 -> 0
			List<Node> base = rotation(dragonCurve.get(g), d);
			for (Node n : base) {
				int cx = n.x + x;
				int cy = n.y + y;
				if (0 <= cx && cx <= 100 && 0 <= cy && cy <= 100) {
					arr[cx][cy] = true;
				}
			}
		}
		
		int result = 0;
		for(int x=0; x<100; ++x){
			for(int y=0; y<100; ++y){
				if(arr[x][y] && arr[x+1][y] && arr[x][y+1] && arr[x+1][y+1]){
					++result;
				}
			}
		}
		System.out.println(result);
		

		sc.close();
		bw.close();
		br.close();
	}
	
	// (0,0) 기준으로 반시계 방향으로 90도 n 번 돌린다.
	public static List<Node> rotation(List<Node> base, int n){
		List<Node> result = copyList(base);
		while(n-- > 0) {
			for (Node node : result) {
				int x = node.x;
				int y = node.y;
				node.x = -y;
				node.y = x;
			}
		}
		return result;
	}
	
	public static List<Node> copyList(List<Node> base){
		List<Node> result = new ArrayList<>();
		for(Node node : base){
			result.add(node.copy());
		}
		return result;
	}
	
	public static void makeDragonCurve(){
		for(int i=1; i<=10; ++i){
			List<Node> base = copyList(dragonCurve.get(i-1));
			List<Node> rotate = rotation(base, 1);
			
			int size = base.size();
			Node lBase = base.get(size-1);
			Node lRotate = rotate.get(size-1);
			
			int moveX = lBase.x - lRotate.x;
			int moveY = lBase.y - lRotate.y;
			for(Node node : rotate){
				node.x += moveX;
				node.y += moveY;
			}
			Collections.reverse(rotate);
			rotate.remove(0);
			
			base.addAll(rotate);
			dragonCurve.add(base);
		}
	}
}