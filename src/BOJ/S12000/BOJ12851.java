package BOJ.S12000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12851 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int n1;
	public static int n2;
	public static int[][] arr = new int[100001][2];
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ12851(String[] args) throws Exception {
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		for(int i=0; i<=100000; ++i){
			arr[i][0] = -1;
		}
		
		list.add(n1);
		arr[n1][0] = 0;
		arr[n1][1] = 1;
		while(!list.isEmpty()){
			int n = list.remove(0);
			int l = arr[n][0] + 1;
			int cnt = arr[n][1];
			
			if(n == n2){
				break;
			}
			
			
			check(n-1, l, cnt);
			check(n+1, l, cnt);
			check(n*2, l, cnt);
		}
		
		System.out.println(arr[n2][0]);
		System.out.println(arr[n2][1]);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void check(int nn, int l, int cnt){
		if(nn < 0 || nn > 100000){
			return;
		}
		
		if(arr[nn][0] < 0){
			arr[nn][0] = l;
			arr[nn][1] += cnt;
			list.add(nn);
		}else if(arr[nn][0] == l){
			arr[nn][1] += cnt;
		}
	}
}