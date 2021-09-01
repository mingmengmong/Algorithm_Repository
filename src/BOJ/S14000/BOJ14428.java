package BOJ.S14000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14428 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int MAX=18, N, MAXN=100_000, M, WRONG = -1;
	static int[] base = new int[MAXN+1];
	static int[] arr = new int[1<<MAX];
	
	static int find(int idx, int startIdx, int endIdx, int findStartIdx, int findEndIdx){
		if(findStartIdx <= startIdx && endIdx <= findEndIdx){
			return arr[idx];
		}
		if(findEndIdx < startIdx || endIdx < findStartIdx){
			return WRONG;
		}
		
		int mid = (startIdx + endIdx) >>> 1;
		int left = find(idx*2, startIdx, mid, findStartIdx, findEndIdx);
		int right = find(idx*2+1, mid+1, endIdx, findStartIdx, findEndIdx);
		if(left == -1 && right == -1) return WRONG;
		else if(left == -1) return right;
		else if(right == -1) return left;
		else{
			if(base[left] <= base[right]) return left;
			else return right;
		}
	}
	
	static int find(int idx, int startIdx, int endIdx){
		if(arr[idx] != 0) return arr[idx];
		if(startIdx == endIdx){
			if(arr[idx] == 0){
				arr[idx] = startIdx;
			}
			return arr[idx];
		}
		
		int mid = (startIdx + endIdx) >>> 1;
		int left = find(idx*2, startIdx, mid);
		int right = find(idx*2+1, mid+1, endIdx);
		return arr[idx] = (base[left] <= base[right] ? left : right);
	}
	
	static int update(int idx, int changeIdx, int startIdx, int endIdx){
		if(startIdx == endIdx && changeIdx == startIdx){
			arr[idx] = changeIdx;
			return arr[idx];
		}
		
		int mid = (startIdx + endIdx) >>> 1;
		int left, right;
		if(startIdx <= changeIdx && changeIdx <= mid){
			left = update(idx*2, changeIdx, startIdx, mid);
			right = find(idx*2+1, mid+1, endIdx);
		}else{
			left = find(idx*2, startIdx, mid);
			right = update(idx*2+1, changeIdx, mid+1, endIdx);
		}
		return arr[idx] = (base[left] <= base[right] ? left : right);
	}
	
	public static void BOJ14428(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; ++i){
			base[i] = Integer.parseInt(st.nextToken());
		}
		
		find(1, 1, N);
		
		M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if(cmd == 1){
				// update
				base[i] = j;
				update(1, i, 1, N);
			}else{
				System.out.println(find(1, 1, N, i, j));
			}
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}