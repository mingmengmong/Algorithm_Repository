package programmers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution_1836 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/1836
	 * name : 리틀 프렌즈 사천성
	 */
	
	class Node{
		int x1=-1,y1=-1;
		int x2=-1,y2=-1;
	}
	
	int N, M;
	char[][] board;
	Map<Character, Node> map = new HashMap<>();
	
	boolean isPossible(Node node){
		/*
		가능한 경우
		n1 . . n2
		
		n1
		.
		.
		n2
		
		n1 . . .
		       .
		       n2
		
		. . . . n1
		.
		n2
		
		 */
		
		// 무조껀 x1 <= x2
		int x1 = node.x1, y1 = node.y1;
		int x2 = node.x2, y2 = node.y2;
		int pivot = x2-x1 + Math.abs(y2-y1) - 1;
		
		
		int cnt = 0;
		int x = x1, y = y1;
		while(y != y2){
			if(board[x][y] == '.') ++cnt;
			if(y1 < y2){
				++y;
			}else{
				--y;
			}
		}
		while(x != x2){
			if(board[x][y] == '.') ++cnt;
			++x;
		}
		if(cnt == pivot) return true;
		
		x = x1;
		y = y1;
		cnt = 0;
		while(x != x2){
			if(board[x][y] == '.') ++cnt;
			++x;
		}
		while(y != y2){
			if(board[x][y] == '.') ++cnt;
			if(y1 < y2){
				++y;
			}else{
				--y;
			}
		}
		return cnt == pivot;
	}
	
	public String solution(int n, int m, String[] inputs) {
		N = n;
		M = m;
		board = new char[N][];
		List<Character> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			board[i] = inputs[i].toCharArray();
			for(int j=0; j<M; ++j){
				char c = board[i][j];
				if('A' <= c && c <= 'Z'){
					Node node = map.getOrDefault(c, new Node());
					if(node.x1 == -1){
						node.x1 = i;
						node.y1 = j;
						list.add(c);
					}else{
						node.x2 = i;
						node.y2 = j;
					}
					map.put(c, node);
				}
			}
		}
		
		list.sort((c1,c2) -> Character.compare(c1,c2));
		List<Character> list2 = new ArrayList<>();
		String res = "";
		aaa : while(!list.isEmpty()){
			for(char c : list){
				Node node = map.get(c);
				if(isPossible(node)){
					res += String.valueOf(c);
					board[node.x1][node.y1] = '.';
					board[node.x2][node.y2] = '.';
					list.remove(Character.valueOf(c));
					continue aaa;
				}
			}
			
			return "IMPOSSIBLE";
		}
		
		return res;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
		String[] inputs = new String[]
				{
						"C..F",
						".F.D",
						"..DC"
				};
//		System.out.println(s.solution(inputs.length, inputs[0].length(), inputs));
	}
}