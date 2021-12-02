import java.io.*;
import java.util.*;

public class BOJ13537 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX=100_000;
	static int[] arr = new int[MAX+1];
	static int[][] seg = new int[MAX<<2][];
	static{
		Arrays.fill(seg, new int[0]);
	}
	static void init(int l, int r, int idx){
		if(r < l) {
			return;
		}
		if(l == r){
			seg[idx] = new int[]{arr[l]};
//			System.out.printf("%d : %s\n", idx, Arrays.toString(seg[idx]));
			return;
		}
		
		// (l ~ mid), (mid+1 ~ r)
		int mid = (l+r) >>> 1;
		init(l, mid, idx<<1);
		init(mid+1, r, (idx<<1)+1);
		
		int[] left = seg[idx<<1];
		int[] right = seg[(idx<<1)+1];
		int li = 0, ll = left.length, ri = 0, rl = right.length, i=0;
		seg[idx] = new int[ll+rl];
		while(li<ll || ri<rl){
			if(ri==rl || (li<ll && left[li] < right[ri])) seg[idx][i++] = left[li++];
			else seg[idx][i++] = right[ri++];
		}
		
//		System.out.printf("%d : %s\n", idx, Arrays.toString(seg[idx]));
	}
	
	static int find(int l, int r, int idx, int tl, int tr, int target){
		if(r<l) return 0;
		if(tr<l || r<tl) return 0;
		if(tl<=l && r<=tr){
//			System.out.printf("%d [%d-%d] : %s\n", idx,l,r, Arrays.toString(seg[idx]));
			return seg[idx].length - lowerBound(seg[idx], target);
		}
		
		int mid = (l+r) >>> 1;
		int res = find(l, mid, idx<<1, tl, tr, target) + find(mid+1, r, (idx<<1)+1, tl, tr, target);
		return res;
	}
	
	static int lowerBound(int[] arr, int target){
		int l = 0, r = arr.length;
		while(l < r){
			int m = (l+r) >>> 1;
			if(arr[m] >= target) r = m;
			else l = m+1;
		}
		return l;
	}
	
	public static void BOJ13537(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader("input"));
//		sc = new Scanner(new File("input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(0, N-1, 1);
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken())+1;
//			System.out.printf("%d %d %d\n", s,e,t);
			bw.write(String.valueOf(find(0,N-1,1, s,e,t)));
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}