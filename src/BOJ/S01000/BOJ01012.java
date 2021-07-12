package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01012 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static void BOJ01012(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[][] arr = new boolean[R][C];
			for(int i=0; i<M; ++i){
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[r][c] = true;
			}
			int result = 0;
			for(int i=0; i<R; ++i){
				for(int j=0; j<C; ++j){
					if(arr[i][j]){
						++result;
						List<Integer> list = new ArrayList<>();
						list.add(i*C+j);
						while(!list.isEmpty()){
							int n = list.remove(0);
							int r = n/C;
							int c = n%C;
							if(!arr[r][c]){
								continue;
							}
							arr[r][c] = false;
							for(int k=0; k<4; ++k){
								int nr = r + rd[k];
								int nc = c + cd[k];
								try{
									if(arr[nr][nc]){
										list.add(nr*C+nc);
									}
								}catch(Exception e){}
							}
						}
					}
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
		
		
		sc.close();
		bw.close();
		br.close();
	}
}