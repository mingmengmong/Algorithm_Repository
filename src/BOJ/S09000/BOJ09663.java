package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ09663 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static int cnt = 0;
	
	public static void BOJ09663(String[] args) throws Exception {
		int N = sc.nextInt();
		
		find(new ArrayList<Integer>(), N, 0);
		System.out.println(cnt);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void find(List<Integer> pList, int l, int idx){
		if(l == idx){
			++cnt;
			return;
		}
		
		for(int i=0; i<l; ++i){
			if(idx == 0 || isPossible(pList, idx, i)){
				pList.add(i);
				find(pList, l, idx+1);
				pList.remove(idx);
			}
		}
	}
	
	public static boolean isPossible(List<Integer> list, int r, int c){
		for(int i=0; i<list.size(); ++i){
			int n = list.get(i) - c;
			if((n == 0) || (Math.abs(r-i) == Math.abs(n))){
				return false;
			}
		}
		return true;
	}
}