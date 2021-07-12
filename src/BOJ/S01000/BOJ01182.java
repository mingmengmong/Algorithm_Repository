package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01182 {
	public static int result = 0;
	
	public static void BOJ01182(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		int N = Integer.parseInt(strSpl[0]);
		int S = Integer.parseInt(strSpl[1]);
		
		int[] arr = new int[N];
		strSpl = br.readLine().split(" ");
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(strSpl[i]);
		}
		
		for(int i=1; i<=N; ++i){
			int[] comArr = new int[i];
			combination(comArr, N, i, 0, 0, arr, S);
		}
		
		System.out.println(result);
		
		br.close();
	}
	
	public static void combination(int[] comArr, int n, int r, int index, int target, int[] arr, int s){
		if(r == 0){
			int sum = 0;
			for(int i=0; i<index; ++i) {
				sum += arr[comArr[i]];
			}
			if(sum == s){
				result++;
			}
		}else if(target == n){
			return;
		}else{
			comArr[index] = target;
			combination(comArr, n, r-1, index+1, target+1, arr, s);
			combination(comArr, n, r, index, target+1, arr, s);
		}
	}
}
