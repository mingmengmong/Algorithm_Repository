package BOJ.S04000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ04153 {
	public static void BOJ04153(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		while(true){
			int[] arr = new int[3];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			arr[2] = sc.nextInt();
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){
				break;
			}
			
			Arrays.sort(arr);
			
			int a = arr[0] * arr[0];
			int b = arr[1] * arr[1];
			int c = arr[2] * arr[2];
			
			System.out.println((c == (a+b))?"right":"wrong");
		}
		
		sc.close();
		br.close();
	}
}
