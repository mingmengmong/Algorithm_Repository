package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ02293 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int G;
	public static int[][] arr;
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ02293(String[] args) throws Exception {
		N = sc.nextInt();
		G = sc.nextInt();
		for (int i = 0; i < N; ++i) {
			int n = sc.nextInt();
			if (n > G) {
				continue;
			}
			if (list.contains(n)) {
				continue;
			}
			list.add(n);
		}
		Collections.sort(list);
		N = list.size();
//		System.out.println(list);
		
		arr = new int[N][G + 1];
		
		for(int i=1; i<=G; ++i){
			for(int j=0; j<N; ++j){
				int n = i-list.get(j);
				if(n < 0){
					continue;
				}
				if(n == 0){
					arr[j][i] = 1;
					continue;
				}
				
				for(int k=j; k<N; ++k){
					arr[j][i] += arr[k][n];
				}
			}
		}
		
//		for(int i=0; i<N; ++i){
//			for(int j=0; j<=G; ++j){
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int result = 0;
		for(int i=0; i<N; ++i){
			result += arr[i][G];
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}

/*


10   1 2 5
    0 1 2 3 4 5 6 7 8 9 10
1   1 1 1 2 2 3 4 5
2   1 0 1 0 1 0 1 1
5   1 0 0 0 0 1 0 0

 */