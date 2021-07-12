package BOJ.S13000;
import java.io.*;
import java.util.BitSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13701 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ13701(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input2")));
		
		st = new StringTokenizer(br.readLine());
		
		BitSet bs = new BitSet(33554432);
		while(st.hasMoreTokens()){
			int n = Integer.parseInt(st.nextToken());
			if(!bs.get(n)){
				bs.set(n);
				bw.write(n + " ");
			}
		}
		bw.newLine();
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}