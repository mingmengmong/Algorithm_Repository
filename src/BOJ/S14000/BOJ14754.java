package BOJ.S14000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ14754 {
	public static void BOJ14754(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		int row = Integer.parseInt(strSpl[0]);
		int col = Integer.parseInt(strSpl[1]);
		
		int[] rowMaxArr = new int[row];
		int[] colMaxArr = new int[col];
		
		long sum = 0;
		
		for(int r=0; r<row; ++r){
			strSpl = br.readLine().split(" ");
			for(int c=0; c<col; ++c){
				int n = Integer.parseInt(strSpl[c]);
				sum += n;
				rowMaxArr[r] = Math.max(n, rowMaxArr[r]);
				colMaxArr[c] = Math.max(n, colMaxArr[c]);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i : rowMaxArr){
			list.add(i);
			sum -= i;
		}
		for(int i : colMaxArr){
			if(!list.contains(i)){
				sum -= i;
			}
		}
		
		System.out.println(sum);
		
		sc.close();
		br.close();
	}
}
