package programmers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Solution_68645 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/68645
	 * name : 삼각 달팽이
	 */
	
	static int N, MAX = 1_000;
	static int[][] arr = new int[MAX+2][MAX+2];
	static boolean[][][] visit = new boolean[MAX+2][MAX+2][3];
	
	void init(int n){
		N = n;
		for(int i=0; i<=N+1; ++i)
			arr[N+1][i] = -1;
		arr[1][1] = 1;
	}
	static{
		for(int i=0; i<=MAX+1; ++i){
			arr[i][0] = -1;
			arr[MAX+1][i] = -1;
			for(int j=i+1; j<=MAX+1; ++j){
				arr[i][j] = -1;
			}
		}
	}
	
	void down(int r, int c){
		if(visit[r][c][0]) return;
		visit[r][c][0] = true;
		int next = arr[r+1][c];
		if(next != 0){
			right(r,c);
			return;
		}
		arr[r+1][c] = arr[r][c] + 1;
		down(r+1,c);
	}
	
	void right(int r, int c){
		if(visit[r][c][1]) return;
		visit[r][c][1] = true;
		int next = arr[r][c+1];
		if(next != 0){
			up(r,c);
			return;
		}
		arr[r][c+1] = arr[r][c] + 1;
		right(r,c+1);
	}
	
	void up(int r, int c){
		if(visit[r][c][2]) return;
		visit[r][c][2] = true;
		int next = arr[r-1][c-1];
		if(next != 0){
			down(r,c);
			return;
		}
		arr[r-1][c-1] = arr[r][c] + 1;
		up(r-1,c-1);
	}
	
	public int[] solution(int n) {
		init(n);
		int r=1, c=1, idx=0;
		while(true){
			if(visit[r][c][0] && visit[r][c][1] && visit[r][c][2]) break;
			
			if(idx == 0){
				visit[r][c][0] = true;
				int next = arr[r+1][c];
				if(next != 0){
					idx = 1;
					continue;
				}
				arr[r+1][c] = arr[r][c] + 1;
				++r;
			}else if(idx == 1){
				visit[r][c][1] = true;
				int next = arr[r][c+1];
				if(next != 0){
					idx = 2;
					continue;
				}
				arr[r][c+1] = arr[r][c] + 1;
				++c;
			}else if(idx == 2){
				visit[r][c][2] = true;
				int next = arr[r-1][c-1];
				if(next != 0){
					idx = 0;
					continue;
				}
				arr[r-1][c-1] = arr[r][c] + 1;
				--r;
				--c;
			}
		}
		
		// stack over flow err
		// down(1,1);
		
		List<Integer> res = new ArrayList<>();
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=i; ++j){
				res.add(arr[i][j]);
			}
		}
		return res.stream().flatMapToInt(IntStream::of).toArray();
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		s.solution(1000);
//		System.out.println(Arrays.toString(s.solution(5)));
	}
}