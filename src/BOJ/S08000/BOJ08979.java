package BOJ.S08000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ08979 {
	public static void BOJ08979() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		int N = Integer.parseInt(strSpl[0]);
		int M = Integer.parseInt(strSpl[1]);
		
		List<Grade> medalList = new ArrayList<>();
		
		for(int i=0; i<N; ++i){
			strSpl = br.readLine().split(" ");
			medalList.add(new Grade(
					Integer.parseInt(strSpl[0]),
					Integer.parseInt(strSpl[1]),
					Integer.parseInt(strSpl[2]),
					Integer.parseInt(strSpl[3])
			));
		}
		
		Collections.sort(medalList, new Comparator<Grade>() {
			@Override
			public int compare(Grade o1, Grade o2) {
				return Long.compareUnsigned(o1.grade, o2.grade) * -1;
			}
		});
		
		long grade = 0;
		for(int i=0; i<N; ++i){
			Grade g = medalList.get(i);
			if(M == g.num){
				grade = g.grade;
			}
		}
		
		for(int i=0; i<N; ++i){
			Grade g = medalList.get(i);
			if( Long.compareUnsigned(grade, g.grade) >= 0 ){
				System.out.println(i+1);
				break;
			}
		}
		
		br.close();
	}
	
	public static class Grade{
		public int num;
		public int g;
		public int s;
		public int b;
		
		public long grade;
		
		public Grade(int num, int g, int s, int b){
			this.num = num;
			this.g = g;
			this.s = s;
			this.b = b;
			
			this.grade = g * 1000000000000l + s * 1000000l + b * 1l;
		}
	}
}

