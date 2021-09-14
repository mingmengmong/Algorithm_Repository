package BOJ.S20000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ20047 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M;
	static char[] word = {'\0', '\0'};
	static char[] from, to;
	static char[] iter;
	
	static boolean bt(int toIdx, int fromIdx, int wordIdx){
		if(toIdx == N){
			return true;
		}
		
		char c = to[toIdx];
		int iterIdx = fromIdx + wordIdx;
		
		if(fromIdx < M){
			if(c == from[fromIdx]){
				iter[iterIdx] = c;
				if(bt(toIdx+1, fromIdx+1, wordIdx))
					return true;
				iter[iterIdx] = '\0';
			}
		}
		
		if(wordIdx < 2){
			if(c == word[wordIdx]){
				iter[iterIdx] = c;
				if(bt(toIdx+1, fromIdx, wordIdx+1))
					return true;
				iter[iterIdx] = '\0';
			}
		}
		
		return false;
	}
	
	public static void BOJ20047(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		M = N-2;
		iter = new char[N];
		StringBuilder str = new StringBuilder(br.readLine());
		to = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; ++i){
			int wi = Integer.parseInt(st.nextToken());
			word[i] = str.charAt(wi - i);
			str.deleteCharAt(wi - i);
		}
		from = str.toString().toCharArray();
		
		System.out.println(bt(0,0,0) ? "YES" : "NO");
		
		br.close();
		bw.close();
		sc.close();
	}
}