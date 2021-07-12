package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14888 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	public static void BOJ14888(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> nList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			nList.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> cList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; ++i){
			int c = Integer.parseInt(st.nextToken());
			for(int j=0; j<c; ++j){
				cList.add(i);
			}
		}
		
		find(cList, new ArrayList<Integer>(), N-1, 0, nList);
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void find(List<Integer> list, List<Integer> pList, int l, int idx, List<Integer> nList){
		if(l == idx){
			int sum = nList.get(0);
			for(int i=0; i<l; ++i){
				int c = pList.get(i);
				if(c == 0){
					sum += nList.get(i+1);
				}else if(c == 1){
					sum -= nList.get(i+1);
				}else if(c == 2){
					sum *= nList.get(i+1);
				}else if(c == 3){
					sum /= nList.get(i+1);
				}
			}
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		int size = list.size();
		for(int i=0; i<size; ++i){
			pList.add( list.remove(i) );
			find(list, pList, l, idx+1, nList);
			list.add(i, pList.remove(idx));
		}
	}
}