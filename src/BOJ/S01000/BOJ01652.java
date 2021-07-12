package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ01652 {
	public static void BOJ01652(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int rowCnt = 0;
		int colCnt = 0;
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; ++i){
			String str = sc.next();
			int lastIndex = -1;
			for(int j=0; j<N; ++j){
				if(str.charAt(j) == 'X'){
					if((j-lastIndex) > 2){
						++rowCnt;
					}
					lastIndex = j;
					
					list.get(j).add(i);
				}
			}
			if((N-lastIndex) > 2){
				++rowCnt;
			}
		}
		
		for(List<Integer> iter : list){
			int lastIndex = -1;
			for(int i : iter){
				if((i-lastIndex) > 2){
					++colCnt;
				}
				lastIndex = i;
			}
			if ((N - lastIndex) > 2) {
				++colCnt;
			}
		}
		
		System.out.printf("%d %d\n", rowCnt, colCnt);
		
		sc.close();
		br.close();
	}
}