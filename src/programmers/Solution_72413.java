import java.util.*;
import java.text.*;
import java.util.stream.*;


public class Solution_72413 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/72413
	 * name : 합승 택시 요금
	 */
	
	static int N, MAXN = 200;
	static int[][] arr = new int[MAXN+1][MAXN+1];
	static{
		for(int i=0; i<=MAXN; ++i){
			Arrays.fill(arr[i], 1_000_000_000);
			arr[i][i] = 0;
		}
	}
	
	public int solution(int n, int S, int A, int B, int[][] fares) {
		N = n;
		for(int[] iter : fares){
			int u = iter[0];
			int v = iter[1];
			int c = iter[2];
			arr[u][v] = arr[v][u] = c;
		}
		
		for(int k=1; k<=N; ++k){
			for(int s=1; s<=N; ++s){
				for(int e=1; e<=N; ++e){
					arr[s][e] = Math.min(arr[s][e], arr[s][k] + arr[k][e]);
				}
			}
		}
		
		int res = 1_000_000_000;
		for(int k=1; k<=N; ++k){
			res = Math.min(res, arr[S][k]+arr[k][A]+arr[k][B]);
		}
		
		return res;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		System.out.println();
		//
	}
}