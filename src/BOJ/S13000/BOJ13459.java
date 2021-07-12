package BOJ.S13000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ13459 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static int[][] arr;
	public static int N;
	public static int M;

	public static boolean[][][][] bArr;
	public static Set<Integer> resultSet = new HashSet<>();
	
	public static class Node{
		public int mr;
		public int mc;
		public int er;
		public int ec;
		public int l = 0;
		
		public boolean isGoal = false;
		public boolean isFail = false;
		
		public Node(int mr, int mc, int er, int ec, int l){
			this.mr = mr;
			this.mc = mc;
			this.er = er;
			this.ec = ec;
			this.l = l;
		}
		
		public Node(){}
	}

	public static void BOJ13459(String[] args) throws Exception {
//		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
//			if(N == 0){
//				break;
//			}
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			bArr = new boolean[10][10][10][10];
//		eArr = new boolean[N][M];
			
			int mr = 0;
			int mc = 0;
			int er = 0;
			int ec = 0;
			
			for (int i = 0; i < N; ++i) {
				String str = br.readLine();
				for (int j = 0; j < M; ++j) {
					char c = str.charAt(j);
					int n = -1;
					if (c == '.') {
						n = 0;
					} else if (c == 'O') {
						n = 1;
					} else if (c == 'R') {
						n = 0;
						mr = i;
						mc = j;
					} else if (c == 'B') {
						n = 0;
						er = i;
						ec = j;
					}
					arr[i][j] = n;
				}
			}
			
			Node start = new Node(mr, mc, er, ec, 0);
			bArr[mr][mc][er][ec] = true;

//		for(int i=0; i<N; ++i){
//			for(int j=0; j<M; ++j){
//				System.out.printf("%3d ", arr[i][j]);
//			}
//			System.out.println();
//		}
			
			bfs(start);
//		List<Integer> result = new ArrayList<>(resultSet);
//		Collections.sort(result);
//		if(result.size() > 0){
//			int cnt = result.get(result.size()-1);
//			if(cnt > 10){
//				System.out.println(-1);
//			}else {
//				System.out.println(cnt);
//			}
//		}else{
//			System.out.println(-1);
//		}
//			String str = br.readLine();
//			bw.write(str + "\n\n");
//		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void bfs(Node start) throws Exception{
		List<Node> list = new LinkedList<>();
		list.add(start);
		
		while(list.size() > 0){
			Node now = list.remove(0);
			if(now.l == 10){
				continue;
			}
			for(int i=0; i<4; ++i){
				Node next = move(now, i);
				if(next == null){
					continue;
				}
				
				if(next.isGoal){
					bw.write("1\n");
					return;
				}else if(next.isFail){
					continue;
				}else{
					list.add(next);
				}
			}
		}
		bw.write("0\n");
	}
	
	// 위, 아래, 오른쪽, 왼쪽
	public static int[] rd = {-1, 1, 0,  0};
	public static int[] cd = { 0, 0, 1, -1};
	public static Node move(Node position, int direction){
		int mr = position.mr;
		int mc = position.mc;
		int er = position.er;
		int ec = position.ec;
		int l = position.l;
		
		int nmr = mr;
		int nmc = mc;
		int ner = er;
		int nec = ec;
		boolean bm = true;
		boolean mg = false;
		boolean be = true;
		boolean eg = false;
		while(bm || be){
			if(bm) {
				nmr += rd[direction];
				nmc += cd[direction];
				int cmNum = arr[nmr][nmc];
				if (cmNum == 0) {
				} else if (cmNum == 1) {
					mg = true;
					bm = false;
				} else if (cmNum == -1) {
					nmr -= rd[direction];
					nmc -= cd[direction];
					bm = false;
				}
			}
			
			if(be) {
				ner += rd[direction];
				nec += cd[direction];
				int ceNum = arr[ner][nec];
				if (ceNum == 0) {
				} else if (ceNum == 1) {
					eg = true;
					be = false;
				} else if (ceNum == -1) {
					ner -= rd[direction];
					nec -= cd[direction];
					be = false;
				}
			}
		}
		
//		System.out.printf("direction : %d\n", direction);
//		System.out.printf("[(%d, %d), (%d, %d)]\n", mr, mc, er, ec);
//		System.out.printf("[(%d, %d), (%d, %d)]\n", nmr, nmc, ner, nec);
		
		// 두 공이 이동후 골에 들어갔는지 판단이랑 두공이 같은 위치로 이동시 처리한다.
		
		Node next = new Node();
		next.l = l+1;
		if(eg){
			// 파란볼이 골에 들어간 경우
			next.isFail = true;
			next.l = -1;
		}else if(mg){
			// 빨간볼이 골에 들어간 경우
			next.isGoal = true;
		}else if(nmr == ner && nmc == nec){
			// 두 공이 같은 위치일 경우
			// 빨간공이 먼저 움직일 경우 true
			boolean isFirst = true;
			if(direction == 0){
				// 위
				if(mc == ec && mr > er){
					isFirst = false;
				}
			}else if(direction == 1){
				// 아래
				if(mc == ec && mr < er){
					isFirst = false;
				}
			}else if(direction == 2){
				// 오른쪽
				if(mr == er && mc < ec){
					isFirst = false;
				}
			}else if(direction == 3){
				// 왼쪽
				if(mr == er && mc > ec){
					isFirst = false;
				}
			}
			
			if(isFirst){
				ner -= rd[direction];
				nec -= cd[direction];
			}else{
				nmr -= rd[direction];
				nmc -= cd[direction];
			}
		}
		
//		System.out.printf("[(%d, %d), (%d, %d)]\n", nmr, nmc, ner, nec);
//		System.out.printf("isGoal : %b, isFail : %b\n", mg, eg);
//		System.out.println("bArr : " + bArr[nmr][nmc][ner][nec]);
//		System.out.println("-------------------");
		
		if(bArr[nmr][nmc][ner][nec]){
			return null;
		}
		
		bArr[nmr][nmc][ner][nec] = true;
		next.mr = nmr;
		next.mc = nmc;
		next.er = ner;
		next.ec = nec;
		
		return next;
	}
}