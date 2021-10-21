import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01708 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Point{
		public long x, y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return String.format("(%d, %d)", x,y);
		}
	}
	
	static int ccw(Point p1, Point p2, Point p3) {
		long x1 = p1.x, y1 = p1.y;
		long x2 = p2.x, y2 = p2.y;
		long x3 = p3.x, y3 = p3.y;
		long temp = x1*y2+x2*y3+x3*y1 - y1*x2-y2*x3-y3*x1;
		if (temp > 0) return 1;
		else if(temp < 0) return -1;
		else return 0;
	}
	
	static int N;
	static Point pivot;
	static List<Point> list = new ArrayList<>();
	
	public static void BOJ01708 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			list.add( new Point(
					Long.parseLong(st.nextToken()),
					Long.parseLong(st.nextToken())
			));
		}
		
		list.sort((p1, p2) -> {
			if(p1.y == p2.y) return Long.compare(p1.x, p2.x);
			return Long.compare(p1.y, p2.y);
		});
		
		pivot = list.get(0);
		
		list.sort((p1, p2) -> {
			long d1 = (pivot.x - p2.x)*(pivot.y - p1.y);
			long d2 = (pivot.x - p1.x)*(pivot.y - p2.y);
			if(d1 == d2) {
				if(p1.y == p2.y) return Long.compare(p1.x, p2.x);
				return Long.compare(p1.y, p2.y);
			}
			return Long.compare(d1, d2);
		});
		
		List<Point> list2 = new ArrayList<>();
		for(int i=0; i<N; ++i){
			if(list2.size() < 2){
				list2.add(0, list.get(i));
				continue;
			}
			
			Point now = list.get(i);
			while(list2.size() >= 2 && ccw(list2.get(1), list2.get(0), now) < 1){
				list2.remove(0);
			}
			
			list2.add(0, now);
		}
		
		System.out.println(list2.size());
		
		br.close();
		bw.close();
		sc.close();
	}
}