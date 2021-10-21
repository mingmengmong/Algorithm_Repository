import java.io.*;
import java.util.*;
import java.math.*;

public class BOJ01704 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int[] RD = {0, 1, -1, 0,  0};
	static int[] CD = {0, 0,  0, 1, -1};
	
	static int N, M, MAX = Integer.MAX_VALUE;
	static boolean FLAG = false;
	static int[][] board = new int[20][20], arr1 = new int[20][20], arr2 = new int[20][20], res = new int[20][20];
	
	static void change(int r, int c){
		for(int i=0; i<5; ++i){
			int nr = r + RD[i];
			int nc = c + CD[i];
			arr1[nr][nc] ^= 1;
		}
	}
	
	public static void BOJ01704 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; ++j)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int resCnt = MAX;
		for(int idx=0; idx<(1<<M); ++idx){
			// clear
			int cnt = 0;
			for(int r=1; r<=N; ++r){
				for(int c=1; c<=M; ++c){
					arr1[r][c] = board[r][c];
					arr2[r][c] = 0;
				}
			}
			
			// idx 변경
			for(int i=0; i<M; ++i){
				if((idx & (1<<i)) > 0){
					int r = 1;
					int c = i+1;
					++cnt;
					arr2[r][c] = 1;
					change(r,c);
				}
			}
			
			for(int r=2; r<=N; ++r){
				for(int c=1; c<=M; ++c){
					if(arr1[r-1][c] == 1){
						++cnt;
						arr2[r][c] = 1;
						change(r,c);
					}
				}
			}
			
			boolean flag = true;
			for(int c=1; c<=M; ++c){
				if(arr1[N][c] == 1){
					flag = false;
					break;
				}
			}
			
			if(flag){
				FLAG = true;
				if(cnt < resCnt){
					resCnt = cnt;
					for(int r=1; r<=N; ++r){
						for(int c=1; c<=M; ++c){
							res[r][c] = arr2[r][c];
						}
					}
				}else if(cnt == resCnt){
					boolean isChange = false;
					aaa : for(int r=1; r<=N; ++r){
						for(int c=1; c<=M; ++c){
							if(arr2[r][c] == res[r][c]) continue;
							if(arr2[r][c] < res[r][c]) isChange = true;
							break aaa;
						}
					}
					
					if(isChange){
						for(int r=1; r<=N; ++r){
							for(int c=1; c<=M; ++c){
								res[r][c] = arr2[r][c];
							}
						}
					}
				}
			}
		}
		
		if(!FLAG) System.out.println("IMPOSSIBLE");
		else{
			for(int r=1; r<=N; ++r){
				for(int c=1; c<=M; ++c){
					System.out.printf("%d ", res[r][c]);
				}
				System.out.println();
			}
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}