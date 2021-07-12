package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ09252 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void BOJ09252(String[] args) throws Exception {
		String str1 = " " + sc.nextLine();
		String str2 = " " + sc.nextLine();
		
		int l1 = str1.length();
		int l2 = str2.length();
		
		int[][] arr = new int[l1][l2];
		for(int i=1; i<l1; ++i){
			for(int j=1; j<l2; ++j){
				if(str1.charAt(i) == str2.charAt(j)){
					arr[i][j] = arr[i-1][j-1] + 1;
				}else{
					arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
				}
			}
		}
		
		int r = l1-1;
		int c = l2-1;
		int n = arr[r][c];
		
		System.out.println(n);
		
		while(arr[r][c] != 0){
			if(arr[r][c-1] == n){
				--c;
			}else if(arr[r-1][c] == n){
				--r;
			}else{
				sb.append(str1.charAt(r));
				--r;
				--c;
				n = arr[r][c];
			}
		}
		System.out.println(sb.reverse());
		
		sc.close();
		bw.close();
		br.close();
	}
}