package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17142 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int[][] arr;
	public static List<Integer> wallList = new ArrayList<>();
	public static List<Integer> virusList = new ArrayList<>();
	public static int wallSize;
	public static int virusSize;
	public static List<List<Integer>> combList = new ArrayList<>();
	
	public static void BOJ17142(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1){
					wallList.add(i*N+j);
				}else if(arr[i][j] == 2){
					virusList.add(i*N+j);
				}
			}
		}
		
		wallSize = wallList.size();
		virusSize = virusList.size();
		
//		System.out.println(wallList);
//		System.out.println(virusList);
		
		makeCombList(0, 0, virusSize, new int[M]);
//		System.out.println(combList);
		
		int result = Integer.MAX_VALUE;
		boolean b = true;
		for(List<Integer> list : combList){
			int num = getMinTime(list);
//			System.out.println(num);
			if(num >= 0){
				b = false;
				result = Math.min(result, num);
			}
//			System.out.println("----------------------------------------");
		}
		System.out.println(b?-1:result);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void makeCombList(int idx, int sIdx, int size, int[] list){
		if(idx == M){
			combList.add(new ArrayList<Integer>(){{
				for(int i=0; i<M; ++i){
					add(virusList.get(list[i]));
				}
			}});
			return;
		}
		
		for(int i=sIdx; i<size; ++i){
			list[idx] = i;
			makeCombList(idx+1, i+1, size, list);
		}
	}
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static class Node{
		public int r;
		public int c;
		public int l;
		
		public Node(int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.l = l;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"r=" + r +
					", c=" + c +
					", l=" + l +
					'}';
		}
	}
	
	public static int getMinTime(List<Integer> virusIdxList){
		boolean[][] bArr = getBooleanArr(virusIdxList);
		List<Node> list = new ArrayList<Node>(){{
			for(int idx : virusIdxList){
				add( new Node(idx/N, idx%N, 0) );
			}
		}};
		
//		System.out.println(list);
		int result = 0;
		int cnt = wallSize;
//		int cnt = wallSize + virusSize - M;
		while(!list.isEmpty()){
			Node node = list.remove(0);
//			System.out.println(node);
			int r = node.r;
			int c = node.c;
			int l = node.l;
			if(bArr[r][c]){
				continue;
			}
			
//			System.out.printf("(%d, %d)\n",r,c);
//			System.out.println(node);
			bArr[r][c] = true;
			++cnt;
			if(arr[r][c] != 2) {
				result = Math.max(result, l);
			}
			for(int i=0; i<4; ++i){
				int nr = r + rd[i];
				int nc = c + cd[i];
				try{
					if(!bArr[nr][nc]){
						list.add( new Node(nr, nc, l+1) );
					}
				}catch (Exception e){
				
				}
			}
		}
		
		for(int idx : virusList){
			if(!bArr[idx/N][idx%N]){
				++cnt;
			}
		}
		
//		System.out.println(cnt);
		
		if(cnt != N*N){
			return -1;
		}else{
			return result;
		}
	}
	
	public static boolean[][] getBooleanArr(List<Integer> vList){
		boolean[][] result = new boolean[N][N];
		for(int idx : wallList){
			result[idx/N][idx%N] = true;
		}
//		for(int idx : virusList){
//			if(!vList.contains(idx)){
//				result[idx/N][idx%N] = true;
//			}
//		}
		return result;
	}
}