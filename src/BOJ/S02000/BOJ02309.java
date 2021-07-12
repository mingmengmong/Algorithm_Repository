package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ02309 {
	public static void BOJ02309(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = 9;
		int r = 7;
		int[] arr = new int[n];
		int[] comArr = new int[n];
		int[] result = new int[r];
		for(int i=0; i<n; ++i){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		combination(comArr, n, r, 0, 0, arr, result);
		
		for(int i : result){
			System.out.println(i);
		}
		
		br.close();
	}
	
	public static void combination(int[] comArr, int n, int r, int index, int target, int[] arr, int[] result){
		if(r == 0){
			int sum = 0;
			for(int i=0; i<index; ++i) {
				sum += arr[comArr[i]];
			}
			if(sum == 100){
				for(int i=0; i<index; ++i) {
					result[i] = arr[comArr[i]];
				}
			}
		}else if(target == n){
			return;
		}else{
			comArr[index] = target;
			combination(comArr, n, r-1, index+1, target+1, arr, result);
			combination(comArr, n, r, index, target+1, arr, result);
		}
	}
}
