import java.io.*;
import java.util.*;

public class BOJ02162 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int a = x1 * y2 + x2 * y3 + x3 * y1;
		int b = y1 * x2 + y2 * x3 + y3 * x1;
		return Integer.compare(a - b, 0);
	}
	
	static int N, MAX = 3000;
	static int[] arr;
	static int[] cnt;
	static boolean[] visit;
	static int[][][] P;
	static{
		arr = new int[MAX+1];
		for(int i=0; i<=MAX; ++i) arr[i] = i;
		
		cnt = new int[MAX+1];
		Arrays.fill(cnt, 1);
		
		visit = new boolean[MAX+1];
		P = new int[MAX+1][2][2];
	}
	
	static int find(int a){
		if(a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}
	
	static void union(int a, int b){
		int aa = find(a);
		int bb = find(b);
		if(aa == bb) return;
		arr[bb] = aa;
		cnt[aa] += cnt[bb];
		find(b);
	}
	
	public static void BOJ02162 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			P[i][0][0] = r1;
			P[i][0][1] = c1;
			P[i][1][0] = r2;
			P[i][1][1] = c2;
			
//			// [0][0] < [1][0]
//			if(r1 < r2){
//
//			}else if(r2 < r1){
//				P[i][0][0] = r2;
//				P[i][0][1] = c2;
//				P[i][1][0] = r1;
//				P[i][1][1] = c1;
//			}else{
//				// [0][1] < [1][1]
//				if(c1 < c2){
//					P[i][0][0] = r1;
//					P[i][0][1] = c1;
//					P[i][1][0] = r2;
//					P[i][1][1] = c2;
//				}else{
//					P[i][0][0] = r2;
//					P[i][0][1] = c2;
//					P[i][1][0] = r1;
//					P[i][1][1] = c1;
//				}
//			}
			
			
			for(int j=0; j<i; ++j){
				if(find(i) == find(j)) continue;
				
				
				int ccw1 = ccw(P[i][0][0], P[i][0][1], P[i][1][0], P[i][1][1], P[j][0][0], P[j][0][1]);
				int ccw2 = ccw(P[i][0][0], P[i][0][1], P[i][1][0], P[i][1][1], P[j][1][0], P[j][1][1]);
				int ccw3 = ccw(P[j][0][0], P[j][0][1], P[j][1][0], P[j][1][1], P[i][0][0], P[i][0][1]);
				int ccw4 = ccw(P[j][0][0], P[j][0][1], P[j][1][0], P[j][1][1], P[i][1][0], P[i][1][1]);
				
				if(ccw1 == 0 || ccw2 == 0 || ccw3 == 0 || ccw4 == 0){
					int zeroCnt = 0;
					if(ccw1 == 0) ++zeroCnt;
					if(ccw2 == 0) ++zeroCnt;
					if(ccw3 == 0) ++zeroCnt;
					if(ccw4 == 0) ++zeroCnt;
					
//					System.out.println(zeroCnt);
					
					if(zeroCnt == 1){
						// 한 선분의 연장상 하나의 점이 존재
						if(ccw1 == 0 || ccw2 == 0){
							if(ccw3 * ccw4 < 0){
								union(i,j);
							}
						}else{
							if(ccw1 * ccw2 < 0){
								union(i,j);
							}
						}
					}else if(zeroCnt == 2){
						// 두 선분의 점 하나가 겹침
						union(i,j);
					}else if(zeroCnt == 4){
						// 일직선 상 두개의 선분이 존재
						if(P[i][0][0] == P[i][1][0]){
							int minC1 = Math.min(P[i][0][1], P[i][1][1]);
							int maxC1 = Math.max(P[i][0][1], P[i][1][1]);
							int minC2 = Math.min(P[j][0][1], P[j][1][1]);
							int maxC2 = Math.max(P[j][0][1], P[j][1][1]);
							if(minC1 <= P[j][0][1] && P[j][0][1] <= maxC1){
								union(i,j);
							}else if(minC1 <= P[j][1][1] && P[j][1][1] <= maxC1){
								union(i,j);
							}else if(minC2 <= P[i][0][1] && P[i][0][1] <= maxC2){
								union(i,j);
							}else if(minC2 <= P[i][1][1] && P[i][1][1] <= maxC2){
								union(i,j);
							}
						}else{
							int minR1 = Math.min(P[i][0][0], P[i][1][0]);
							int maxR1 = Math.max(P[i][0][0], P[i][1][0]);
							int minR2 = Math.min(P[j][0][0], P[j][1][0]);
							int maxR2 = Math.max(P[j][0][0], P[j][1][0]);
							if(minR1 <= P[j][0][0] && P[j][0][0] <= maxR1){
								union(i,j);
							}else if(minR1 <= P[j][1][0] && P[j][1][0] <= maxR1){
								union(i,j);
							}else if(minR2 <= P[i][0][0] && P[i][0][0] <= maxR2){
								union(i,j);
							}else if(minR2 <= P[i][1][0] && P[i][1][0] <= maxR2){
								union(i,j);
							}
						}
					}
				}else{
					int res1 = ccw1 * ccw2;
					int res2 = ccw3 * ccw4;
					if(res1 < 0 && res2 < 0){
						// 교차
						union(i,j);
					}
				}
			}
		}
		
		int res1 = 0;
		int res2 = 0;
		for(int i=0; i<N; ++i){
			int fi = find(i);
			if(!visit[fi]){
				visit[fi] = true;
				++res1;
				res2 = Math.max(res2, cnt[fi]);
			}
		}
		
		System.out.println(res1);
		System.out.println(res2);
		
		br.close();
		bw.close();
		sc.close();
	}
}