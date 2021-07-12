package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ09328 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static char[][] board;
	public static boolean[] keySet;
	public static int R,C;
	
	public static class Node{
		public int r,c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void BOJ09328(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new char[R][];
			for(int i=0; i<R; ++i){
				board[i] = br.readLine().toCharArray();
			}
			
			keySet = new boolean[26];
			char[] inputKey = br.readLine().toCharArray();
			for(char c : inputKey){
				if(c == '0')
					break;
				keySet[c-'a'] = true;
			}
			
			loop : while(true){
				List<Node> list = new ArrayList<>();
				boolean[][] bArr = new boolean[R][C];
				int cnt = 0;
				
				for(int r=0; r<R; ++r){
					if(isMove(r, 0))
						list.add(new Node(r, 0));
					if(isMove(r, C-1))
						list.add(new Node(r, C-1));
				}
				for(int c=0; c<C; ++c){
					if(isMove(0, c))
						list.add(new Node(0, c));
					if(isMove(R-1, c))
						list.add(new Node(R-1, c));
				}
				
				while(!list.isEmpty()){
					Node iter = list.remove(0);
					int row = iter.r;
					int col = iter.c;
					if(bArr[row][col])
						continue;
					
					bArr[row][col] = true;
					char c = board[row][col];
					if(c == '$')
						++cnt;
					else if('a' <= c && c <= 'z' && !keySet[c-'a']){
						keySet[c-'a'] = true;
						continue loop;
					}
					
					for(int i=0; i<4; ++i){
						int nr = row + rd[i];
						int nc = col + cd[i];
						try{
							if(!bArr[nr][nc] && isMove(nr, nc))
								list.add(new Node(nr, nc));
						}catch(Exception e){}
					}
				}
				
				System.out.println(cnt);
				break;
			}
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static boolean isMove(int row, int col){
		try{
			char c = board[row][col];
			if(c == '.' || c == '$' || ('a' <= c && c <= 'z')){
				return true;
			}
			if('A' <= c && c <= 'Z'){
				return keySet[c-'A'];
			}
			return false;
		}catch(Exception e){
			return false;
		}
	}
}