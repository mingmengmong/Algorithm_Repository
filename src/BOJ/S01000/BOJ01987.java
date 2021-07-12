package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01987 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static char[][] cArr;
	public static boolean[][] bArr;
	
	public static int length = 0;
	public static int[] rd = {-1, 0, 1,  0};
	public static int[] cd = { 0, 1, 0, -1};
	public static void dfs(int row, int col, List<Character> list){
		if(bArr[row][col]){
			return;
		}
		
		char c = cArr[row][col];
		if(list.contains(c)){
			length = Math.max(length, list.size());
			return;
		}
		bArr[row][col] = true;
		
		list.add(0, c);
		for(int i=0; i<4; ++i){
			try{
				int nr = row + rd[i];
				int nc = col + cd[i];
				if(!bArr[nr][nc]) {
					dfs(nr, nc, list);
				}
			}catch(Exception e){}
		}
		length = Math.max(length, list.size());
		list.remove(0);
		bArr[row][col] = false;
	}
	
	public static void BOJ01987(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		cArr = new char[row][];
		bArr = new boolean[row][col];
		for(int i=0; i<row; ++i){
			cArr[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, new ArrayList<Character>());
		
		System.out.println(length);
		
		sc.close();
		bw.close();
		br.close();
	}
}