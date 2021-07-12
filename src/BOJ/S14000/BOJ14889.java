package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ14889 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static int[][] arr;
	public static int N;
	
	public static int min = Integer.MAX_VALUE;
	public static List<Integer> list = new ArrayList<>();
	public static List<Integer> pList = new ArrayList<>();
	
	public static void BOJ14889(String[] args) throws Exception {
		N = sc.nextInt();
		arr = new int[N][N];
		for(int r=0; r<N; ++r){
			for(int c=0; c<N; ++c){
				arr[r][c] = sc.nextInt();
			}
			list.add(r);
		}
		
		find(0);
		System.out.println(min);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void find(int idx){
		if(idx == N/2){
			min = Math.min( min, Math.abs(getSum(list) - getSum(pList)) );
			
			return;
		}
		
		for(int i=0; i<list.size(); ++i){
			if(idx > 0 && list.get(i) < pList.get(idx-1)){
				continue;
			}
			
			pList.add(list.remove(i));
			find(idx+1);
			list.add(pList.remove(idx));
			Collections.sort(list);
		}
	}
	
	public static int getSum(List<Integer> list){
		int sum = 0;
		for(int i=0; i<list.size()-1; ++i){
			for(int j=i+1; j<list.size(); ++j){
				int p1 = list.get(i);
				int p2 = list.get(j);
				sum += arr[p1][p2] + arr[p2][p1];
			}
		}
		return sum;
	}
}