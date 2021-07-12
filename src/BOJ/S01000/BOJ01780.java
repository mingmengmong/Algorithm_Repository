package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01780 {
	public static int[] result = {0, 0, 0};
	public static int[][] arr = null;
	
	public static void BOJ01780(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; ++i){
			String[] strSpl = br.readLine().split(" ");
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(strSpl[j]) + 1;
			}
		}
		
		paper(0, 0, N);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
		
		br.close();
	}
	
	public static void paper(int r, int c, int l){
		int p = arr[r][c];
		if(l == 1){
			result[p]++;
			return;
		}
		
		boolean b = true;
		for(int i=0; b && i<l; ++i){
			for(int j=0; b && j<l; ++j){
				if(arr[r+i][c+j] != p){
					b = false;
				}
			}
		}
		
		if(b){
			result[p]++;
			return;
		}
		
		
		int nl = l/3;
		for(int i=0; i<3; ++i){
			for(int j=0; j<3; ++j){
				paper(r + i*nl, c + j*nl, nl);
			}
		}
	}
}
