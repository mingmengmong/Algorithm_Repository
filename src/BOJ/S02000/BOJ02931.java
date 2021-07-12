package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ02931 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static char[][] arr;
	public static int[][] visit;
	
	public static class Node{
		public int r;
		public int c;
		public int direction;
		public Node(int r, int c, int direction) {
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
		public String toString(){
			return String.format("(%d, %d) - %d", r,c,direction);
		}
	}
	
	public static void BOJ02931(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][];
		visit = new int[N][M];
		Node m = null;
		Node z = null;
//		int startIdx1 = -1;
//		int startIdx2 = -1;
		for(int i=0; i<N; ++i){
			String str = br.readLine();
			arr[i] = str.toCharArray();
			if(str.contains("M")){
				m = new Node(i, str.indexOf("M"), -1);
//				startIdx1 = str.indexOf("M") + i*M;
			}
			if(str.contains("Z")){
				z = new Node(i, str.indexOf("Z"), -1);
//				startIdx2 = str.indexOf("Z") + i*M;
			}
		}
		
//		System.out.println("startIdx1 : " + startIdx1);
//		System.out.println("startIdx2 : " + startIdx2);
		
		Node node = findNode(m);
		if(node == null){
			node = findNode(z);
			// 문제 조건이 둘다 하나의 블럭과 인접
//			if(node == null){
//				char result = '0';
//				int r = m.r;
//				int c = m.c;
//				for(int i=0; i<4; ++i){
//					int nr = r + 2*rd[i];
//					int nc = c + 2*cd[i];
//					try{
//						char ar = arr[nr][nc];
//						if(ar == 'Z'){
//							if(i < 2){
//								System.out.printf("%d %d %c\n", (r+rd[i]+1), (c+cd[i]+1), '|');
//							}else{
//								System.out.printf("%d %d %c\n", (r+rd[i]+1), (c+cd[i]+1), '-');
//							}
//							return;
//						}else{
//							if(blockList[i].contains(ar)){
//								System.out.printf("%d %d %c\n", (r+rd[i]+1), (c+cd[i]+1), '+');
//								return;
//							}
//						}
//					}catch(Exception e){}
//				}
//			}
		}
//		System.out.println(node);
//		for(int i=0; i<N; ++i){
//			System.out.println(Arrays.toString(visit[i]));
//		}
		
		char block = getBlock(node);
		System.out.printf("%d %d %c\n", node.r+1, node.c+1, block);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	// 0:d, 1:u, 2:r, 3:l
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static Set<Character>[] blockList;
	public static Map<Character, Integer>[] nextDirection;
	public static char[][] nextBlock = {
			{'0', '|', '1', '4'},
			{'|', '0', '2', '3'},
			{'1', '2', '0', '-'},
			{'4', '3', '-', '0'}
	};
	static{
		blockList = new Set[4];
		blockList[0] = new HashSet<Character>(){{
			add('|'); add('+'); add('2'); add('3');
		}};
		blockList[1] = new HashSet<Character>(){{
			add('|'); add('+'); add('1'); add('4');
		}};
		blockList[2] = new HashSet<Character>(){{
			add('-'); add('+'); add('3'); add('4');
		}};
		blockList[3] = new HashSet<Character>(){{
			add('-'); add('+'); add('1'); add('2');
		}};
		
		nextDirection = new Map[4];
		nextDirection[0] = new HashMap<Character, Integer>(){{
			put('|', 0); put('+', 0); put('2', 2); put('3', 3);
		}};
		nextDirection[1] = new HashMap<Character, Integer>(){{
			put('|', 1); put('+', 1); put('1', 2); put('4', 3);
		}};
		nextDirection[2] = new HashMap<Character, Integer>(){{
			put('-', 2); put('+', 2); put('3', 1); put('4', 0);
		}};
		nextDirection[3] = new HashMap<Character, Integer>(){{
			put('-', 3); put('+', 3); put('1', 0); put('2', 1);
		}};
	}
	
	public static Node findNode(Node startNode) {
		int row = startNode.r;
		int col = startNode.c;
		
		List<Node> list = new ArrayList<>();
		
		// 시작지점 주변 비어있는지 확인 -> 문제 조건에서 탈락
		for (int i = 0; i < 4; ++i) {
			int nr = row + rd[i];
			int nc = col + cd[i];
			char c;
			try {
				c = arr[nr][nc];
			} catch (Exception e) {
				continue;
			}
			
			if (blockList[i].contains(c)) {
				list.add(new Node(nr, nc, nextDirection[i].get(c)));
				break;
			}
		}
		
		if (list.size() == 0) {
			return null;
		}
		
		visit[row][col] = 1;
		while (true) {
			Node n = list.remove(0);
			int r = n.r;
			int c = n.c;
			int d = n.direction;
			++visit[r][c];
			
			int nr = r + rd[d];
			int nc = c + cd[d];
			char ar = arr[nr][nc];
			if (ar == '.') {
				return new Node(nr, nc, reverseDirection(d));
			}
			
			list.add(new Node(nr, nc, nextDirection[d].get(ar)));
		}
	}
	
	public static char getBlock(Node node){
		int r = node.r;
		int c = node.c;
		int d = node.direction;
		
		int cnt = 0;
		int direction = -1;
		for(int i=0; i<4; ++i){
			if(i == d){
				continue;
			}
			int nr = r + rd[i];
			int nc = c + cd[i];
			try{
				char ar = arr[nr][nc];
				if(ar == '.'){
					continue;
				}else if(ar == '+'){
					if(visit[nr][nc] < 2) {
						++cnt;
						direction = i;
					}
				}else if(blockList[i].contains(ar) && visit[nr][nc] == 0){
					++cnt;
					direction = i;
				}
//				else if((ar == 'M' || ar == 'Z') && visit[nr][nc] == 0){
//					++cnt;
//					direction = i;
//				}
			}catch (Exception e){}
		}
		
		if(cnt > 1){
			return '+';
		}else if(cnt == 1){
			return nextBlock[d][direction];
		}else{
			return 0;
		}
	}
	
	public static int reverseDirection(int d){
		return d/2*2 + (d+1)%2;
	}
}