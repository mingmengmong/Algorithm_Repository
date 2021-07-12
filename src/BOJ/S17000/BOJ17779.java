package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17779 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	public static Scanner sc = new Scanner(System.in);
//	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int[][] arr;
	
	public static int[] rd = {-1, 1,  1, -1};
	public static int[] cd = { 1, 1, -1, -1};
	
	public static class Node implements Comparable<Node>{
		public int r;
		public int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			if(this.r > o.r){
				return 1;
			}else if(this.r == o.r){
				if(this.c > o.c){
					return 1;
				}else if(this.c == o.c){
					return 0;
				}else{
					return -1;
				}
			}else{
				return -1;
			}
		}
		@Override
		public String toString() {
			return "(" +
					"" + r +
					", " + c +
					')';
		}
	}
	
	public static void BOJ17779(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		int[] sumArr = new int[5];
		for(int d1=1; d1<N-1; ++d1){
			for(int d2=1; d2<N-d1; ++d2){
				int[] length = {d1,d2,d1,d2};
				for(int i=d1; i<N-d2; ++i){
					for(int j=0; j<N-d1-d2; ++j){
						int r = i;
						int c = j;
						
						List<Node> vertex = new ArrayList<>();
						List<Node> edge = new ArrayList<>();
						
						for(int k=0; k<4; ++k){
							vertex.add(new Node(r,c));
							for(int m=0; m<length[k]; ++m){
								r += rd[k];
								c += cd[k];
								edge.add(new Node(r,c));
							}
						}
						
						sumArea(sumArr, vertex, d1, d2);
						
						sumArr[4] = sumArea5(edge, d1+d2);
						
						result = Math.min(result, peopleDistance(sumArr));
					}
				}
			}
		}
		
		System.out.println(result);
		
//		sc.close();
		bw.close();
		br.close();
	}
	
	public static int sumArea5(List<Node> edge, int h){
		Collections.sort(edge);
		int sum = 0;
		Node n1 = edge.remove(h*2-1);
		Node n2 = edge.remove(0);
		sum += arr[n1.r][n1.c];
		sum += arr[n2.r][n2.c];
		for(int i=0; i<h-1; ++i){
			n1 = edge.remove(0);
			n2 = edge.remove(0);
			int r = n1.r;
			int c1 = n1.c;
			int c2 = n2.c;
			for(int c=c1; c<=c2; ++c){
				sum += arr[r][c];
			}
		}
		return sum;
	}
	
	public static void sumArea(int[] sumArr, List<Node> vertex, int d1, int d2){
		sumArr[0] = sumArea1(vertex.get(0), d1);
//		System.out.println("s[0] : " + sumArr[0]);
		sumArr[1] = sumArea2(vertex.get(1), d2);
//		System.out.println("s[1] : " + sumArr[1]);
		sumArr[2] = sumArea3(vertex.get(2), d1);
//		System.out.println("s[2] : " + sumArr[2]);
		sumArr[3] = sumArea4(vertex.get(3), d2);
//		System.out.println("s[3] : " + sumArr[3]);
	}
	
	public static int sumArea1(Node v1, int d1){
		int sum = 0;
		int r = v1.r;
		int c = v1.c;
		for(int i=0; i<d1; ++i){
			r += rd[0];
			c += cd[0];
			for(int j=0; j<c; ++j){
				sum += arr[r][j];
			}
		}
		for(int i=0; i<r; ++i){
			for(int j=0; j<=c; ++j){
				sum += arr[i][j];
			}
		}
		return sum;
	}
	public static int sumArea2(Node v2, int d2){
		int sum = 0;
		int r = v2.r;
		int c = v2.c;
		for(int i=0; i<d2; ++i){
			r += rd[1];
			c += cd[1];
			for(int j=0; j<r; ++j){
				sum += arr[j][c];
			}
		}
		for(int i=c+1; i<N; ++i){
			for(int j=0; j<=r; ++j){
				sum += arr[j][i];
			}
		}
		return sum;
	}
	public static int sumArea3(Node v3, int d1){
		int sum = 0;
		int r = v3.r;
		int c = v3.c;
		for(int i=0; i<d1; ++i){
			r += rd[2];
			c += cd[2];
			for(int j=c+1; j<N; ++j){
				sum += arr[r][j];
			}
		}
		for(int i=r+1; i<N; ++i){
			for(int j=c; j<N; ++j){
				sum += arr[i][j];
			}
		}
		return sum;
	}
	public static int sumArea4(Node v4, int d2){
		int sum = 0;
		int r = v4.r;
		int c = v4.c;
		for(int i=0; i<d2; ++i){
			r += rd[3];
			c += cd[3];
			for(int j=r+1; j<N; ++j){
				sum += arr[j][c];
			}
		}
		for(int i=0; i<c; ++i){
			for(int j=r; j<N; ++j){
				sum += arr[j][i];
			}
		}
		return sum;
	}
	
	public static int peopleDistance(int[] sumArr){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<5; ++i){
			max = Math.max(max, sumArr[i]);
			min = Math.min(min, sumArr[i]);
		}
		return max-min;
	}
}