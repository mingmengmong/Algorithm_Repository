package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01660 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int G;
	public static int[] arr2;
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ01660(String[] args) throws Exception {
		G = sc.nextInt();
		int base = 0;
		int tot = 0;
		for(int i=1; i<=1000; ++i){
			base += i;
			tot += base;
			if(tot > G){
				break;
			}
			list.add(tot);
		}
		N = list.size();
		arr2 = new int[G+1];
		set(G);
		
		System.out.println(arr2[G]);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int set(int k){
		if(k == 0){
			return 0;
		}
		if(k < 0){
			return Integer.MAX_VALUE;
		}
		if(arr2[k] != 0){
			return arr2[k];
		}
		
		int result = Integer.MAX_VALUE;
		for(int i : list){
			result = Math.min(result, set(k-i));
		}
		return arr2[k] = result + 1;
	}
}