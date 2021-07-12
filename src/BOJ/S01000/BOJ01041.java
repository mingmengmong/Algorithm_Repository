package BOJ.S01000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01041 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	/*
	   D
	E  A  B  F
	   C
	   
	   3
	4  0  1  5
	   2
	 */
	
	public static int[][] twoSide = {
			{0,1}, {0,2}, {0,3}, {0,4},
			{5,1}, {5,2}, {5,3}, {5,4},
			{1,2}, {2,4}, {4,3}, {3,1}
	};
	public static int[][] threeSide = {
			{0,1,2}, {0,2,4}, {0,4,3}, {0,3,1},
			{5,1,2}, {5,2,4}, {5,4,3}, {5,3,1}
	};
	
	public static void BOJ01041(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		sc = new Scanner(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		long N = sc.nextLong();
		long[] arr = new long[6];
		for(int i=0; i<6; ++i) arr[i] = sc.nextLong();
		
		if(N == 1){
			long res = 0;
			Arrays.sort(arr);
			for(int i=0; i<5; ++i) res += arr[i];
			System.out.println(res);
			
			return;
		}
		
		long[] twoSideSum = new long[twoSide.length];
		for(int i=0; i<twoSide.length; ++i){
			for(int idx : twoSide[i]){
				twoSideSum[i] += arr[idx];
			}
		}
		
		long[] threeSideSum = new long[threeSide.length];
		for(int i=0; i<threeSide.length; ++i){
			for(int idx : threeSide[i]){
				threeSideSum[i] += arr[idx];
			}
		}
		
		Arrays.sort(arr);
		Arrays.sort(twoSideSum);
		Arrays.sort(threeSideSum);
		
		long res = arr[0] * (N-2) * ((N-2) * 5 + 4);
		res += twoSideSum[0] * ((N-2) * 4 + (N-1) * 4);
		res += threeSideSum[0] * 4;
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}