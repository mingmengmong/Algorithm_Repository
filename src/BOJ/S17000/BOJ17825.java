package BOJ.S17000;
import java.io.*;
import java.util.*;

public class BOJ17825 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	//	public static int[][] arr = {
//			{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38},
//			{10,13,16,19},
//			{20,22,24},
//			{30,28,27,26},
//			{25,30,35},
//			{40,0}
//	};
//	public static Road road;
//	public static class Road{
//		private RoadNode root;
//		public Road(){
//			root = new RoadNode();
//		}
//		public Road(RoadNode root){
//			this.root = root;
//		}
//	}
	public static Road road;
	public static class Road {
		public int num;
		public boolean isLast;
		public Road red;
		public Road blue;
		public Road(){}
		public Road(int num){
			this.num = num;
		}
		public Road(boolean isLast){
			this.isLast = isLast;
			this.num = 0;
		}
		public Road move(int n, boolean isFirst){
			if(n == 0){
				return this;
			}
			if(isLast){
				return this;
			}
			if(isFirst){
				if(blue != null){
					return blue.move(n-1, false);
				}
			}
			return red.move(n-1, false);
		}
		public Road move(int n){
			return move(n, true);
		}
		public String toString(){
			return String.format("num : " + num);
		}
	}
	static{
		road = new Road(0);
		Road road1 = road;
		road1.red = new Road(2); road1 = road1.red;
		road1.red = new Road(4); road1 = road1.red;
		road1.red = new Road(6); road1 = road1.red;
		road1.red = new Road(8); road1 = road1.red;
		road1.red = new Road(10); road1 = road1.red;
		road1.red = new Road(12); road1.blue = new Road(13);
		Road road2 = road1.blue;
		road1 = road1.red;
		
		road1.red = new Road(14); road1 = road1.red;
		road1.red = new Road(16); road1 = road1.red;
		road1.red = new Road(18); road1 = road1.red;
		road1.red = new Road(20); road1 = road1.red;
		road1.red = new Road(22); road1.blue = new Road(22);
		Road road3 = road1.blue;
		road1 = road1.red;
		
		road1.red = new Road(24); road1 = road1.red;
		road1.red = new Road(26); road1 = road1.red;
		road1.red = new Road(28); road1 = road1.red;
		road1.red = new Road(30); road1 = road1.red;
		road1.red = new Road(32); road1.blue = new Road(28);
		Road road4 = road1.blue;
		road1 = road1.red;
		
		road1.red = new Road(34); road1 = road1.red;
		road1.red = new Road(36); road1 = road1.red;
		road1.red = new Road(38); road1 = road1.red;
		road1.red = new Road(40); road1 = road1.red;
		road1.red = new Road(true);
		
		road2.red = new Road(16); road2 = road2.red;
		road2.red = new Road(19); road2 = road2.red;
		road2.red = new Road(25); road2 = road2.red;
		
		road3.red = new Road(24); road3 = road3.red;
		road3.red = road2;
		
		road4.red = new Road(27); road4 = road4.red;
		road4.red = new Road(26); road4 = road4.red;
		road4.red = road2;
		
		road2.red = new Road(30); road2 = road2.red;
		road2.red = new Road(35); road2 = road2.red;
		road2.red = road1;
	}
	
	public static int[] input = new int[10];

//	public static class Node{
//		public int r;
//		public int index;
//	}
	
	public static void BOJ17825(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; ++i){
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(game(0, new ArrayList<>(), 0, new int[10]));
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int game(int idx, List<Road> roadList, int sum, int[] result){
		if(idx == 10){
//			System.out.println("----------------------");
//			System.out.println(sum + " : " + Arrays.toString(result));
//			System.out.println("----------------------");
			return sum;
		}
		
		if(idx == 0){
			Road r = road.move(input[0]);
			roadList.add(r);
			result[0] = 0;
			return game(1, roadList, r.num, result);
		}
		
		int max = Integer.MIN_VALUE;
		if(roadList.size() < 4){
			Road nr = road.move(input[idx]);
			boolean b = true;
			for(Road r : roadList){
				if(r == nr){
					b = false;
					break;
				}
			}
			if(b){
				List<Road> nList = new ArrayList<Road>(){{
					for(Road r : roadList){
						add(r);
					}
					add(nr);
				}};
				result[idx] = roadList.size();
				int num = game(idx+1, nList, sum+nr.num, result);
				max = Math.max(max, num);
			}
		}
		
		for(int i=0; i<roadList.size(); ++i){
			if(roadList.get(i).isLast){
				continue;
			}
			
			int finalI = i;
			List<Road> nList = new ArrayList<Road>(){{
				for (int j = 0; j < roadList.size(); ++j) {
					if (j != finalI) {
						add(roadList.get(j));
					} else {
						add(roadList.get(j).move(input[idx]));
					}
				}
			}};
			Road nr = nList.get(i);
			boolean b = false;
			for(int j=0; j<nList.size(); ++j){
				Road r = nList.get(j);
				if(i == j){
					continue;
				}
				if(r.isLast){
					continue;
				}
				if(r == nr){
//					System.out.println(idx + " " + sum);
					b = true;
					break;
				}
			}
			if(b){
				continue;
			}
			result[idx] = i;
			int num = game(idx+1, nList, sum+nr.num, result);
			max = Math.max(num, max);
		}
		
		return max;
	}
}