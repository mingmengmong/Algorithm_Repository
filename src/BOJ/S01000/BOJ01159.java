package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01159 {
	public static void BOJ01159(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int[] arr = new int[26];
		for(int i=0; i<N; ++i){
			++arr[sc.next().charAt(0)-'a'];
		}
		
		String result = "";
		for(int i=0; i<26; ++i){
			if(arr[i] >= 5){
				result += (char)(i+'a');
			}
		}
		
		System.out.println(result.length()==0?"PREDAJA":result);
		
		sc.close();
		br.close();
	}
}