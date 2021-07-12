import java.util.*;


public class Solution {
	
	/**
	 * url :
	 * name :
	 */
	
//	int[][] TEST = {{1,0,0,0,0,5,9,9,9,0},{1,1,1,5,5,5,0,9,0,0},{0,2,0,6,0,0,10,0,0,0},{0,2,0,6,0,0,10,10,0,0},{2,2,0,6,6,0,10,0,0,0},{3,3,3,7,7,7,0,11,0,0},{0,0,3,7,0,0,11,11,11,0},{4,4,0,8,8,0,0,12,0,0},{4,0,0,0,8,0,12,12,0,0},{4,0,0,0,8,0,0,12,0,0}};
	
	int[] RD = {0,0,1}, CD = {1,-1,0};
	String[] DR = {"R","L","D"};
	
	int[][] board;
	int size;
	boolean[][] visit;
	
	class Node{
		public int r,c;
		public String shape;
		public Node(int r, int c, String shape) {
			this.r = r;
			this.c = c;
			this.shape = shape;
		}
	}
	
	
//	static Map<String, Integer> shapeIdx = new HashMap<>();
	static Map<String, Boolean> possibleShape = new HashMap<>();
	static Map<String, int[]> checkColumn = new HashMap<>();
	
	static {
		/*
		possible case
		1,   2,   5,   6,   11
		DRR, DDL, DLL, DDR, DRL
		
		wrong case
		3,   4,   7,   8,   9,   10,  12
		RRD, RDD, RRD, RDD, RRD, DRD, DLD
		 */
//		shapeIdx.put("DRR", 1);
//		shapeIdx.put("DDL", 2);
//		shapeIdx.put("DLL", 5);
//		shapeIdx.put("DDR", 6);
//		shapeIdx.put("DRL", 11);
//
//		shapeIdx.put("RRD", 3);
////		shapeIdx.put("RRD", 7);
//		shapeIdx.put("RDD", 4);
////		shapeIdx.put("RDD", 8);
////		shapeIdx.put("RRD", 9);
//		shapeIdx.put("DRD", 10);
//		shapeIdx.put("DLD", 12);
		
		
		possibleShape.put("DRR", true);
		possibleShape.put("DDL", true);
		possibleShape.put("DLL", true);
		possibleShape.put("DDR", true);
		possibleShape.put("DRL", true);
		
		
		checkColumn.put("DRR", new int[]{0, 1, 2});
		checkColumn.put("DDL", new int[]{0, -1});
		checkColumn.put("DLL", new int[]{0, -1, -2});
		checkColumn.put("DDR", new int[]{0, 1});
		checkColumn.put("DRL", new int[]{0, -1, 1});
		
		checkColumn.put("RRD", new int[]{0, 1, 2});
		checkColumn.put("RDD", new int[]{0, 1});
		checkColumn.put("DRD", new int[]{0, 1});
		checkColumn.put("DLD", new int[]{0, -1});
	}
	
	boolean isPossible(int r, int c){
		return 0<=r&&r<size && 0<=c&&c<size;
	}
	
	String dfs(int r, int c){
		if(visit[r][c]) return "";
		visit[r][c] = true;
		
		StringBuilder res = new StringBuilder("");
		int idx = board[r][c];
		for(int i=0; i<3; ++i){
			int nr = r + RD[i];
			int nc = c + CD[i];
			if(!isPossible(nr,nc) || visit[nr][nc]) continue;
			if(board[nr][nc] != idx) continue;
			res.append(DR[i]);
			res.append(dfs(nr,nc));
		}
		return res.toString();
	}
	
	public int solution(int[][] input) {
		int answer = 0;
		
		board = input;
		size = board.length;
		visit = new boolean[size][size];
		boolean[] isFailColumn = new boolean[size];
		
//		StringBuilder sb = new StringBuilder();
//		StringBuilder sb2 = new StringBuilder();
		
		for(int r=0; r<size; ++r){
			Stack<Node> st = new Stack<>();
			for(int c=0; c<size; ++c){
				if(board[r][c] != 0 && !visit[r][c]){
					String shape = dfs(r,c);
					boolean shapeCheck = possibleShape.getOrDefault(shape, false);
					
//					sb.append( String.format("%d : %s - %b\n", board[r][c], shape, shapeCheck) );
					
					if(shapeCheck){
						// 가능한지 확인
						st.push(new Node(r,c,shape));
					}else{
						// 불가능
						int[] iter = checkColumn.get(shape);
						for(int i : iter) isFailColumn[c+i] = true;
					}
				}
			}
			
			while(!st.isEmpty()){
				Node top = st.pop();
				int c = top.c;
				String shape = top.shape;
//				sb2.append(String.format("check -> (%d,%d) - %s\n", r,c,shape));
				int[] iter = checkColumn.get(shape);
				boolean check = false;
				for(int i : iter) check |= isFailColumn[c+i];
				if(!check){
					// 가능
//					sb2.append(String.format("+1 -> (%d,%d) - %s\n", r,c,shape));
					++answer;
				}else{
					// 불가능
					for(int i : iter) isFailColumn[c+i] = true;
				}
			}
			
//			for(int i=0; i<size; ++i) System.out.print(isFailColumn[i] ? "X" : ".");
//			System.out.println();
		}
		
//		System.out.println(sb);
//		System.out.println(sb2);
		
		return answer;
	}
	
	public static void main(String[] args){
		Solution sol = new Solution();
//		sol.solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}});
		int res = sol.solution(new int[][]{{1,0,0,0,0,5,9,9,9,0},{1,1,1,5,5,5,0,9,0,0},{0,2,0,6,0,0,10,0,0,0},{0,2,0,6,0,0,10,10,0,0},{2,2,0,6,6,0,10,0,0,0},{3,3,3,7,7,7,0,11,0,0},{0,0,3,7,0,0,11,11,11,0},{4,4,0,8,8,0,0,12,0,0},{4,0,0,0,8,0,12,12,0,0},{4,0,0,0,8,0,0,12,0,0}});
		
		System.out.println();
		System.out.println(res);
	}
}