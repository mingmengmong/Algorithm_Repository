package BOJ.S14000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14650 {
	public static void BOJ14650(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		System.out.println(makeNumber(numArr, N - 1, 0, 1) + makeNumber(numArr, N - 1, 0, 2));
		
		
		br.close();
	}
	
	public static int makeNumber(int[] numArr, int length, int index, int targetNum){
		numArr[index] = targetNum;
		int result = 0;
		
		if(length == index){
			int sum = 0;
			for(int i : numArr){
				sum += i;
			}
			if((sum % 3) == 0){
				result = 1;
			}
		}else{
			result = makeNumber(numArr, length, index+1, 0)
					+ makeNumber(numArr, length, index+1, 1)
					+ makeNumber(numArr, length, index+1, 2);
		}
		return result;
	}
}
