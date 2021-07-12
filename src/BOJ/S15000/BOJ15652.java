package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15652 {
	public static void BOJ15652(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; ++i){
			list.add(i);
		}
		
		permutation(list, new ArrayList<Integer>(), M, 0);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void permutation(List<Integer> list, List<Integer> pList, int l, int idx){
		if(l == idx){
			for(int i: pList){
				System.out.print(i + " ");
			}
			System.out.println();
			
			return;
		}
		
		int length = list.size();
		for(int i=idx > 0 ? pList.get(idx-1)-1 : 0; i<length; ++i){
			pList.add( list.get(i) );
			permutation(list, pList, l, idx+1);
			pList.remove(idx);
		}
	}
}