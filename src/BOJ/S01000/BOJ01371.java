package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01371 {
	public static void BOJ01371(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[26];
		int max = 0;
		String str;
		while((str = br.readLine()) != null){
			int l = str.length();
			for(int i=0; i<l; ++i){
				char c = str.charAt(i);
				if('a' <= c && c <= 'z'){
					++arr[c-'a'];
					max = Math.max(max, arr[c-'a']);
				}
			}
		}
		
		for(int i=0; i<26; ++i){
			if(arr[i] == max) {
				System.out.print((char)('a'+i));
			}
		}
		System.out.println();
		
		sc.close();
		br.close();
	}
}