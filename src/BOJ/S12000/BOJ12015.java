package BOJ.S12000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12015 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	
	
	public static void BOJ12015(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		list.add(Integer.parseInt(st.nextToken()));
		for(int i=1; i<N; ++i){
			int n = Integer.parseInt(st.nextToken());
			int size = list.size();
			int idx = lowerBound(list, 0, size-1, n);
			
			int num = list.get(idx);
			if(num < n){
				if((idx+1) == size){
					list.add(n);
				}else{
					list.set(idx + 1, n);
				}
			}else{
				list.set(idx, n);
			}
		}
		
		System.out.println(list);
		System.out.println(list.size());
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int lowerBound(List<Integer> list, int sIdx, int eIdx, int num){
		if(sIdx == eIdx){
			return sIdx;
		}
		
		int mid = (sIdx + eIdx) / 2;
		if(list.get(mid) >= num){
			return lowerBound(list, sIdx, mid, num);
		}else{
			return lowerBound(list, mid+1, eIdx, num);
		}
	}
}