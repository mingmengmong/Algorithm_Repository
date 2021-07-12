package BOJ.S09000;
import java.io.*;
import java.util.*;

public class BOJ09202 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node{
		public Map<Integer, Node> child;
		public boolean isFinish;
		public boolean isUse;
		public Node(){
			this.isFinish = false;
			this.isUse = false;
			this.child = new HashMap<>();
		}
		
		public void add(int idx){
			if(idx == stringArr.length){
				this.isFinish = true;
				return;
			}
			
			int index = stringArr[idx];
			Node node = child.get(index);
			if(node == null){
				node = new Node();
				child.put(index, node);
			}
			node.add(idx+1);
		}
		
		public void clear(){
			this.isUse = false;
			for(Node node : child.values()){
				node.clear();
			}
		}
		
		public void print(String indent){
			for(int idx : child.keySet()){
				Node node = child.get(idx);
				System.out.println(indent  + " " + (char)idx + " " + node.isFinish);
				child.get(idx).print(indent + " ");
			}
		}
		
		public boolean find(int idx){
			if(idx == stringArr.length){
				if(this.isFinish){
					if(!this.isUse){
						this.isUse = true;
						return true;
					}
				}
				return false;
			}
			
			for(int index : child.keySet()){
				if(index == stringArr[idx]){
					if(child.get(index).find(idx+1))
						return true;
				}
			}
			return false;
		}
	}
	
	public static char[] stringArr;
	public static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
	public static char[][] board;
	public static boolean[][] bArr;
	
	public static Set<Character> startChar;
	public static Set<Integer> strLength;
	public static Node head;
	
	public static void BOJ09202(String[] args) throws Exception {
		startChar = new HashSet<>();
		strLength = new HashSet<>();
		head = new Node();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			stringArr = br.readLine().toCharArray();
			startChar.add(stringArr[0]);
			strLength.add(stringArr.length);
			head.add(0);
		}
		
		br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; ++i){
			head.clear();
			bArr = new boolean[4][4];
			board = new char[4][];
			totScore = 0;
			wordCnt = 0;
			word = "";
			for(int j=0; j<4; ++j){
				board[j] = br.readLine().toCharArray();
			}
			
			for(int r=0; r<4; ++r){
				for(int c=0; c<4; ++c){
					if(startChar.contains(board[r][c])){
						bArr[r][c] = true;
						dfs(r, c, String.valueOf(board[r][c]));
						bArr[r][c] = false;
					}
				}
			}
			
			System.out.printf("%d %s %d\n", totScore, word, wordCnt);
			
			if(i < (M-1)){
				br.readLine();
			}
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int totScore;
	public static int wordCnt;
	public static String word;
	
	public static int[] rd = {0, 1, 1,  1,  0, -1, -1, -1};
	public static int[] cd = {1, 1, 0, -1, -1, -1,  0,  1};
	public static void dfs(int r, int c, String str){
		if(strLength.contains(str.length())){
			stringArr = str.toCharArray();
			boolean b = head.find(0);
			if(b){
				int l = str.length();
				totScore += score[l];
				++wordCnt;
				if(word.length() < l){
					word = str;
				}else if(word.length() == l){
					if(word.compareTo(str) > 0){
						word = str;
					}
				}
			}
		}
		
		if(str.length() == 8){
			return;
		}
		
		for(int i=0; i<8; ++i){
			try{
				int nr = r + rd[i];
				int nc = c + cd[i];
				if(!bArr[nr][nc]){
					bArr[nr][nc] = true;
					dfs(nr, nc, str + board[nr][nc]);
					bArr[nr][nc] = false;
				}
			}catch(Exception e){}
		}
	}
}