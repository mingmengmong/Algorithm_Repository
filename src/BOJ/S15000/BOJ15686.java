package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15686 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static List<Integer> chickenList = new ArrayList<>();
	public static List<Integer> homeList = new ArrayList<>();
	public static int[][] chickenArr;
	public static int index = 0;
	
	public static void BOJ15686(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chickenArr = new int[10000][M];
		
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				int n = Integer.parseInt(st.nextToken());
				if(n == 1){
					homeList.add(i*N+j);
				}else if(n == 2){
					chickenList.add(i*N+j);
				}
			}
		}
		
		int chickenSize = chickenList.size();
		int homeSize = homeList.size();
		findArr(0, 0, chickenSize, new ArrayList<>());
		
		int minResult = Integer.MAX_VALUE;
		for(int i=0; i<index; ++i){
			int result = 0;
			for(int j : homeList){
				int hr = j/N;
				int hc = j%N;
				int min = Integer.MAX_VALUE;
				for(int k=0; k<M; ++k){
					int chicken = chickenArr[i][k];
					int cr = chicken/N;
					int cc = chicken%N;
					min = Math.min(min, Math.abs(hr-cr) + Math.abs(hc-cc) );
				}
				result += min;
			}
			minResult = Math.min(minResult, result);
		}
		System.out.println(minResult);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void findArr(int idx, int listIdx, int chickenSize,  List<Integer> list){
		if(idx == M){
			for(int i=0; i<M; ++i){
				chickenArr[index][i] = list.get(i);
			}
			++index;
			return;
		}
		
		for(int i=listIdx; i<chickenSize; ++i){
			list.add(chickenList.get(i));
			findArr(idx+1, i+1, chickenSize, list);
			list.remove(list.size()-1);
		}
	}
}