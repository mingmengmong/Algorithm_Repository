package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14939 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[] rd = {0, 1, -1, 0,  0};
	public static int[] cd = {0, 0,  0, 1, -1};
	
	public static void push(boolean[][] arr, int r, int c){
		for(int i=0; i<5; ++i){
			int nr = r + rd[i];
			int nc = c + cd[i];
			try{
				arr[nr][nc] = !arr[nr][nc];
			}catch(Exception e){}
		}
	}

	public static boolean[][] copy(boolean[][] arr){
		boolean[][] r = new boolean[10][10];
		for(int i=0; i<10; ++i){
			for(int j=0; j<10; ++j){
				r[i][j] = arr[i][j];
			}
		}
		return r;
	}

	public static void print(boolean[][] arr){
		for(int i=0; i<10; ++i){
			for(int j=0; j<10; ++j){
				System.out.print(arr[i][j]?1:0);
			}
			System.out.println();
		}
	}

	public static void BOJ14939(String[] args) throws Exception {
		boolean[][] temp = new boolean[10][10];
		for(int i=0; i<10; ++i){
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<10; ++j){
				temp[i][j] = str[j] == 'O';
			}
		}

		int result = Integer.MAX_VALUE;
		for(int i=0; i<1024; ++i){
			int cnt = 0;
			boolean[][] arr = copy(temp);
			for(int j=0; j<10; ++j){
				if((i&(1<<j)) > 0){
					++cnt;
					push(arr, 0, j);
				}
			}

			for(int j=1; j<10; ++j){
				for(int k=0; k<10; ++k){
					if(arr[j-1][k]){
						++cnt;
						push(arr, j, k);
					}
				}
			}

			boolean b = true;
			for(int j=0; j<10; ++j){
				if(arr[9][j]){
					b = false;
					break;
				}
			}
			if(b){
				result = Math.min(result, cnt);
			}
		}
		if(result == Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(result);
		}


		sc.close();
		bw.close();
		br.close();
	}
}