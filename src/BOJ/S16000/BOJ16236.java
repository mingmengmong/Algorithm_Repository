package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ16236 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = { 0, 1, -1, 0};
	public static int[] cd = {-1, 0,  0, 1};
	
	public static class Node implements Comparable{
		public int r;
		public int c;
		public int l;
		public Node(int r, int c, int l){
			this.r = r;
			this.c = c;
			this.l = l;
		}
		@Override
		public String toString(){
			return String.format("(%d, %d - %d)", r, c, l);
		}
		@Override
		public int compareTo(Object o) {
			Node n = (Node) o;
			int l1 = r*N + c;
			int l2 = n.r*N + n.c;
			if(l1 > l2){
				return 1;
			}else if(l1 == l2){
				return 0;
			}
			return -1;
		}
	}
	
	public static int N;
	public static int[][] arr;
	public static int sRow = -1;
	public static int sCol = -1;
	public static int sSz = 2;
	public static int sLv = 2;
	
	public static void BOJ16236(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				int n = Integer.parseInt(st.nextToken());
				if(n == 9){
					sRow = i;
					sCol = j;
					arr[i][j] = 0;
				}else{
					arr[i][j] = n;
				}
			}
		}
		
		int length = 0;
		while(true){
			Node next = bfs(sRow, sCol);
			if(next == null){
				break;
			}
			
			sRow = next.r;
			sCol = next.c;
			length += next.l;
			arr[sRow][sCol] = 0;
			--sLv;
			if(sLv == 0){
				sLv = ++sSz;
			}
//			System.out.print(next);
//			System.out.printf(" %d-%d %d\n", sSz, sLv, length);
		}
		System.out.println(length);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static Node bfs(int startRow, int startCol){
		List<Node> result = new ArrayList<>();
		List<Node> list = new ArrayList<>();
		list.add(new Node(startRow, startCol, 0));
		boolean[][] bArr = new boolean[N][N];
		int length = Integer.MAX_VALUE;
		while(!list.isEmpty()){
			Node node = list.remove(0);
			int r = node.r;
			int c = node.c;
			int l = node.l;
			
			if(bArr[r][c]){
				continue;
			}
			if(length <= l){
				break;
			}
			
			bArr[r][c] = true;
			for(int i=0; i<4; ++i){
				int nr = r + rd[i];
				int nc = c + cd[i];
				try {
					if(bArr[nr][nc]){
						continue;
					}else if(arr[nr][nc] > sSz){
						bArr[nr][nc] = true;
					}else if(arr[nr][nc] == sSz){
						list.add(new Node(nr, nc, l+1));
					}else if(arr[nr][nc] == 0){
						list.add(new Node(nr, nc, l+1));
					}else if(arr[nr][nc] < sSz){
						bArr[nr][nc] = true;
						result.add(new Node(nr, nc, l+1));
						length = Math.min(length, l+1);
					}
				}catch (Exception e){
				
				}
			}
		}
		if(result.isEmpty()){
			return null;
		}
		Collections.sort(result);
		return result.remove(0);
	}
}